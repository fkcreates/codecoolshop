package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Cart {
    private List<Product> listOfProductsInCart = new ArrayList<Product>();
    private float sumPrice = 0;

    public Cart(){
    }

    public List<Product> getProductsInCart(){

        return listOfProductsInCart;
    }

    public float getSumPrice(){
        for(Product product: listOfProductsInCart){
            sumPrice += product.getDefaultPrice();
        }
        return sumPrice;
    }

    public void addProductToCart(Product product){
        System.out.println("cart.addProductToCart");
        System.out.println(product);
        listOfProductsInCart.add(product);
        System.out.println(listOfProductsInCart);
    }

    public void removeProductFromCart(Product product){
        listOfProductsInCart.remove(product);

    }

}
