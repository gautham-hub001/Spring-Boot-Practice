package com.example.mydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // by default it is singleton. But here we're mentioning prototype
public class Alien { // Creating a simple POJO called Alien
    private int aid;
    private String aname;
    private String tech;

    @Autowired
    @Qualifier("lap1")
    private Laptop l;

    public Alien() {
        System.out.println("Object created");
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void show() {
        System.out.println("show() called. Alien object was injected successfully!!!");
        l.compile();
    }
}
