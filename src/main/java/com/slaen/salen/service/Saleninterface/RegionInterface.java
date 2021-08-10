package com.slaen.salen.service.Saleninterface;

import com.slaen.salen.model.Region;

import java.util.List;

public interface RegionInterface {

    public Region addRegion(Region region);
    public List<Region> listeRegions();
    public Region RegionById(long id);
    public Region UpdateRegion(Region region);
    public void deleteRegion(long id);

    // la methode pour verifie si une Region existe
    public abstract boolean isRegionExist(Long id);

}
