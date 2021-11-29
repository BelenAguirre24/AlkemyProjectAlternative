package com.Alternative.Alkemy.demo.Repository.Specification;

import com.Alternative.Alkemy.demo.DTO.IconFiltersDTO;
import com.Alternative.Alkemy.demo.Entity.EntityCountry;
import com.Alternative.Alkemy.demo.Entity.EntityIcons;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.Query;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

@Component
public class IconSpecification {
    public Specification<EntityIcons> getByFilters(IconFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        (Predicate) criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denomination")),
                                "%" + filtersDTO.getName().toLowerCase() +"%"));

            }
            if (StringUtils.hasLength(filtersDTO.getDate())){
                //TODO:REUSE THIS in a function//
                DateTimeFormat format = DateTimeFormat.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDTO.getDate(),formatter);

                predicates.add(
                        (Predicate) criteriaBuilder.equal(root.<LocalDate>get("creationDate"),date)
                );

            }
            if(!CollectionUtils.isEmpty(filtersDTO.getCities())){
                Join<EntityCountry, EntityIcons> join=  root.join("country", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add((Predicate) citiesId.in(filtersDTO.getCities()));
            }
            //Remove Duplicates
            query.distinct(true);
            //order resolver
            String orderByField = "Denomination";
            query.orderBy(
                    filtersDTO.isASC()?
                            criteriaBuilder.asc(root.get(orderByField)):
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
