package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.mem.ConnectionHandler;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {

    @Override
    public void add(Product product) {

        String query = "INSERT INTO product (name, description, default_price, default_currency) VALUES " +
                "('" + product.getName() + "', '" + product.getDescription() + "', '" +
                product.getDefaultPrice() + "', '" + product.getDefaultCurrency().getCurrencyCode() + "';)";

        executeQuery(query);
    }

    @Override
    public Product find(int id) {
        String idString = String.valueOf(id);
        String query = "SELECT * FROM product WHERE id = '" + idString + "';";

        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            if(result.next()){
                Product product = new Product(result.getInt("id"), result.getString("name"), result.getFloat("default_price"),
                        result.getString("default_currency"), result.getString("description"));
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

        String query = "SELECT * FROM product";

        return getListOfProducts(query);
    }

    @Override
    public List<Product> getBy(Supplier supplier) {

        String supplierId = String.valueOf(supplier.getId());
        String query = "SELECT * FROM supplier WHERE id = '" + supplierId + "';";

        return getListOfProducts(query);
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        int prodId = productCategory.getId();

        String prodCatId = String.valueOf(prodId);
        String query = "SELECT * FROM product WHERE product_category_id = '" + prodCatId + "';";

        List<Product> listOfProds = getListOfProducts(query);

        return listOfProds;

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

    private List<Product> getListOfProducts(String query) {
        List<Product> products = new LinkedList<>();
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while(result.next()){
                Product product = new Product(result.getInt("id"), result.getString("name"), result.getFloat("default_price"),
                        result.getString("default_currency"), result.getString("description"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

}
