package com.dingdang.webflux.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		try {
			Thread.sleep(100l);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Hello World";
	}
	@GetMapping("/welcomeNew")
	public Mono<String> welcomeNew() {
		return Mono.just("Hello World")
			.delayElement(Duration.ofMillis(100));
	}

	/*@GetMapping("/test")
	public Mono<String> test(){
		return Mono.create(sink -> {
			try {
				Thread.sleep(100l);
			}catch(Exception e){
				e.printStackTrace();
			}
			sink.success("success");
		});
	}
	@GetMapping("/testLegend")
	public String testLegend(){
		try {
			Thread.sleep(100l);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}*/

}