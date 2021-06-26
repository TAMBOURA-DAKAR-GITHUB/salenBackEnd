package com.slaen.salen.repository;

import com.slaen.salen.entity.Commune;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface CommuneRepository extends JpaRepository<Commune , Long> {

    public Page<Commune> listeCommuneByPage(Pageable pageable);
}
