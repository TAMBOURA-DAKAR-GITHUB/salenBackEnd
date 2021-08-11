package com.slaen.salen.repository.RepositoryVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationReposotoryPlace {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isPlaceExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM PLACE where  ID_PLACE  =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }

    public  boolean isPlaceByMarcherExist(Long id)

    {
        String sql = "SELECT COUNT(*) FROM PLACE where PLACE.ID_MARCHER= ?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        System.out.println(count);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
