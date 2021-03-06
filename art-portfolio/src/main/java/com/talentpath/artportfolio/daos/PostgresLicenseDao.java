package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.exceptions.InvalidIndexException;
import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;
import com.talentpath.artportfolio.models.LicenseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile("production")
public class PostgresLicenseDao implements LicenseDao {
    @Autowired
    JdbcTemplate template;

    @Override
    public Integer addLicenseRequest(LicenseRequest licenseRequest) {
        return template.query("INSERT INTO public.\"LicenseRequest\"(\n" +
                " \"imageId\", name, email, \"isBusiness\", description)\n" +
                "\tVALUES ('"+ licenseRequest.getImageId()+"', '"+ licenseRequest.getName()+"', '"+ licenseRequest.getEmail()+"'," +
                " '"+ licenseRequest.getBusiness()+"', '"+ licenseRequest.getDescription()+"') returning \"id\";", new IdMapper()).get(0);

    }

    @Override
    public List<LicenseView> viewLicenses() {
        return template.query("SELECT lr.\"id\" as \"request id\", lr.\"name\" as \"licensed name\",lc.\"validUntil\" as \"license expires\", \n" +
                "\t\tar.\"id\" as \"image id\", ar.\"name\" as \"image name\"\n" +
                "\tFROM public.\"LicenseGranted\" as \"lc\"\n" +
                "\tLEFT JOIN public.\"LicenseRequest\" as \"lr\" on lc.\"requestId\" = lr.\"id\"\n" +
                "\tLEFT JOIN public.\"Artwork\" as \"ar\" on lr.\"imageId\"= ar.\"id\";",new LicenseViewMapper());
    }

    @Override
    public Integer revokeLicense(Integer id) {
        template.execute("DELETE FROM public.\"LicenseGranted\"\n" +
                "\tWHERE \"requestId\"='"+id+"';");
        return id;
    }

    @Override
    public LicenseRequest getLicenseById(Integer id) {

        return template.query(
                "SELECT \"id\", \"imageId\", \"name\", \"email\", \"isBusiness\", \"description\"\n" +
                        "\tFROM public.\"LicenseRequest\"" +
                        "where \"id\"='"+id+"'",new LicenseRequestMapper()
        ).get(0);

    }

    @Override
    public boolean addLicense(License license) {
        template.update("INSERT INTO public.\"LicenseGranted\"(\n" +
                "\t \"requestId\", \"validUntil\")\n" +
                "\tVALUES ( '"+license.getRequestId()+"', '"+license.getValidUntil()+"');");
        return true;
    }

    @Override
    public List<LicenseRequest> getLicenseRequests() {
        return template.query("SELECT * "+
                "\tFROM public.\"LicenseRequest\";",new LicenseRequestMapper());
    }



    @Override
    public List<LicenseRequest> getPendingLicenseRequests() {
        return template.query("SELECT rq.\"id\",rq.\"imageId\", rq.\"name\", rq.\"email\", rq.\"isBusiness\", rq.\"description\"\n" +
                "FROM \"LicenseRequest\" as rq\n" +
                "    LEFT JOIN \"LicenseGranted\" as t2 \n" +
                "\tON rq.\"id\" = t2.\"requestId\"\n" +
                "WHERE t2.\"requestId\" IS NULL", new LicenseRequestMapper());
    }


    private class LicenseRequestMapper implements RowMapper<LicenseRequest> {

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
    private class LicenseViewMapper implements RowMapper<LicenseView>{

        @Override
        public LicenseView mapRow(ResultSet resultSet, int i) throws SQLException {
            //SELECT lr."id" as "request id", lr."name" as "licensed name",lc."validUntil" as "license expires",
            //		ar."id" as "image id", ar."name" as "image name"
            LicenseView toReturn = new LicenseView();
            toReturn.setReqId(resultSet.getInt("request id"));
            toReturn.setLicensedName(resultSet.getString("licensed name"));
            toReturn.setImageId(resultSet.getInt("image id"));
            toReturn.setLicenseExpires(resultSet.getString("license expires"));
            toReturn.setImageName(resultSet.getString("image name"));
            return toReturn;

        }
    }
    class IdMapper implements RowMapper<Integer>{

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer id = resultSet.getInt("id");
            return id;
        }
    }
}
