package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.CommissionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresCommissionDao implements CommissionDao{
    @Autowired
    JdbcTemplate template;

    @Override
    public Integer addCommissionRequest(CommissionRequest req) {
        return template.query("INSERT INTO public.\"Commissions\"(\n" +
                "\t name, email, description)\n" +
                "\tVALUES ('"+req.getName()+"', '"+req.getEmail()+"', '"+req.getDescription()+"') returning \"id\";",new IdMapper()).get(0);
    }
    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer id = resultSet.getInt("id");
            return id;
        }
    }

}
