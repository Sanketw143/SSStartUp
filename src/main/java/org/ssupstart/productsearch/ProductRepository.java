package org.ssupstart.productsearch;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        Product p1 = Product.builder().id(1).price(100D).name("abc")
                .category("appareal").rating(4f).build();
        Product p2 = Product.builder().id(2).price(200D).name("xyz")
                .category("footwear").rating(3f).build();
        allProducts.add(p1);
        allProducts.add(p2);
        return allProducts;
    };
}
