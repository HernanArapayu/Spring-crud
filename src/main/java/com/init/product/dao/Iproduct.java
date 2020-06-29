package com.init.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.product.Entitys.Product;


@Repository
public interface Iproduct extends JpaRepository<Product,Long> {

}
