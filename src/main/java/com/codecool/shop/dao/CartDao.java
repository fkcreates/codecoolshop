package com.codecool.shop.dao;


import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;

import java.util.List;
import java.util.Map;

public interface CartDao {

    Cart getByUser(User user);

    void add(Cart cart);
    void remove(int id);
    Map<Product, Integer> list(Product product);
    List<Cart> getAll();

}
