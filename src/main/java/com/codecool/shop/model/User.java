package com.codecool.shop.model;

public class User {
    private int id ;
    private static int idCounter = 0;
    private String name;
    private Cart cart;

    public User(int id, String name){
        this.cart = new Cart();
        this.id = id;
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

    public String getName() {
        return name;
    }
}
