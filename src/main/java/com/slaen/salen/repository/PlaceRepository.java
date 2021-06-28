package com.slaen.salen.repository;

import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface PlaceRepository extends JpaRepository<Place , Long> {

    //public Page<Place> listePlaceByPage(Pageable pageable);
    Place findByNumeroPlace(String numero);
}
