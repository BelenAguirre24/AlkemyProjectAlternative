package com.Alternative.Alkemy.demo.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
    @Table(name ="Icons")
    @Getter
    @Setter
    @SQLDelete( sql = "UPDATE icon SET delete = true WHERE id=?")
    @Where(clause = "delete = false")
    public class EntityIcons {
        @Id
        @GeneratedValue(strategy= GenerationType.SEQUENCE)

        private Long id;
        private String image;
        private String denomination;
        @Column (name = "creation_date")
        @DateTimeFormat(pattern = "yyyy/MM/dd")
        private LocalDate creationDate;
        private Long height;
        private String history;
        private Boolean delete = Boolean.FALSE;
        //@ManyToONe(Fetch=FetchTypeEager,cascade  CascadeType.ALL)
        //@JoinColumn(name ="Country_id")
        //private EntityCountry country;
        @ManyToMany (mappedBy = "icons" , cascade= CascadeType.ALL)
        private List<EntityCountry> country = new ArrayList<>();
        // Add and remove country//
        public void addcountry (EntityCountry Country) {country.add(Country);}
        public void removecountry(EntityCountry Country) {country.remove(Country);}
    }

