package br.com.schelb.fernando.pdvendteste.Objects;


public class ItemMenu {

    private String title;
    private String descr;
    private double price;


    public ItemMenu(String title, String descr, double price) {
        this.title = title;
        this.descr = descr;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
