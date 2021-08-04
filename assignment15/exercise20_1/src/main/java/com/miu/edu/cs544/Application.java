package com.miu.edu.cs544;

import com.miu.edu.cs544.controller.CountryRegionController;
import com.miu.edu.cs544.model.CountryRegion;
import com.miu.edu.cs544.service.CountryRegionCurrencyServiceImp;
import com.miu.edu.cs544.service.CountryRegionService;
import com.miu.edu.cs544.service.CountryRegionServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		CountryRegionController context2 = context.getBean(CountryRegionController.class);
		context2.countryRegionList();
	}
}
