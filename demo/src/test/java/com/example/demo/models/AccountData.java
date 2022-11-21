package com.example.demo.models;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountData {
    @XmlElement(name = "username", required = true)
    public String username;
    @XmlElement(name = "password", required = true)
    public String password;

//    @XmlElement(name = "path", required = true)
//    private String path;
    public AccountData() {
    }
    public AccountData(String username, String password) {
        this.username = username;
        this.password = password;
//        this.path = path;
    }
    public String getLogin() {
        return username;
    }

    public String getPassword() {
        return password;
    }

//    public String getPath() {
//        return path;
//    }

    public void setLogin(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setPath(String path) {
//        this.path = path;
//    }

    public void setAccountUsername(String username) {
        this.username = username;
    }

    public void setAccountPassword(String password) {
        this.password = password;
    }

    public String getAccountUsername() {
        return this.username;
    }

    public String getAccountPassword() {
        return this.password;
    }
}