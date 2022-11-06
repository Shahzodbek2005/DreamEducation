package com.bluebird.DreamEducation.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "fan_yonalish")
public class FanYonalish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fan_id",nullable = false,referencedColumnName = "id")
    private Fan fan;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "yonalish_id",nullable = false,referencedColumnName = "id")
    private Yonalish yonalish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public Yonalish getYonalish() {
        return yonalish;
    }

    public void setYonalish(Yonalish yonalish) {
        this.yonalish = yonalish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
