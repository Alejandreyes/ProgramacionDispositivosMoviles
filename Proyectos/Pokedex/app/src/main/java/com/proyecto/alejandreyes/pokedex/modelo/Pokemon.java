package com.proyecto.alejandreyes.pokedex.modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pride on 16/11/2018.
 */

public class Pokemon implements Parcelable{
    private int number;
    private String name ;
    private  String url;

    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
