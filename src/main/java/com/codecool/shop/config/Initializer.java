package com.codecool.shop.config;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.dao.implementation.mem.CartDaoMem;
//import com.codecool.shop.dao.implementation.mem.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.mem.SupplierDaoMem;
import com.codecool.shop.dao.implementation.mem.UserDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*ProductDao productDataStore = new ProductDaoJdbc();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        UserDao userDataStore = UserDaoMem.getInstance();
        CartDao cartDataStore = CartDaoMem.getInstance();

        //setting up a new supplier
       *//* Supplier amazon = new Supplier('Amazon', 'Digital content and services, also kitchen stuff.');
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier('Lenovo', 'Computers');
        supplierDataStore.add(lenovo);*//*

        //setting up a new product category
       *//* ProductCategory tablet = new ProductCategory('Tablet', 'Hardware', 'A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.');
        ProductCategory kitchenMgmt = new ProductCategory('Kitchen stuff', 'Kitchen', 'Essentials for your kitchen.');
        productCategoryDataStore.add(tablet);
        productCategoryDataStore.add(kitchenMgmt);*//*

        //The pics. doesn't working properly rgt now bc of the id, so I had to create another pics with (4.id) just for test <we need to delete it in the end>
        *//*productDataStore.add(new Product('Awesome cocktail glass', 35, 'USD', 'The curviest glass youve ever seen.'));
        productDataStore.add(new Product('Forkest fork', 144, 'USD', 'Pure silver fork that picks up any food you want it to. Simply the best.', kitchenMgmt, amazon));
        productDataStore.add(new Product('Set of knives and forks', 300, 'USD', 'This set contains 4 butter knives and 4 forks. They'll look like you've inherited them from your great-grandma. But we know it's just a mainstream deal.', kitchenMgmt, amazon));
        productDataStore.add(new Product('Pure plate', 25, 'USD', 'A very simple and elegant plate. Serve your dinner, lunch or even breakfast in it. You won't be disappointed, we promise.', kitchenMgmt, amazon));
        productDataStore.add(new Product('Bamboo cutlery', 48, 'USD', 'Cutlery set made of bamboo. Please take care of the environment so our children can live long. Even though Pandas die so we can make these. No worries, they look cool.', kitchenMgmt, amazon));*//*

        productDataStore.find(6);
        *//*productDataStore.add(new Product('Amazon Fire', 49.9f, 'USD', 'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.', tablet, amazon));
        productDataStore.add(new Product('Amazon Fire HD 8', 89, 'USD', 'Amazon's latest Fire HD 8 tablet is a great value for media consumption.', tablet, amazon));
        productDataStore.add(new Product('Lenovo IdeaPad Miix 700', 479, 'USD', 'Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.', tablet, lenovo));*//*

        User firstUser = new User('firstUser');

        userDataStore.add(firstUser);

        //This line below stays!!
        cartDataStore.add(firstUser.getCart());*/
    }
}
