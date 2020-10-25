package com.ProductsAndCategories.justin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProductsAndCategories.justin.models.Category;
import com.ProductsAndCategories.justin.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	

	List<Category> findByProductsNotContaining(Product product);
	
}
