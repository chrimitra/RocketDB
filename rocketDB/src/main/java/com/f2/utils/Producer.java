package com.f2.utils;

import com.f2.models.User;

import java.io.Serializable;
import java.util.Random;

public class Producer {
    String name;
    String ip;

    public Producer(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }
    public User nuovoUser(){
        return new User(Util.generateRandomIPAddress(),Util.generateUsername());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
