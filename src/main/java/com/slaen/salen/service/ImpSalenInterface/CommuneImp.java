package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Commune;
import com.slaen.salen.repository.RepositoryData.CommuneRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryCommune;
import com.slaen.salen.service.Saleninterface.CommuneInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneImp implements CommuneInterface {

    private CommuneRepository communeRepository;
    private VerificationReposotoryCommune verificationReposotoryCommune;

    public CommuneImp(CommuneRepository communeRepository, VerificationReposotoryCommune verificationReposotoryCommune) {
        this.communeRepository = communeRepository;
        this.verificationReposotoryCommune = verificationReposotoryCommune;
    }

    @Override
    public Commune addCommune(Commune commune) {
        return communeRepository.save(commune);
    }

    @Override
    public List<Commune> listeCommune() {
        return communeRepository.findAll();
    }

    @Override
    public Commune listeById(long id) {
        return communeRepository.findById(id).get();
    }

    @Override
    public Commune UpdateCommune(Commune commune) {
        return communeRepository.save(commune);
    }

    @Override
    public void deleteCommune(long id) {
        communeRepository.deleteById(id);
    }

    @Override
    public boolean isCommuneExist(Long id) {
        return verificationReposotoryCommune.isCommuneExist(id);
    }

    @Override
    public Commune VerificationCommune(String libelleCommune) {
        return communeRepository.findBylibelleCommune(libelleCommune);
    }
}
