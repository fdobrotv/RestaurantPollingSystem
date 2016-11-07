package com.fdobrotv.rps.models;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */
public class Health {
    String header;
    public Health(String str) {
        setHeader(str);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
