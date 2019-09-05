package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.mem.ConnectionHandler;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoJdbc implements ProductDao {

    private static List<Product> data = new ArrayList<>();

    @Override
    public void add(Product product) {

        String query = "INSERT INTO product (name, description, default_price, default_currency) VALUES " +
                "('" + product.getName() + "', '" + product.getDescription() + "', '" +
                product.getDefaultPrice() + "', '" + product.getDefaultCurrency().getCurrencyCode() + "';)";

        executeQuery(query);

        /*try (Connection connection = ConnectionHandler.getConnection()) {
            String query = 'INSERT INTO product (name, description, default_price, default_currency) VALUES (?, ?, ?, ?)';

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setFloat(3,product.getDefaultPrice());
            preparedStatement.setString(4,product.getDefaultCurrency().getCurrencyCode());


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public Product find(int id) {
        String idString = String.valueOf(id);
        String query = "SELECT * FROM product WHERE id = '" + idString + "';";

        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            if(result.next()){
                Product product = new Product(result.getString("name"), result.getFloat("default_price"),
                        result.getString("default_currency"), result.getString("description"));
                System.out.println(product.getName());
                return product;
            } else {

                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("no product found");
        return null;
    }

    @Override
    public void remove(int id) {
        String idString = String.valueOf(id);

        String query = "DELETE FROM product WHERE id = '" + idString + "';";

        executeQuery(query);
    }

    @Override
    public List<Product> getAll() {

        List<Product> products = new LinkedList<>();
        String query = "SELECT * FROM product";

        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while(result.next()){
                Product product = new Product(result.getString("name"), result.getFloat("default_price"),
                        result.getString("default_currency"), result.getString("description"));
                System.out.println(product.getName());
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return data.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return data.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
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
