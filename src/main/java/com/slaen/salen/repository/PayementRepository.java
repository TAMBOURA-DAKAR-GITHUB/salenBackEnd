package com.slaen.salen.repository;

import com.slaen.salen.entity.Payement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface PayementRepository extends JpaRepository<Payement , Long> {

    //public Page<Payement> listePayementByPage(Pageable pageable);
}
