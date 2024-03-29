package com.slaen.salen.repository.RepositoryVerification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationReposotoryUtilisateur {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public  boolean isUtilisateurExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM UTILISATEUR where  ID_UTILISATEUR =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }

    public  boolean isUtilisateurByMairieExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM UTILISATEUR where UTILISATEUR.ID_MAIRIE =?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }

    public  boolean isPlaceUtilisateurExist(Long id)
    {
        String sql = "SELECT COUNT(*) FROM AFFECTER_PLACE_UTILISATEUR  " +
                "where AFFECTER_PLACE_UTILISATEUR.ID_UTILISATEUR = ?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
        if (count >= 1)
        {
            return true;
        }
        return false;
    }
}
