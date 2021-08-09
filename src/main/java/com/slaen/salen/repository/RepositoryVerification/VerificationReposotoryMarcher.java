package com.slaen.salen.repository.RepositoryVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationReposotoryMarcher {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isMairieExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM MARCHER where ID_MARCHER =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
