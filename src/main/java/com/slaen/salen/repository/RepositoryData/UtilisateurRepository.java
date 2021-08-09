package com.slaen.salen.repository.RepositoryData;


import com.slaen.salen.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface UtilisateurRepository extends JpaRepository<Utilisateur , Long> {

    //public Page<Utilisateur> listeUtilisateurByPage(Pageable pageable);
    Utilisateur findByCodeUtilisateur(String code);
    Utilisateur findByIdUtilisateur(long id);

     public List<Utilisateur> findByMairieIdMairie(Long id);

   @Query(value = "SELECT numero_place , libelle_marcher \n" +
           "from AFFECTER_PLACE_UTILISATEUR , UTILISATEUR , place, MARCHER\n" +
           "where UTILISATEUR.ID_UTILISATEUR= AFFECTER_PLACE_UTILISATEUR.ID_UTILISATEUR\n" +
           "and AFFECTER_PLACE_UTILISATEUR.id_place = place.id_place\n" +
           "and MARCHER.id_Marcher= place.id_Marcher\n" +
           "and UTILISATEUR.ID_UTILISATEUR= :id " , nativeQuery = true)
    public List<Object> findByAffecterplaceutilisateurUtilisateurr(@Param("id") Long id);
}
