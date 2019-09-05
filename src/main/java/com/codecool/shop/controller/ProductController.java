package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.mem.UserDaoJdbc;
import com.codecool.shop.dao.implementation.mem.UserDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    Cart cart = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = new ProductDaoJdbc();
        ProductCategoryDao productCategoryDataStore = new ProductCategoryDaoJdbc();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("category", productCategoryDataStore.find(1));
        context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        engine.process("product/index.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDao productDataStore = new ProductDaoJdbc();

        int productToAddId = Integer.parseInt(request.getParameter("addToCart"));
        List<Product> products = productDataStore.getAll();
        //UserDao user = UserDaoJdbc.getInstance();
        cart = UserDaoJdbc.getInstance().findCartForUser(1);

        for (Product product : products) {
            if (product.getId() == productToAddId) {
                cart.addProductToCart(product);
            }
        }
        for(Product product: cart.getProductsInCart()) {
            System.out.println(product.getName());
        }
        response.sendRedirect("/");
    }
}
