package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Cercle;
import com.slaen.salen.repository.RepositoryData.CercleRepository;
import com.slaen.salen.service.Saleninterface.CercleInterface;
import org.springframework.stereotype.Service;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryCercle;

import java.util.List;

@Service
public class CercleImp implements CercleInterface {

    private CercleRepository cercleRepository;
    private VerificationReposotoryCercle verificationReposotoryCercle;

    public CercleImp(CercleRepository cercleRepository, VerificationReposotoryCercle verificationReposotoryCercle) {
        this.cercleRepository = cercleRepository;
        this.verificationReposotoryCercle = verificationReposotoryCercle;
    }

    @Override
    public Cercle addCercle(Cercle cercle) {
        return cercleRepository.save(cercle);
    }

    @Override
    public List<Cercle> listeCercle() {
        return cercleRepository.findAll();
    }

    @Override
    public Cercle listeById(long id) {
        return cercleRepository.findById(id).get();
    }

    @Override
    public Cercle UpdateCercle(Cercle cercle) {
        return cercleRepository.save(cercle);
    }

    @Override
    public void deleteCercle(long id) {
        cercleRepository.deleteById(id);
    }

    @Override
    public boolean isCercleExist(Long id) {
        return verificationReposotoryCercle.isCercleExist(id);
    }

    @Override
    public Cercle VerificationCercle(String libelleCercle) {
        return cercleRepository.findBylibelleCercle(libelleCercle);
    }
}
