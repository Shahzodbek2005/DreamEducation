package com.bluebird.DreamEducation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "xodim_lavozimi")
@JsonIgnoreProperties(value = "user")
public class XodimLavozimi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Xodim id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "xodim_id", nullable = false, referencedColumnName = "id")
    private Xodimlar xodim;

    //Lavozim id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lavozim_id", nullable = false, referencedColumnName = "id")
    private Lavozim lavozim;

    //User id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Xodimlar getXodim() {
        return xodim;
    }

    public void setXodim(Xodimlar xodim) {
        this.xodim = xodim;
    }

    public Lavozim getLavozim() {
        return lavozim;
    }

    public void setLavozim(Lavozim lavozim) {
        this.lavozim = lavozim;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}


