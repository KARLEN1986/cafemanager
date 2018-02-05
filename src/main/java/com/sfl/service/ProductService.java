package com.sfl.service;

import com.sfl.entity.Product;
import com.sfl.repsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Karlen on 05.02.2018.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void  addProduct(String name){
        Product product=new Product();
        product.setName(name);
        productRepository.save(product);
    }

    public List<Product> getProductList(){
        return productRepository.findAll();
    }



}
