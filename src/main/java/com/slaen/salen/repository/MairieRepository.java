package com.slaen.salen.repository;

import com.slaen.salen.entity.Mairie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface MairieRepository extends JpaRepository<Mairie , Long> {

    //public Page<Mairie> listeMairieByPage(Pageable pageable);
}
