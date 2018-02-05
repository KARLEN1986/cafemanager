package com.sfl.repsitory;


import com.sfl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Karlen on 05.02.2018.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {



}
