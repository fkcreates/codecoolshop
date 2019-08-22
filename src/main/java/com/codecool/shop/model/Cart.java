package com.codecool.shop.model;

import java.util.*;

public class Cart {
    private List<Product> listOfProductsInCart = new ArrayList<>();
    private float sumPrice;

    public Cart(){
    }

    public List<Product> getProductsInCart(){

        return listOfProductsInCart;
    }

    public float getSumPrice(){
        sumPrice = 0;
        for(Product product: listOfProductsInCart){
            sumPrice += product.getDefaultPrice();
        }
        return sumPrice;
    }

    public void addProductToCart(Product product){

        listOfProductsInCart.add(product);
    }

    public void removeProductFromCart(Product product){
        listOfProductsInCart.remove(product);
    }

    public int getItemCounter(Product product){
        int itemCounter = 0;
        for(Product item: listOfProductsInCart){
            if(item.getId() == product.getId()){
                itemCounter += 1;
            }
        }
        return itemCounter;
    }

    public Object getSetOfProductsInCart() {
        Set<Product> setOfProducts = new HashSet<>(listOfProductsInCart);

        return setOfProducts;
    }

    public Object getCart() {
        return this;
    }
}
