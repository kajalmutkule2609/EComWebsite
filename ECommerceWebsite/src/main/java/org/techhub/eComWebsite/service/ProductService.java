package org.techhub.eComWebsite.service;

import java.util.List;

import org.techhub.eComWebsite.Model.ProductModel;

public interface ProductService {
	public boolean addNewProduct(ProductModel product);
	public List<ProductModel> getAllProducts();
	public List<ProductModel> searchProduct(String category);
	public boolean updateProduct(String category);
	public boolean deleteProduct(String category);
	public List<ProductModel> sortProductsByPriceLowToHigh();
	public List<ProductModel> sortProductsByPriceHighToLow();
}
