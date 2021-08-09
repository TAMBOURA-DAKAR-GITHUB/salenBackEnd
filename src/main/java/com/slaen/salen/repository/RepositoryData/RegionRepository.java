package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegionRepository extends JpaRepository<Region , Long> {

    //public Page<Region> listeRegionByPage(Pageable pageable);


}
