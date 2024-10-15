package com.schoolpool.app.entities;


import org.springframework.data.annotation.Id;

public class Login {

    private String mailID;
    private String password;

    public Login() {
    }

    public Login(String mailID, String password) {
        this.mailID = mailID;
        this.password = password;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
