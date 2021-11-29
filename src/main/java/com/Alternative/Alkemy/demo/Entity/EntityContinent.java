package com.Alternative.Alkemy.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="continent")
@Getter
@Setter
public class EntityContinent {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)

        private Long id;
        private String image;
        private String denomination;

    }


