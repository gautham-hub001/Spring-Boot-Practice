package com.example.mydemo;

import org.springframework.stereotype.Component;

@Component("lap1")
public class Laptop {
    public int lid;
    public String lname;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop [lid=" + lid + ", lname=" + lname + "]";
    }

    public void compile() {
        System.out.println("compile called");
    }
}
