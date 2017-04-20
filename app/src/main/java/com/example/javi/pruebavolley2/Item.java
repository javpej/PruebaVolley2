package com.example.javi.pruebavolley2;

/**
 * Created by Javi on 20/4/17.
 */

public class Item {

    String sCiudad;
    String sTemp;
    String sPred;

    public Item(String sCiudad, String sTemp, String sPred) {
        this.sCiudad = sCiudad;
        this.sTemp = sTemp;
        this.sPred = sPred;
    }

    public String getsCiudad() {
        return sCiudad;
    }

    public void setsCiudad(String sCiudad) {
        this.sCiudad = sCiudad;
    }

    public String getsTemp() {
        return sTemp;
    }

    public void setsTemp(String sTemp) {
        this.sTemp = sTemp;
    }

    public String getsPred() {
        return sPred;
    }

    public void setsPred(String sPred) {
        this.sPred = sPred;
    }
}
