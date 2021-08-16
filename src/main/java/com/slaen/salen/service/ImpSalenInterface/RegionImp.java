package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Region;
import com.slaen.salen.repository.RepositoryData.RegionRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryRegion;
import com.slaen.salen.service.Saleninterface.RegionInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionImp implements RegionInterface {

    private RegionRepository regionRepository;
    private VerificationReposotoryRegion verificationReposotoryRegion;

    public RegionImp(RegionRepository regionRepository, VerificationReposotoryRegion verificationReposotoryRegion) {
        this.regionRepository = regionRepository;
        this.verificationReposotoryRegion = verificationReposotoryRegion;
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
    public Region UpdateRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public void deleteRegion(long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public boolean isRegionExist(Long id) {
        return verificationReposotoryRegion.isRegionExist(id);
    }

    @Override
    public Region VerificationRegion(String libelleRegion) {
        return regionRepository.findBylibelleRegion(libelleRegion);
    }
}
