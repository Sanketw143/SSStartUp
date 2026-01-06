package org.ssupstart.productsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    ProductResponseDto getProducts(@RequestParam("query") String query,
                                   @RequestParam("category") String category,
                                   @RequestParam("page") Integer page,
                                   @RequestParam("size") Integer size) {
        List<Product> productList = productService.getProductsByFilters(query,category,page,size);
        return buildFinalResponse(productList, page, size);
    }

    private ProductResponseDto buildFinalResponse(List<Product> productList, Integer page, Integer size) {
        ProductResponseDto response = new ProductResponseDto();
        response.setPage(page);
        response.setSize(size);
        if(!productList.isEmpty()) {
            response.setTotalItems(productList.size());
            response.setItems(productList);
        } else {
            response.setTotalItems(0);
        }
        return response;
    }
}
