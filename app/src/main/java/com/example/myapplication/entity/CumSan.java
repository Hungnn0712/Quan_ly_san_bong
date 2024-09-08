package com.example.myapplication.entity;

import java.io.Serializable;

public class CumSan implements Serializable {
    private static CumSan instance;
    public int maCumSan, soDanhGia, soSao;
    public String tenCumSan,chuSan,diaChi;

    public CumSan(){

    }
    public static CumSan getInstance(){
        if (instance== null){
            synchronized (CumSan.class){
                if(instance== null){
                    instance = new CumSan();
                }
            }
        }
        return instance;
    }

    public int getMaCumSan() {
        return maCumSan;
    }

    public void setMaCumSan(int maCumSan) {
        this.maCumSan = maCumSan;
    }

    public CumSan(int maCumSan, String tenCumSan) {
        this.maCumSan = maCumSan;
        this.tenCumSan = tenCumSan;
    }
    public CumSan(int maCumSan, String tenCumSan, String chuSan, String diaChi) {
        this.maCumSan = maCumSan;
        this.tenCumSan = tenCumSan;
        this.chuSan = chuSan;
        this.diaChi = diaChi;
    }

    public CumSan(int maCumSan, int soDanhGia, int soSao, String tenCumSan, String chuSan, String diaChi) {
        this.maCumSan = maCumSan;
        this.soDanhGia = soDanhGia;
        this.soSao = soSao;
        this.tenCumSan = tenCumSan;
        this.chuSan = chuSan;
        this.diaChi = diaChi;
    }
}
