package com.example.myapplication.dao;

import java.io.Serializable;

public class HomeDao implements Serializable {
    private String Tenbaibao;
    private String NoidungBaibao;
    private String TieuDe;
    private int imahome;


    public HomeDao(String tenbaibao, String tieuDe, String noidungBaibao, int imahome) {
        Tenbaibao = tenbaibao;
        TieuDe = tieuDe;
        NoidungBaibao = noidungBaibao;
        this.imahome = imahome;
    }

    public String getTenbaibao() {
        return Tenbaibao;
    }

    public void setTenbaibao(String tenbaibao) {
        Tenbaibao = tenbaibao;
    }

    public String getNoidungBaibao() {
        return NoidungBaibao;
    }

    public void setNoidungBaibao(String noidungBaibao) {
        NoidungBaibao = noidungBaibao;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public int getImahome() {
        return imahome;
    }

    public void setImahome(int imahome) {
        this.imahome = imahome;
    }
}
