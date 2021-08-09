package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Marchand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarchandRepository extends JpaRepository<Marchand , Long> {

     public List<Marchand> findByMarcherIdMarcher(Long id);
     public  Marchand findByIdMarchand(long idmarchand);

    Marchand findByNomMarchand(String nom);

}

