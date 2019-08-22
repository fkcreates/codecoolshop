package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.UserDaoMem;
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
import java.util.Iterator;
import java.util.List;


@WebServlet(urlPatterns = {"/cart/show/"})
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserDao userDataStore = UserDaoMem.getInstance();
        int userId = 0;

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("cart", userDataStore.findCartForUser(userId).getProductsInCart());
        engine.process("product/cart.html", context, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String removableId = request.getParameter("removeFromCart");
        int productToRemoveId = Integer.parseInt(removableId);
        boolean isRemovable = false;
        Product productToRemove = null;
        Cart cart = UserDaoMem.getInstance().findCartForUser(0);
        for (Product product : cart.getAll()) {
            if (product.getId() == productToRemoveId) {
                isRemovable = true;
                productToRemove = product;
            }
        }
        if (isRemovable == true) {
            cart.removeProductFromCart(productToRemove);
        }

        response.sendRedirect("/cart/show/");
    }
}
