package com.ProductsAndCategories.justin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductsAndCategories.justin.models.Category;
import com.ProductsAndCategories.justin.models.Product;
import com.ProductsAndCategories.justin.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public Product createProduct(Product newProduct) {
		Product product = this.pRepo.save(newProduct);
		return product;
	}
	
	//Get All Products
	public List<Product> findAllProducts() {
		List<Product> productsList = this.pRepo.findAll();
		return productsList;
	}
	
	//Get One Product
	public Product findOneProduct(Long id) {
		Product product = this.pRepo.findById(id).orElse(null);
		return product;
	}
	
	//List of Products not in Category
	public List<Product> productsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContaining(category);
	}
	
}
