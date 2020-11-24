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
    public Integer addLicenseRequest(LicenseRequest licenseRequest) {
        return template.query("INSERT INTO public.\"LicenseRequest\"(\n" +
                " \"imageId\", name, email, \"isBusiness\", description)\n" +
                "\tVALUES ('"+ licenseRequest.getImageId()+"', '"+ licenseRequest.getName()+"', '"+ licenseRequest.getEmail()+"'," +
                " '"+ licenseRequest.getBusiness()+"', '"+ licenseRequest.getDescription()+"') returning \"id\";", new IdMapper()).get(0);

    }

    @Override
    public Image getImageById(Integer id) {
        return template.query("SELECT *\n" +
                "\tFROM public.\"Artwork\"" +
                "WHERE \"id\"='"+id+"';",new ArtMapper()).get(0);
    }

    @Override
    public Integer addCommissionRequest(CommissionRequest req) {
        return template.query("INSERT INTO public.\"Commissions\"(\n" +
                "\t name, email, description)\n" +
                "\tVALUES ('"+req.getName()+"', '"+req.getEmail()+"', '"+req.getDescription()+"') returning \"id\";",new IdMapper()).get(0);
    }

    @Override
    public LicenseRequest getLicenseById(Integer id) {
        return template.query(
                "SELECT id, \"imageId\", name, email, \"isBusiness\", description\n" +
                        "\tFROM public.\"LicenseRequest\";" +
                        "where \"id\"='"+id+"'",new LicenseRequestMapper()
        ).get(0);
    }

    @Override
    public boolean addLicense(License license) {
        template.query("INSERT INTO public.\"LicenseGranted\"(\n" +
                "\t\"imageId\", \"requestId\", \"validUntil\")\n" +
                "\tVALUES ('"+license.getImageId()+"', '"+license.getRequestId()+"', '"+license.getValidUntil()+"');",new IdMapper());
        return true;
    }

    @Override
    public List<LicenseRequest> getLicenseRequests() {
        return null;
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
    private class LicenseRequestMapper implements RowMapper<LicenseRequest>{

        @Override
        public LicenseRequest mapRow(ResultSet resultSet, int i) throws SQLException {
            LicenseRequest toReturn = new LicenseRequest();
            toReturn.setId(resultSet.getInt("id"));
            toReturn.setImageId(resultSet.getInt("imageId"));
            toReturn.setName(resultSet.getString("name"));
            toReturn.setEmail(resultSet.getString("email"));
            toReturn.setDescription(resultSet.getString("description"));
            return toReturn;
        }
    }
}
