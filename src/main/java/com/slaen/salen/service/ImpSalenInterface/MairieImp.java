package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Mairie;
import com.slaen.salen.repository.RepositoryData.MairieRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryMairie;
import com.slaen.salen.service.Saleninterface.MairieInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MairieImp implements MairieInterface {

    private MairieRepository mairieRepository;
    private VerificationReposotoryMairie verificationReposotoryMairie;

    public MairieImp(MairieRepository mairieRepository, VerificationReposotoryMairie verificationReposotoryMairie) {
        this.mairieRepository = mairieRepository;
        this.verificationReposotoryMairie = verificationReposotoryMairie;
    }

    @Override
    public Mairie addMairie(Mairie mairie) {

            return mairieRepository.save(mairie);
    }

    @Override
    public List<Mairie> listeMairie() {
        List<Mairie> listemairie = mairieRepository.findAll(Sort.by("idMairie").descending());
        return listemairie;
    }

    @Override
    public Mairie listeById(long id) {
        Mairie mairie= mairieRepository.findById(id).get();
        return mairie;
    }

    @Override
    public Mairie UpdateMairie(Mairie mairie) {
        return mairieRepository.save(mairie);
    }

    @Override
    public void deleteMairie(long id) {
        mairieRepository.deleteById(id);
    }

    @Override
    public boolean isMairieExist(Long id) {
      return   verificationReposotoryMairie.isMairieExist(id);
    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> exceptionHandler(Exception e){
//        return new ResponseEntity<>( e.getMessage() , HttpStatus.NOT_FOUND);
//
//    }
}
