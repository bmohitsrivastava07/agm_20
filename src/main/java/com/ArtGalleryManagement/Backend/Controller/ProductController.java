package com.ArtGalleryManagement.Backend.Controller;

import com.ArtGalleryManagement.Backend.Entity.*;
import com.ArtGalleryManagement.Backend.ResponseModels.*;
import com.ArtGalleryManagement.Backend.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/secure/currentloans")
	public List<ShelfCurrentLoansResponse> currentLoans() throws Exception {
		String userEmail = "mohit@gmail.com";
		return productService.currentLoans(userEmail);
	}

	@GetMapping("/secure/currentloans/count")
	public int currentLoansCount() {
		String userEmail = "mohit@gmail.com";
		return productService.currentLoansCount(userEmail);
	}

	@GetMapping("/secure/ischeckedout/byuser")
	public Boolean checkoutProductByUser(@RequestParam Long productId) {
		String userEmail = "mohit@gmail.com";
		return productService.checkoutProductByUser(userEmail, productId);
	}

	@PutMapping("/secure/checkout")
	public Product checkoutProduct(@RequestParam Long productId) throws Exception {
		String userEmail = "mohit@gmail.com";
		return productService.checkoutProduct(userEmail, productId);
	}

	@PutMapping("/secure/return")
	public void returnProduct(@RequestParam Long productId) throws Exception {
		String userEmail = "mohit@gmail.com";
		productService.returnProduct(userEmail, productId);
	}

	@PutMapping("/secure/renew/loan")
	public void renewLoan(@RequestParam Long productId) throws Exception {
		String userEmail = "mohit@gmail.com";
		productService.renewLoan(userEmail, productId);
	}

}
