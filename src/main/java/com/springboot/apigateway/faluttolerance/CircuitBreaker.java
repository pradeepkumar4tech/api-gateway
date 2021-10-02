package com.springboot.apigateway.faluttolerance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreaker {
	
	Logger logger=LoggerFactory.getLogger(CircuitBreaker.class);

	@GetMapping("sample-api")
	//@Retry(name="default" ,fallbackMethod = "fallbackMethod") // it will call the fall back method there times
	//@Retry(name="sample-api" ,fallbackMethod = "fallbackMethod") // it will call the fall back method based on properties configuration
	//@io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "default" ,fallbackMethod = "fallbackMethod")
	//@RateLimiter(name = "default")
	//@Bulkhead(name = "default")
	@Bulkhead(name = "sample-api")  //we can fix  the no of concurrent calls for this api
	public String sampleRestCall() {
		logger.info("Inside sample Api");
		//ResponseEntity<String> restTemplate=new RestTemplate().getForEntity("http://localhost:8080/test-service", String.class);
		return "Hellow";
	}

	public String fallbackMethod(Exception e) {
		return "fall-back-response";
	}
}
