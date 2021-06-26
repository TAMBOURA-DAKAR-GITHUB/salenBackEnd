package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.Marcher;
import com.slaen.salen.repository.MarcherRepository;
import com.slaen.salen.service.Saleninterface.MarcherInterface;

import java.util.List;

public class MarcherImp implements MarcherInterface {

    private MarcherRepository marcherRepository;

    public MarcherImp(MarcherRepository marcherRepository) {
        this.marcherRepository = marcherRepository;
    }

    @Override
    public Marcher addMarcher(Marcher marcher) {
        return marcherRepository.save(marcher);
    }

    @Override
    public List<Marcher> listeMarcher() {
        return marcherRepository.findAll();
    }

    @Override
    public Marcher listeById(long id) {
        return marcherRepository.findById(id).get();
    }

    @Override
    public Marcher UpdateMarcher(long id, Marcher marcher) {
        marcher.setIdMarcher(id);
        return marcherRepository.save(marcher);
    }

    @Override
    public void deleteMarcher(long id) {
        marcherRepository.deleteById(id);

    }
}
