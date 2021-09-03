package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Marcher;
import com.slaen.salen.repository.RepositoryData.MarcherRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryMarcher;
import com.slaen.salen.service.Saleninterface.MarcherInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcherImp implements MarcherInterface {

    private MarcherRepository marcherRepository;
    private VerificationReposotoryMarcher verificationReposotoryMarcher;

    public MarcherImp(MarcherRepository marcherRepository, VerificationReposotoryMarcher verificationReposotoryMarcher) {
        this.marcherRepository = marcherRepository;
        this.verificationReposotoryMarcher = verificationReposotoryMarcher;
    }

    @Override
    public Marcher addMarcher(Marcher marcher) {
        return marcherRepository.save(marcher);
    }

    @Override
    public List<Marcher> listeMarcher() {
        return marcherRepository.findAll(Sort.by("idMarcher").descending());
    }

    @Override
    public Marcher listeById(long id) {
        return marcherRepository.findById(id).get();
    }

    @Override
    public Marcher UpdateMarcher(Marcher marcher) {
        return marcherRepository.save(marcher);
    }

    @Override
    public void deleteMarcher(long id) {
        marcherRepository.deleteById(id);

    }

    @Override
    public List<Marcher> listeByMairie(Long idMairie) {
        return marcherRepository.findByMairieIdMairie(idMairie);
    }

    @Override
    public boolean isMarcherExist(Long id) {
        return verificationReposotoryMarcher.isMarcherExist(id);
    }

    @Override
    public boolean isMarcherByMairieExist(Long id) {
        return verificationReposotoryMarcher.isMarchandByMarcherExist(id);
    }
}
