package com.learnjava.completablefuture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.learnjava.domain.Product;
import com.learnjava.service.InventoryService;
import com.learnjava.service.ProductInfoService;
import com.learnjava.service.ReviewService;


import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;

class ProductServiceUsingCompletableFutureTest {

	ProductInfoService pis = new ProductInfoService();
	ReviewService rs = new ReviewService();
	InventoryService is = new InventoryService();
	ProductServiceUsingCompletableFuture pscf = new ProductServiceUsingCompletableFuture(pis, rs, is);

	@Test
	void testRetrieveProductDetails() {
		//given 
		String productId = "ABC123";
		startTimer();
		//when
		Product product = pscf.retrieveProductDetails(productId);
		System.out.println("Product is ::"+product);
		//then
		assertNotNull(product);
		assertNotNull(product.getProductInfo());
		assertTrue(product.getProductInfo().getProductOptions().size() > 0);
		assertNotNull(product.getReview());
	}

}
