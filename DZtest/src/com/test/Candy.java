package com.test;

public abstract class Candy {
    private String name;
    private int weigth;
    private int price;
    private String descrip;

    protected Candy(String name, int weigth, int price, String descrip) {
        this.name = name;
        this.weigth = weigth;
        this.price = price;
        this.descrip = descrip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }


}
