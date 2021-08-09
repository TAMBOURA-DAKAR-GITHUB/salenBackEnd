package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Cercle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CercleRepository extends JpaRepository<Cercle , Long> {

    //public Page<Cercle> listeCercleByPage(Pageable pageable);
}
