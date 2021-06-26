package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.AffecterPlaceMarchand;
import com.slaen.salen.repository.AffecterPlaceMarchandRepository;
import com.slaen.salen.service.Saleninterface.AffecterPlaceMarchandInterface;

import java.util.List;

public class AffecterPlaceMarchandImp implements AffecterPlaceMarchandInterface {

    private AffecterPlaceMarchandRepository marchandRepository;

    public AffecterPlaceMarchandImp(AffecterPlaceMarchandRepository marchandRepository) {
        this.marchandRepository = marchandRepository;
    }

    @Override
    public AffecterPlaceMarchand addAffecterPlaceMarchand(AffecterPlaceMarchand affecterPlaceMarchand) {
        return marchandRepository.save(affecterPlaceMarchand);
    }

    @Override
    public List<AffecterPlaceMarchand> listeAffecterPlaceMarchand() {
        return marchandRepository.findAll();
    }

    @Override
    public AffecterPlaceMarchand listeById(long id) {
        return marchandRepository.findById(id).get();
    }

    @Override
    public AffecterPlaceMarchand UpdateAffecterPlaceMarchand(long id, AffecterPlaceMarchand affecterPlaceMarchand) {
        affecterPlaceMarchand.setIdAffecterPlaceMarchand(id);
        return marchandRepository.save(affecterPlaceMarchand);
    }

    @Override
    public void deleteAffecterPlaceMarchand(long id) {
        marchandRepository.deleteById(id);
    }
}
