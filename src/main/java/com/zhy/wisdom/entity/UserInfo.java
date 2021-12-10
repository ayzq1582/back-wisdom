package com.zhy.wisdom.entity;

import java.util.Date;

public class UserInfo {
    private Long userId;

    private String username;

    private String userPin;

    private String password;

    private String token;

    private Long doctorId;

    private String doctorCode;

    private Date passwordExpirationTime;

    private Byte yn;

    private Date created;

    private Date updated;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin == null ? null : userPin.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode == null ? null : doctorCode.trim();
    }

    public Date getPasswordExpirationTime() {
        return passwordExpirationTime;
    }

    public void setPasswordExpirationTime(Date passwordExpirationTime) {
        this.passwordExpirationTime = passwordExpirationTime;
    }

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}