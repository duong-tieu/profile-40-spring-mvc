package com.example.cms.service;


import com.example.cms.model.Product;

import java.util.*;

public class ProductServiceImpl implements IProductService{

    private static final Map<Integer,Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"Hoa huong  duong",200.00));
        productList.put(2,new Product(2,"Hoa hong",210.00));
        productList.put(3,new Product(3,"cam mi",2000.00));
        productList.put(5,new Product(4,"mit thai",2100.00));
        productList.put(4,new Product(5,"banh osi",200.00));
        productList.put(7,new Product(6,"nuoc cam vat",20500.01));
        productList.put(11,new Product(7,"ca ngu",200000.00));
        productList.put(13,new Product(8,"nuoc ngot co ga",550.00));
        productList.put(10,new Product(9,"ban hoc",330.00));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),new Product());
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void remove(int id) {
      productList.remove(id);
    }

    @Override
    public Product search(String name) {
      return productList.get(name);
    }
}
