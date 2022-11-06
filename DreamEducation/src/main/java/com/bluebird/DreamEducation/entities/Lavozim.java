package com.bluebird.DreamEducation.entities;
import com.bluebird.DreamEducation.entities.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lavozimlar")
@JsonIgnoreProperties(value = "user")
public class Lavozim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomi", nullable = false, unique = true)
    private String nomi;

    @OneToMany(mappedBy = "lavozimlar")
    private List<Lavozim> lavozimlar;

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

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
