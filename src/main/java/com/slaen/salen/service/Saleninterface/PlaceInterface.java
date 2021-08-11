package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.Place;

import java.util.List;

public interface PlaceInterface {

    public Place addPlace(Place place);
    public List<Place> listePlace();
    public Place listeById(long id);
    public Place UpdatePlace(Place place);
    public void deletePlace(long id);

    public List<Place> listeByPlace(Long idPlace);

    // la methode pour verifie si une Place existe
    public abstract boolean isPlaceExist(Long id);
    public abstract boolean isPlaceByMarcherExist(Long id);

}
