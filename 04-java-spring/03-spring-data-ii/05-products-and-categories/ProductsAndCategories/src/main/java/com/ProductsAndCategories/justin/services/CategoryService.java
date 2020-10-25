package com.ProductsAndCategories.justin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductsAndCategories.justin.models.Category;
import com.ProductsAndCategories.justin.models.Product;
import com.ProductsAndCategories.justin.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public Category createCategory(Category newCategory) {
		Category category = this.cRepo.save(newCategory);
		return category;
	}
	
	public List<Category> findAllCategories() {
		List<Category> categoriesList = this.cRepo.findAll();
		return categoriesList;
	}
	
	public Category findOneCategory(Long id) {
		Category category = this.cRepo.findById(id).orElse(null);
		return category;
	}	
	
	public void addCategory(Category category, Product product) {
		//Get List from Products
		List<Product> categorizedProducts = category.getProducts();
		categorizedProducts.add(product);
		this.cRepo.save(category);		
	}
	
	public List<Category> categoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContaining(product);
	}
	
	
	
}
