package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place , Long> {

    //public Page<Place> listePlaceByPage(Pageable pageable);
    Place findByNumeroPlace(String numero);

    Place findByIdPlace(long idplace);

    public List<Place> findByMarcherIdMarcher(Long id);
}
