package com.slaen.salen.repository.RepositoryVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationReposotoryMarchand {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isMarchandExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM MARCHAND where ID_MARCHAND =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }


    public  boolean isMarchandByMarcherExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM MARCHAND , MARCHER  " +
                "where MARCHAND.ID_MARCHER= MARCHER.ID_MARCHER and MARCHAND.ID_MARCHER= ?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
