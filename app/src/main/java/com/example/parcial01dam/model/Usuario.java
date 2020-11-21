package com.example.parcial01dam.model;

import android.arch.persistence.room.Entity;

@Entity
public class Usuario {

    @PrimaryKey (autoGenerate  =  true)
    public int uid;

    @ColumnInfo(name = "first_name")
    private String txtNombre;

    @ColumnInfo(name = "last_name")
    private String txtSubName;

    @ColumnInfo(name = "user_name")
    private String txtUser;

    @ColumnInfo(name = "password")
    private String txtPassw;

    @ColumnInfo(name = "tarj_credit")
    private Boolean radioOpcionA;

    @ColumnInfo(name = "tarj_debit")
    private Boolean radioOpcionB;

    @ColumnInfo(name = "notificacion")
    private Boolean switNotifi;

    @ColumnInfo(name = "terminos")
    private Boolean checkBoxTerminos;

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtSubName() {
        return txtSubName;
    }

    public void setTxtSubName(String txtSubName) {
        this.txtSubName = txtSubName;
    }

    public String getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(String txtUser) {
        this.txtUser = txtUser;
    }

    public String getTxtPassw() {
        return txtPassw;
    }

    public void setTxtPassw(String txtPassw) {
        this.txtPassw = txtPassw;
    }

    public Boolean getRadioOpcionA() {
        return radioOpcionA;
    }

    public void setRadioOpcionA(Boolean radioOpcionA) {
        this.radioOpcionA = radioOpcionA;
    }

    public Boolean getRadioOpcionB() {
        return radioOpcionB;
    }

    public void setRadioOpcionB(Boolean radioOpcionB) {
        this.radioOpcionB = radioOpcionB;
    }

    public Boolean getSwitNotifi() {
        return switNotifi;
    }

    public void setSwitNotifi(Boolean switNotifi) {
        this.switNotifi = switNotifi;
    }

    public Boolean getCheckBoxTerminos() {
        return checkBoxTerminos;
    }

    public void setCheckBoxTerminos(Boolean checkBoxTerminos) {
        this.checkBoxTerminos = checkBoxTerminos;
    }
}
