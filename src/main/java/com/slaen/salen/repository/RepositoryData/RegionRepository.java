package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface RegionRepository extends JpaRepository<Region , Long> {

    //public Page<Region> listeRegionByPage(Pageable pageable);

    public Region findBylibelleRegion(String libelleRegion);
    // la methode pour supprimer une cle du region qui ce trouve dans la table region
    //public void deleteByCercleRegionIdRegion(long id);

//    @Query(value = "delete from cercle where cercle.id_region = :id " , nativeQuery = true)
//    ArrayList<Object> supprimeridregiontocercle(@Param("id") Long id);
//    // supprimer les communes
//    @Query(value = "delete from commune where commune.id_cercle = :id " , nativeQuery = true)
//    ArrayList<Object> supprimeridcercletocommune(@Param("id") Long id);
//    // supprimer les mairies
//    @Query(value = "delete from mairie where mairie.id_commune= :id " , nativeQuery = true)
//    ArrayList<Object> supprimeridcommunetomairie(@Param("id") Long id);
//    // suprimer les marchers
//    @Query(value = "delete from marcher where marcher.id_mairie = :id " , nativeQuery = true)
//    ArrayList<Object> supprimermarchertomairie(@Param("id") Long id);



}
