package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends JpaRepository<Commune , Long> {

   // public Page<Commune> listeCommuneByPage(Pageable pageable);
}
