package com.ProductsAndCategories.justin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProductsAndCategories.justin.models.Category;
import com.ProductsAndCategories.justin.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
	//Find List of Product that do NOT belong to category
	List<Product> findByCategoriesNotContaining(Category category);
}