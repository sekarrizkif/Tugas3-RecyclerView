package com.example.pahlawanapp;

public class PahlawanModel {
    private String namaPahlawan;
    private String detailPahlawan;
    private int fotoPahlawan;

    public String getNama() {
        return namaPahlawan;
    }

    public void setNama(String nama) {
        this.namaPahlawan = nama;
    }

    public String getDetail() {
        return detailPahlawan;
    }

    public void setDetail(String detail) {
        this.detailPahlawan = detail;
    }

    public int getFoto() {
        return fotoPahlawan;
    }

    public void setFotoPahlawan(int fotoPahlawan) {
        this.fotoPahlawan = fotoPahlawan;
    }
}
