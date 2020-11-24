package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
@Profile({"production"})
public class PostgresArtDao implements ArtDao {

    @Autowired
    private JdbcTemplate template;


    @Override
    public List<Image> getAllImages() {
        return template.query("SELECT *\n" +
                "\tFROM public.\"Artwork\";",new ArtMapper());
    }



    @Override
    public Image getImageById(Integer id) {
        return template.query("SELECT *\n" +
                "\tFROM public.\"Artwork\"" +
                "WHERE \"id\"='"+id+"';",new ArtMapper()).get(0);
    }




    private class ArtMapper implements RowMapper<Image>{


        @Override
        public Image mapRow(ResultSet resultSet, int i) throws SQLException {
            Image toReturn = new Image();
            toReturn.setId(resultSet.getInt("id"));
            toReturn.setName(resultSet.getString("name"));
            toReturn.setPath(resultSet.getString("path"));
            toReturn.setDescription(resultSet.getString("description"));
            toReturn.setCategory(resultSet.getString("category"));
            return toReturn;
        }
    }
    private class IdMapper implements RowMapper<Integer>{

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer id = resultSet.getInt("id");
            return id;
        }
    }

}
