package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.implementation.mem.ConnectionHandler;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    @Override
    public void add(ProductCategory category) {

        String query = "INSERT INTO product_category (name, description, department) VALUES " +
                "('" + category.getName() + "', '" + category.getDescription() + "', '" +
                category.getDepartment() + "';)";

        executeQuery(query);
    }

    @Override
    public ProductCategory find(int id) {

        String idString = String.valueOf(id);
        String query = "SELECT * FROM product_category WHERE id = '" + idString + "';";

        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            if(result.next()){
                ProductCategory productCategory = new ProductCategory(result.getInt("id"), result.getString("name"), result.getString("description"),
                        result.getString("department"));
                return productCategory;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("no product category found");
        return null;
    }

    @Override
    public void remove(int id) {
        String idString = String.valueOf(id);

        String query = "DELETE FROM product_category WHERE id = '" + idString + "';";

        executeQuery(query);
    }

    @Override
    public List<ProductCategory> getAll() {

        String query = "SELECT * FROM product";

        return getListOfProductCategories(query);
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

    private List<ProductCategory> getListOfProductCategories(String query) {
        List<ProductCategory> productCategories = new LinkedList<>();
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while(result.next()){
                ProductCategory productCategory = new ProductCategory(result.getInt("id"),
                        result.getString("name"), result.getString("description"),
                        result.getString("department"));
                productCategories.add(productCategory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }
}
