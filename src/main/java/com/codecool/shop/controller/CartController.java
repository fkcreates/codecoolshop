package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.mem.UserDaoJdbc;
import com.codecool.shop.dao.implementation.mem.UserDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/cart/show/"})
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserDao userDataStore = UserDaoJdbc.getInstance();
        int userId = 1;  // TODO: get from request

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("cart", userDataStore.findCartForUser(userId).getCart());
        context.setVariable("cartProductList", userDataStore.findCartForUser(userId).getProductsInCart());
        context.setVariable("cartProductsSet", userDataStore.findCartForUser(userId).getMapOfProductsInCart());
        engine.process("product/cart.html", context, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productToRemoveId = Integer.parseInt(request.getParameter("removeFromCart"));
        boolean isRemovable = false;
        Product productToRemove = null;
        UserDao userDataStore = UserDaoJdbc.getInstance();
        Cart cart = userDataStore.findCartForUser(1);

        for (Product product : cart.getAll()) {
            if (product.getId() == productToRemoveId) {
                isRemovable = true;
                productToRemove = product;
            }
        }
        if (isRemovable) {
            cart.removeProductFromCart(productToRemove);
        }

        response.sendRedirect("/cart/show/");
    }
}
