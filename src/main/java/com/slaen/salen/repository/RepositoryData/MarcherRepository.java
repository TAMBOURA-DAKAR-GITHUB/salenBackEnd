package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Marcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcherRepository extends JpaRepository<Marcher , Long> {

    //public Page<Marcher>  listeMaecherByPage(Pageable pageable);
    public List<Marcher> findByMairieIdMairie(Long id);
}
