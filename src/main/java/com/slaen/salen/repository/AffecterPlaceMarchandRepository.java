package com.slaen.salen.repository;

import com.slaen.salen.entity.AffecterPlaceMarchand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface AffecterPlaceMarchandRepository extends JpaRepository<AffecterPlaceMarchand ,Long> {

    public Page<AffecterPlaceMarchand> listeAffecterMarchand(Pageable pageable);
}
