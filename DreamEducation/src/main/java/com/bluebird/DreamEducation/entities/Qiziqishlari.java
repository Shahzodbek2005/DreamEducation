package com.bluebird.DreamEducation.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "qiziqishlari")
public class Qiziqishlari implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomi", nullable = false, unique = true)
    private String nomi;

    @OneToMany(mappedBy = "qiziqishlari")
    private List<Qiziqishlari> qiziqishlari;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }
}
