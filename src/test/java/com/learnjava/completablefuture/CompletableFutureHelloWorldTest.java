package com.learnjava.completablefuture;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.learnjava.service.HelloWorldService;

class CompletableFutureHelloWorldTest {
	
	 HelloWorldService hws = new HelloWorldService();
	 CompletableFutureHelloWorld cfhw = new CompletableFutureHelloWorld(hws);

	@Test
	void hellow_world() {
		//given 
		
		//when
		CompletableFuture<String> completableFuture = cfhw.hellowWorld();
		
		//then
		completableFuture.thenAccept(s->assertEquals("HELLO WORLD", s)).join();
		
	}

}
