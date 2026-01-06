package org.ssupstart.productsearch;


import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private Integer page;
    private Integer size;
    private Integer totalItems;
    private Integer totalPages;
    private List<Product> items;
}
