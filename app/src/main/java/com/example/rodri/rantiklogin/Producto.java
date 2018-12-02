package com.example.rodri.rantiklogin;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class Producto {
    private int id;
    private String name;
    private String desc;
    private String price;
    private String place;
    private String time;
    private byte[] image;

    public Producto(String name, String desc, String price, String place, String time, byte[] image, int id) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.place = place;
        this.time = time;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
