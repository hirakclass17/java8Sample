package com.learnjava.completablefuture;

import java.util.concurrent.CompletableFuture;

import com.learnjava.domain.Product;
import com.learnjava.domain.ProductInfo;
import com.learnjava.domain.Review;
import com.learnjava.service.InventoryService;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ReviewService;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
import static com.learnjava.util.CommonUtil.stopWatchReset;

import static com.learnjava.util.LoggerUtil.log;

public class ProductServiceUsingCompletableFuture {

	private ProductInfoService productInfoService;
	private ReviewService reviewService;
	private InventoryService inventoryService;

	public ProductServiceUsingCompletableFuture(ProductInfoService productInfoService, ReviewService reviewService) {
		this.productInfoService = productInfoService;
		this.reviewService = reviewService;
	}

	public ProductServiceUsingCompletableFuture(ProductInfoService productInfoService, ReviewService reviewService, InventoryService inventoryService) {
		this.productInfoService = productInfoService;
		this.reviewService = reviewService;
		this.inventoryService = inventoryService;
	}
	
	public Product retrieveProductDetails(String productId) {
		
		startTimer();
		//call productInfoService.retrieveProductInfo(productId) using CompletableFuture
		CompletableFuture<ProductInfo> cfProductInfo = CompletableFuture.supplyAsync(()->productInfoService.retrieveProductInfo(productId));
		//call reviewService.retrieveReviews(productId) using CompletableFuture
		CompletableFuture<Review> cfReview = CompletableFuture.supplyAsync(()->reviewService.retrieveReviews(productId));
		
		Product product = cfProductInfo.thenCombine(cfReview, (productInfo, review)->new Product(productId, productInfo, review))
				.join(); 
		
		timeTaken();
		
		return product;
	}
	
	public static void main(String[] args) {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingCompletableFuture productService = new ProductServiceUsingCompletableFuture(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);

    }

}
