package com.spr.microservice.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConverion(@PathVariable String from, @PathVariable String to, 
			@PathVariable BigDecimal quantity) {
	
	HashMap<String,String> uriValriables= new HashMap<>();
	uriValriables.put("from", from);
	uriValriables.put("to", to);
	
	ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
			"http://localhost:9090/currency-exchange/from/{from}/to/{to}", 
			CurrencyConversion.class,uriValriables);
	CurrencyConversion currencyConversion = responseEntity.getBody();
//	return new CurrencyConversion(100L,from,to,BigDecimal.valueOf(65),BigDecimal.ONE,BigDecimal.ONE,"");
  
	return new CurrencyConversion(currencyConversion.getId(), from, to, quantity ,
		  currencyConversion.getConversionMultiple(),quantity.multiply(currencyConversion.getConversionMultiple()),
		  currencyConversion.getEnvironment()); 
}

}
