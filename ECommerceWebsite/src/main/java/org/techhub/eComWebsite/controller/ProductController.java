package org.techhub.eComWebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.eComWebsite.Model.ProductModel;
import org.techhub.eComWebsite.service.ProductServiceImp;

@RestController
@RequestMapping("/ECommerceWebsite/Product")
public class ProductController {
	@Autowired
	ProductServiceImp prodService;
	
	@GetMapping("/checkData")
	public String checkData() {
		return "success";
	}
	
	
	@PostMapping("/addProduct")
	public String addNewProduct(@RequestBody ProductModel model) {
		boolean b=prodService.addNewProduct(model);
		if(b) {
			return "Product Added Successfully";
		}
		else {
			return "product not added";
		}
	}
	
	@GetMapping("/getAllProducts")
	public List<ProductModel> getAllProducts() {
	    return prodService.getAllProducts();
	}

}
