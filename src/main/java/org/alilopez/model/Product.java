package org.alilopez.model;

public class Product {
    private int idProduct;
    private String name;
    private int stock;
    private float price;
    private String url_image;

    public Product() {
    }

    public Product(String name, int stock, float price, String url_image) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.url_image = url_image;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}