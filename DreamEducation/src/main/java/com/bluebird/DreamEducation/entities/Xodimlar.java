package com.bluebird.DreamEducation.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "xodimlar")
@JsonIgnoreProperties(value = "user")
public class Xodimlar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ismi", nullable = false)
    private String ismi;

    @Column(name = "familiyasi", nullable = false)
    private String familiyasi;

    @Column(name = "otasi")
    private String otasi;

    @Column(name = "tugilgan_sana", nullable = false)
    private Date tugilganSana;

    @Column(name = "passport_seriya", unique = true, nullable = false)
    private String passportSeriya;

    @Column(name = "telefon_raqami1", nullable = false)
    private String telefonRaqami1;



    @Column(name = "telefon_raqami2")
    private String telefonRaqami2;

    @OneToMany(mappedBy = "xodimlar")
    private List<Xodimlar> xodimlar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public String getFamiliyasi() {
        return familiyasi;
    }

    public void setFamiliyasi(String familiyasi) {
        this.familiyasi = familiyasi;
    }

    public String getOtasi() {
        return otasi;
    }

    public void setOtasi(String otasi) {
        this.otasi = otasi;
    }

    public Date getTugilganSana() {
        return tugilganSana;
    }

    public void setTugilganSana(Date tugilganSana) {
        this.tugilganSana = tugilganSana;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getPassportSeriya() {
        return passportSeriya;
    }

    public void setPassportSeriya(String passportSeriya) {
        this.passportSeriya = passportSeriya;
    }

    public String getTelefonRaqami1() {
        return telefonRaqami1;
    }

    public void setTelefonRaqami1(String telefonRaqami1) {
        this.telefonRaqami1 = telefonRaqami1;
    }

    public String getTelefonRaqami2() {
        return telefonRaqami2;
    }

    public void setTelefonRaqami2(String telefonRaqami2) {
        this.telefonRaqami2 = telefonRaqami2;
    }
}
