package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.entity.Place;

import java.util.List;

public interface PlaceInterface {

    public Place addPayement(Place place);
    public List<Place> listePlace();
    public Place listeById(long id);
    public Place UpdatePayement(long id , Place place);
    public void deletePlace(long id);
}
