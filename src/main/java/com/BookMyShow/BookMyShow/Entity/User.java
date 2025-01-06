package com.BookMyShow.BookMyShow.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String nameOfuser;
    private long mobileNumber;
    private String mailId;
    private String dataOfBirth;
    private String address;
    private String status;

    public User() {
    }

    public User(String id, String userName, String password, String nameOfuser, long mobileNumber, String mailId, String dataOfBirth, String address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nameOfuser = nameOfuser;
        this.mobileNumber = mobileNumber;
        this.mailId = mailId;
        this.dataOfBirth = dataOfBirth;
        this.address = address;
        this.status = "true";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameOfuser() {
        return nameOfuser;
    }

    public void setNameOfuser(String nameOfuser) {
        this.nameOfuser = nameOfuser;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
