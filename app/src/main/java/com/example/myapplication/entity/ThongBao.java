package com.example.myapplication.entity;

public class ThongBao {
    String tenGiai,thongTin;

    public ThongBao() {
    }

    public ThongBao(String tenGiai, String thongTin) {
        this.tenGiai = tenGiai;
        this.thongTin = thongTin;
    }

    public String getTenGiai() {
        return tenGiai;
    }

    public void setTenGiai(String tenGiai) {
        this.tenGiai = tenGiai;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }
}
