package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.Mairie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MairieRepository extends JpaRepository<Mairie , Long> {


}
