package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Marchand;
import com.slaen.salen.repository.RepositoryData.MarchandRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryMarchand;
import com.slaen.salen.service.Saleninterface.MarchandInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarchandImp implements MarchandInterface {

    private MarchandRepository marchandRepository;
    private VerificationReposotoryMarchand verificationReposotoryMarchand;

    public MarchandImp(MarchandRepository marchandRepository, VerificationReposotoryMarchand verificationReposotoryMarchand) {
        this.marchandRepository = marchandRepository;
        this.verificationReposotoryMarchand = verificationReposotoryMarchand;
    }

    @Override
    public Marchand addMarchand(Marchand marchand) {
        return marchandRepository.save(marchand);
    }

    @Override
    public List<Marchand> listeMarchand() {
        return marchandRepository.findAll(Sort.by("idMarchand").descending());
    }

    @Override
    public Marchand listeById(long id) {
        return marchandRepository.findById(id).get();
    }

    @Override
    public Marchand UpdateMarcher(Marchand marchand) {
        return marchandRepository.save(marchand);
    }

    @Override
    public void deleteMarchand(long id) {
        marchandRepository.deleteById(id);
    }

    @Override
    public List<Marchand> listeByMarcher(Long id) {
        return marchandRepository.findByMarcherIdMarcher(id);
    }

    @Override
    public boolean isMarchandExist(Long id) {
        return verificationReposotoryMarchand.isMarchandExist(id);
    }

    @Override
    public boolean isMarchandByMarcherExist(Long id) {
        return verificationReposotoryMarchand.isMarchandByMarcherExist(id);
    }
}
