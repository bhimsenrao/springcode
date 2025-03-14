package com.spr.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class CurrencyExchageController {
//@Autowired	Environment enironment;
//@Autowired CurrencyExchangeRepository repository;
//@GetMapping("/currency-exchange/from/{from}/to/{to}")
//public CurrencyExchage retreiveValue(@PathVariable String from, @PathVariable String to) {
////	CurrencyExchage currencyExchage =new CurrencyExchage(1000L,from,to,BigDecimal.valueOf(50));
//	String port=enironment.getProperty("local.server.port");
//	CurrencyExchage currencyExchage=repository.findByFromAndTo(from, to);
//    if(currencyExchage==null) {
//        currencyExchage =new CurrencyExchage(1000L,from,to,null);
//    	System.err.println("Unable to find from or to format");
//    }
//	currencyExchage.setEnvironment(port);
//	return currencyExchage;
//} 
//}


@RestController
public class CurrencyExchageController {
@Autowired	Environment enironment;
@GetMapping("/currency-exchange/from/{from}/to/{to}")
public CurrencyExchage retreiveValue(@PathVariable String from, @PathVariable String to) {
	CurrencyExchage currencyExchage =new CurrencyExchage(1000L,from,to,BigDecimal.valueOf(50));
	String port=enironment.getProperty("local.server.port");
	currencyExchage.setEnvironment(port);
	return currencyExchage;
} 
}
