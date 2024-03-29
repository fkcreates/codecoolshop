package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void remove(int id);
    Cart findCartForUser(int id);
    List<User> getAll();
}
