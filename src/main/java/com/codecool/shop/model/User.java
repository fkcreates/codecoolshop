package com.codecool.shop.model;

public class User {
    private int id ;
    private static int idCounter = 0;
    private String name;
    private Cart cart;

    public User(String name){
        this.cart = new Cart();
        this.id = generateId();
        this.name = name;
    }

    public int generateId(){
        return idCounter ++;
    }

    public Cart getCart(){
        return this.cart;
    }

    public int getId() {
        return id;
    }
}
