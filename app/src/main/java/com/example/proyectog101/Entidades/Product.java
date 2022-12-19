package com.example.proyectog101.Entidades;

import java.util.UUID;

public class Product {
    private String id;
    private String image;
    private String name;
    private String description;
    private int price;


    public Product(String id, String image, String name, String description, int price) {
        this.id = UUID.randomUUID().toString();
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    /*
    public Product(String image, String name, String description, int price) {
        this.id = UUID.randomUUID().toString();
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
