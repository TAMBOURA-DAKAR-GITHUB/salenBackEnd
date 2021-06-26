package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.Payement;
import com.slaen.salen.repository.PayementRepository;
import com.slaen.salen.service.Saleninterface.PayementInterface;

import java.util.List;

public class PayementImp implements PayementInterface {

    private PayementRepository payementRepository;

    public PayementImp(PayementRepository payementRepository) {
        this.payementRepository = payementRepository;
    }

    @Override
    public Payement addPayement(Payement payement) {
        return payementRepository.save(payement);
    }

    @Override
    public List<Payement> listePayement() {
        return payementRepository.findAll();
    }

    @Override
    public Payement listeById(long id) {
        return payementRepository.findById(id).get();
    }

    @Override
    public Payement UpdatePayement(long id, Payement payement) {
        payement.setIdPayement(id);
        return payementRepository.save(payement);
    }

    @Override
    public void deletePayement(long id) {
        payementRepository.deleteById(id);

    }
}
