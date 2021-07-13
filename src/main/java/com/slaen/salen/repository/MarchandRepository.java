package com.slaen.salen.repository;

import com.slaen.salen.entity.Marchand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface MarchandRepository extends JpaRepository<Marchand , Long> {

     public List<Marchand> findByMarcherIdMarcher(Long id);
     public  Marchand findByIdMarchand(long idmarchand);

    Marchand findByNomMarchand(String nom);

}

