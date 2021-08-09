package com.slaen.salen.repository.RepositoryData;


import com.slaen.salen.model.Payement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PayementRepository extends JpaRepository<Payement , Long> {

    //public Page<Payement> listePayementByPage(Pageable pageable);


// la methode qui permet de recuper la liste des marchand qui son gerer par un utilisateur
    @Query(value = " SELECT distinct MARCHAND.ID_MARCHAND,  MARCHAND.PRENOM_MARCHAND ,MARCHAND.TELEPHONE_MARCHAND\n" +
            "from AFFECTER_PLACE_UTILISATEUR , UTILISATEUR , place, MARCHER , MARCHAND \n" +
            "where UTILISATEUR.ID_UTILISATEUR= AFFECTER_PLACE_UTILISATEUR.ID_UTILISATEUR\n" +
            "and AFFECTER_PLACE_UTILISATEUR.id_place = place.id_place\n" +
            "and MARCHER.id_Marcher= place.id_Marcher\n" +
            "and MARCHAND.id_Marcher= MARCHER.id_Marcher\n" +
            "and UTILISATEUR.ID_UTILISATEUR= :id " , nativeQuery = true)
    ArrayList<Object> findByMarchandByUtilisateur(@Param("id") Long id);

    // la methode qui permet de recuperer la liste places par marchand
    @Query(value = " SELECT distinct PLACE.ID_PLACE, PLACE.NUMERO_PLACE\n" +
            "from AFFECTER_PLACE_MARCHAND , MARCHAND , PLACE\n" +
            "where PLACE.id_place = AFFECTER_PLACE_MARCHAND.id_place\n" +
            "and AFFECTER_PLACE_MARCHAND.ID_MARCHAND = :id " , nativeQuery = true)
    ArrayList<Object> findByPlaceByMarchand(@Param("id") Long id);
}
