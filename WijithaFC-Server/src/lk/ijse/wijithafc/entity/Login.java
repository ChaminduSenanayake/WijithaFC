/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ASUS
 */
@Entity
public class Login {
    @Id
    private String loginID;
    private String loginType;
    private String name;
    private String password;

    public Login() {
    }

    public Login(String loginID, String loginType, String name, String password) {
        this.loginID = loginID;
        this.loginType = loginType;
        this.name = name;
        this.password = password;
    }

    /**
     * @return the loginID
     */
    public String getLoginID() {
        return loginID;
    }

    /**
     * @param loginID the loginID to set
     */
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    /**
     * @return the loginType
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * @param loginType the loginType to set
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" + "loginID=" + loginID + ", loginType=" + loginType + ", name=" + name + ", password=" + password + '}';
    }
}
