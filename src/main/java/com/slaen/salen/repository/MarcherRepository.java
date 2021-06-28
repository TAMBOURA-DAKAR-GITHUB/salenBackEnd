package com.slaen.salen.repository;

import com.slaen.salen.entity.Marcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface MarcherRepository extends JpaRepository<Marcher , Long> {

    //public Page<Marcher>  listeMaecherByPage(Pageable pageable);
}
