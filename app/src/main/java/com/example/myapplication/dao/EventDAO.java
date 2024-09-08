package com.example.myapplication.dao;

import java.io.Serializable;

public class EventDAO implements Serializable {
    private String name;
    private String ngaybd;
    private String ngaykt;
    private int imevent;
    private String thongtinevent;

    public EventDAO(String name, String ngaybd, String ngaykt, int imevent, String thongtinevent) {
        this.name = name;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.imevent = imevent;
        this.thongtinevent = thongtinevent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }

    public int getImevent() {
        return imevent;
    }

    public void setImevent(int imevent) {
        this.imevent = imevent;
    }

    public String getThongtinevent() {
        return thongtinevent;
    }

    public void setThongtinevent(String thongtinevent) {
        this.thongtinevent = thongtinevent;
    }
}
