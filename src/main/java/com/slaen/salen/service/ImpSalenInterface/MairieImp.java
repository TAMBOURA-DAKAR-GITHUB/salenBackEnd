package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.Exception.MairieNotFoundException;
import com.slaen.salen.entity.Mairie;
import com.slaen.salen.repository.MairieRepository;
import com.slaen.salen.service.Saleninterface.MairieInterface;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class MairieImp implements MairieInterface {

    private MairieRepository mairieRepository;

    public MairieImp(MairieRepository mairieRepository) {
        this.mairieRepository = mairieRepository;
    }

    @Override
    public Mairie addMairie(Mairie mairie) {
        try {
        if(mairie.getLibelleMairie()==null);
            System.out.println("exc ........");
        }catch (Exception e){
            throw new MairieNotFoundException("Mairie Introuvable ....");
        }
            return mairieRepository.save(mairie);
    }

    @Override
    public List<Mairie> listeMairie() {
        return mairieRepository.findAll(Sort.by("idMairie").descending());
    }

    @Override
    public Mairie listeById(long id) {
        return mairieRepository.findById(id).get();
    }

    @Override
    public Mairie UpdateMairie(Mairie mairie) {
        return mairieRepository.save(mairie);
    }

    @Override
    public void deleteMairie(long id) {
        mairieRepository.deleteById(id);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>( e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
