package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Place;
import com.slaen.salen.repository.RepositoryData.PlaceRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryPlace;
import com.slaen.salen.service.Saleninterface.PlaceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceImp implements PlaceInterface {

    private PlaceRepository placeRepository;
    private VerificationReposotoryPlace verificationReposotoryPlace;

    public PlaceImp(PlaceRepository placeRepository, VerificationReposotoryPlace verificationReposotoryPlace) {
        this.placeRepository = placeRepository;
        this.verificationReposotoryPlace = verificationReposotoryPlace;
    }

    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> listePlace() {
        return placeRepository.findAll(Sort.by("idPlace").descending());
    }

    @Override
    public Place listeById(long id) {
        return placeRepository.findById(id).get();
    }

    @Override
    public Place UpdatePlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public void deletePlace(long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public List<Place> listeByPlace(Long idPlace) {
        return placeRepository.findByMarcherIdMarcher(idPlace);
    }

    @Override
    public boolean isPlaceExist(Long id) {
        return verificationReposotoryPlace.isPlaceExist(id);
    }

    @Override
    public boolean isPlaceByMarcherExist(Long id) {
        return verificationReposotoryPlace.isPlaceByMarcherExist(id);
    }
}
