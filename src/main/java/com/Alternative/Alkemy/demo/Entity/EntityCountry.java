package com.Alternative.Alkemy.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="country")
@Getter
@Setter
public class EntityCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String image;
    private String denomination;
    @Column(name = "number_of_inhabitant")
    private Long numberinhabitant;
    private Long surface;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_Id", insertable = false, updatable = false)
    private EntityContinent continent;
    @Column(name = "continent_Id", nullable = false)
    private Long continentId;
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_country",
            joinColumns = @JoinColumn(name = "icon_Id"))
    private Set<EntityIcons> icons = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final EntityCountry other = (EntityCountry) obj;
        return other.id == this.id;


    }
}
