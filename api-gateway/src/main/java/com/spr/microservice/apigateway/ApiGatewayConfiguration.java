package com.spr.microservice.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

// we hardcode beans
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		return builder.routes()
			//	.route(p -> p.path("/get")
			//			.filters(f -> f.addRequestHeader("Myheader", "myURI").addRequestParameter("Param", "value"))
			//			.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				//.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-new/**") // url redirecting
						.filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
								"/currency-conversion/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
//		Function<PredicateSpec,Buildable<Route>> routeFunction= p-> p
//				.path("/get")
//				.filters(f->f.addRequestHeader("MyHeader", "myURI")
//						.addRequestParameter("MyParam", "myValue")
//						)
//				.uri("http://httpbin.org:80");
//		return builder.routes()      // we customize routes here with the following steps
//				.route(routeFunction)
//				.build();
	}
}
