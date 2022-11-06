package com.bluebird.DreamEducation.results;

import com.bluebird.DreamEducation.entities.Fan;
import com.bluebird.DreamEducation.entities.Users;
import com.bluebird.DreamEducation.entities.Yonalish;

public class A {


    private Boolean status;
    private Fan result;
    private Yonalish yonalish;

    private Users users;

    public A(Boolean status, Fan result, Yonalish yonalish, Users users) {
        this.status = status;
        this.result = result;
        this.yonalish = yonalish;
        this.users = users;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Fan getResult() {
        return result;
    }

    public void setResult(Fan result) {
        this.result = result;
    }

    public Yonalish getYonalish() {
        return yonalish;
    }

    public void setYonalish(Yonalish yonalish) {
        this.yonalish = yonalish;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
