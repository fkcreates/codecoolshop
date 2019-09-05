package com.codecool.shop.dao.implementation.mem;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private static UserDaoJdbc instance = null;
    private static User user;

    public static UserDaoJdbc getInstance(){
        if (instance == null) {
            user = new User(1, "first user");
            instance = new UserDaoJdbc();
        }
        return instance;
    }

    @Override
    public void add(User user){
        String query = "INSERT INTO buyer (id, name) VALUES " +
                "('" + user.getId() + "', '" + user.getName() + "';)";

        executeQuery(query);
    }

    @Override
    public void remove(int id){
        //:TODO
    }

    @Override
    public Cart findCartForUser(int id){
        String idString = String.valueOf(id);
        String query = "SELECT * FROM buyer WHERE id = '" + idString + "';";

        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            if(result.next()){
                return user.getCart();
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("no cart found");
        return null;
    }

    @Override
    public List<User> getAll(){
        //:TODO
        return null;
    }

    private void executeQuery(String query) {
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
