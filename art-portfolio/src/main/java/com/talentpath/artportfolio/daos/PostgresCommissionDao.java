package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.COMMISSION_STATUS;
import com.talentpath.artportfolio.models.CommissionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile("production")
public class PostgresCommissionDao implements CommissionDao{
    @Autowired
    JdbcTemplate template;

    @Override
    public Integer addCommissionRequest(CommissionRequest req) {
        return template.query("INSERT INTO public.\"Commissions\"(\n" +
                "\t name, email, description)\n" +
                "\tVALUES ('"+req.getName()+"', '"+req.getEmail()+"', '"+req.getDescription()+"') returning \"id\";",new IdMapper()).get(0);
    }

    @Override
    public List<CommissionRequest> getCommissionRequests() {
       return template.query("SELECT * " +
               "\tFROM public.\"Commissions\";",new CommissionRequestMapper());
    }



    @Override
    public boolean updateStatus(Integer id, COMMISSION_STATUS status) {
        template.execute("UPDATE public.\"Commissions\"\n" +
                "\tSET  status='"+status+"'\n" +
                "\tWHERE \"id\"='"+id+"';");
        return true;

    }

    @Override
    public List<CommissionRequest> getPendingCommissions() {
        return template.query("SELECT * " +
                "\tFROM public.\"Commissions\"" +
                " WHERE \"status\" != 'FINISHED'" +
                "AND \"status\" != 'REJECTED';",new CommissionRequestMapper());
    }

    @Override
    public CommissionRequest getCommissionRequestById(Integer id) {
        return template.query("SELECT * " +
                "\tFROM public.\"Commissions\"" +
                "Where \"id\"='"+id+"';",new CommissionRequestMapper()).get(0);
    }

    private class CommissionRequestMapper implements RowMapper<CommissionRequest>{

        @Override
        public CommissionRequest mapRow(ResultSet resultSet, int i) throws SQLException {
            CommissionRequest toReturn = new CommissionRequest();
            toReturn.setId(resultSet.getInt("id"));
            toReturn.setName(resultSet.getString("name"));
            toReturn.setEmail(resultSet.getString("email"));
            toReturn.setDescription(resultSet.getString("description"));
            toReturn.setStatus(COMMISSION_STATUS.valueOf(resultSet.getString("status")));
            return toReturn;
        }
    }
    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer id = resultSet.getInt("id");
            return id;
        }
    }

}
