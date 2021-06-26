package com.slaen.salen.repository;

import com.slaen.salen.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PlaceRepository extends JpaRepository<Place , Long> {
}
