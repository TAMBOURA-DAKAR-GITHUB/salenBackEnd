package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.AffecterPlaceMarchand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AffecterPlaceMarchandRepository extends JpaRepository<AffecterPlaceMarchand ,Long> {

    //public Page<AffecterPlaceMarchand> listeAffecterMarchand(Pageable pageable);


}
