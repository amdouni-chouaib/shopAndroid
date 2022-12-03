package com.example.projetversion1;


public class Product {
    private String Title ,description,category ,state ,price,picture;

    public Product() {
    }

    public Product(String title, String description, String category, String state, String price, String picture) {

        Title = title;
        this.description = description;
        this.category = category;
        this.state = state;
        this.price = price;
        this.picture = picture;
    }

    public  String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}