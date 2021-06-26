package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.Region;
import com.slaen.salen.repository.RegionRepository;
import com.slaen.salen.service.Saleninterface.RegionInterface;

import java.util.List;

public class RegionImp implements RegionInterface {

    private RegionRepository regionRepository;
    public RegionImp(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public Region addRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> listeRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region RegionById(long id) {
        return regionRepository.findById(id).get();
    }


    @Override
    public Region UpdateRegion(long id, Region region) {
        region.setIdRegion(id);
        return regionRepository.save(region);
    }

    @Override
    public void deleteRegion(long id) {
        regionRepository.deleteById(id);
    }
}
