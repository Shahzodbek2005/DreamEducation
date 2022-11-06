package com.bluebird.DreamEducation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "yonalishlar")
public class Yonalish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomi", unique = true, nullable = false)
    private String nomi;

    @OneToMany(mappedBy = "yonalishlar")
    private List<Yonalish> yonalishlar;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }
}
