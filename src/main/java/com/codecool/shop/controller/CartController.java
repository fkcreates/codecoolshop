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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        UserDao userDataStore = UserDaoMem.getInstance();
        int userId = 0;

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("cart", userDataStore.findCartForUser(userId).getProductsInCart());
        engine.process("product/cart.html", context, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ProductToRemoveId = request.getParameter("removeFromCart");
        if (ProductToRemoveId != null) {
            Cart cart = UserDaoMem.getInstance().findCartForUser(0);
            Iterator<Product> itr = cart.getAll().iterator();
            while (itr.hasNext()) {
                Product thisProduct = itr.next();
                if (thisProduct.getId() == Integer.parseInt(ProductToRemoveId)) {
                    cart.removeProductFromCart(thisProduct);
                    System.out.println(thisProduct);
                }
//                break;
            }
        }
        response.sendRedirect("/cart/show/");
    }
}
