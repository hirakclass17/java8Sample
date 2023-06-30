package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.LoggerUtil.log;


public class CompletableFutureHelloWorld {
	
	private HelloWorldService hws;
	
	public CompletableFutureHelloWorld(HelloWorldService hws) {
		this.hws = hws;
	}
	
	public CompletableFuture<String> hellowWorld() {
		return CompletableFuture.supplyAsync(()->hws.helloWorld()).thenApply(String::toUpperCase);
	}

    public static void main(String[] args) {

        HelloWorldService hws = new HelloWorldService();

       CompletableFuture.supplyAsync(()->hws.helloWorld())
       .thenAccept(result->log("result is" +result)).join();
       
       log("Done from main thread");
    }
}
