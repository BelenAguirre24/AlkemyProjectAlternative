package com.Alternative.Alkemy.demo.Repository;

import com.Alternative.Alkemy.demo.Entity.EntityContinent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<EntityContinent , Integer > {

}

}
