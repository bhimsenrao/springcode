package com.spr.microservice.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="Currency-Exchange", url="localhost:9090")
@FeignClient(name="Currency-Exchange")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion retreiveValue(@PathVariable String from, @PathVariable String to);
}
