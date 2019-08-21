package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMem implements UserDao {

    private List<User> data = new ArrayList<>();
    private static UserDaoMem instance = null;

    private UserDaoMem() {
    }

    public static UserDaoMem getInstance() {
        if (instance == null) {
            instance = new UserDaoMem();
        }
        return instance;
    }

    @Override
    public void add(User user){
        data.add(user);
    }

    @Override
    public void remove(int id){
        //:TODO
    }

    @Override
    public Cart findCartForUser(int id){
        for(User user: data){
            if(user.getId() == id){
                return user.getCart();
            }
        }
        return null;
    }

    @Override
    public List<User> getAll(){
        //:TODO
        return null;
    }
}
