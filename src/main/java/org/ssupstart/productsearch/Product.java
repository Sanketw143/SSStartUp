package org.ssupstart.productsearch;


//  "id": "P123",
//          "name": "Samsung Galaxy S23",
//          "description": "Flagship smartphone with advanced camera",
//          "category": "Electronics",
//          "price": 799.99,
//          "rating": 4.5

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Float rating;
}
