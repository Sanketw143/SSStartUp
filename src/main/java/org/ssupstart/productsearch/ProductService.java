package org.ssupstart.productsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductsByFilters(String query, String category, Integer page, Integer size) {
        List<Product> allProducts = productRepository.getAllProducts();
        List<Product> finalProductList = new ArrayList<>(allProducts);

        if(StringUtils.hasText(query)) {
            finalProductList = allProducts.stream().filter(e -> e.getName().contains(query) || e.getDescription().contains(query)).toList();
        }
        if(StringUtils.hasText(category)) {
            finalProductList = finalProductList.stream().filter(e -> e.getCategory().equalsIgnoreCase(category)).toList();
        }
        finalProductList.sort(Comparator.comparing(Product :: getPrice));
//        int startIndex = page*size;
//        int endIndex =

        return finalProductList;
    }
}
