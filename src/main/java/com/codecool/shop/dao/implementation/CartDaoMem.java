package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoMem implements CartDao {
    private List<Cart> data = new ArrayList<>();
    private static CartDaoMem instance = null;

    private CartDaoMem() {
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public Cart getByUser(User user){
        //:TODO
        return null;
    }

    @Override
    public void add(Cart cart){
        data.add(cart);
    }

    @Override
    public void remove(int id){
        //:TODO
    }

    @Override
    public Map<Product, Integer> list(Product product){
        //:TODO
        return null;
    }

    @Override
    public List<Product> getAll(){
        //:TODO
        return null;
    }

}

