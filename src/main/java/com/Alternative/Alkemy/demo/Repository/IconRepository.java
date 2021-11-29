package com.Alternative.Alkemy.demo.Repository;

import com.Alternative.Alkemy.demo.Entity.EntityIcons;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IconRepository extends JpaRepository <EntityIcons, Long>, JpaSpecificationExecutor<EntityIcons> {
    List<EntityIcons> findAll(Specification<EntityIcons>spec);
}
