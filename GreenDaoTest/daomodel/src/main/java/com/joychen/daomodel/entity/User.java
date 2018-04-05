package com.joychen.daomodel.entity;

import android.support.annotation.StringDef;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by joychen on 2018/4/4.
 */

@Entity
public class User {
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String password;

    @Convert(converter = UTypeConverter.class, columnType = String.class)
    private UType uType;

    @Generated(hash = 880718105)
    public User(Long id, @NotNull String name, @NotNull String password, UType uType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.uType = uType;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UType getuType() {
        return uType;
    }

    public void setuType(UType uType) {
        this.uType = uType;
    }

    public UType getUType() {
        return this.uType;
    }

    public void setUType(UType uType) {
        this.uType = uType;
    }
}
