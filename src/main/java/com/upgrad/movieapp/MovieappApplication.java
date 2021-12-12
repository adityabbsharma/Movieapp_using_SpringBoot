package com.upgrad.movieapp;

import com.upgrad.movieapp.dao.CityDao;
import com.upgrad.movieapp.dao.CustomerDao;
import com.upgrad.movieapp.entities.City;
import com.upgrad.movieapp.entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);
		CustomerDao customerDao = context.getBean(CustomerDao.class);
		Customer customer = new Customer();
		customer.setFirstName("Aditya");
		customer.setLastName("Sharma");
		customer.setUserName("adish");
		customer.setPassword("alfkif");
		customer.setDateOfBirth(LocalDateTime.of(1988,01,01,06,27));
		System.out.println("Before saving customer= "+customer);
		Customer savedCustomer = customerDao.save(customer);
		System.out.println("After saving customer= "+savedCustomer);

		CityDao cityDao = context.getBean(CityDao.class);
		City city = new City();
		city.setCityName("Rayagada");
		System.out.println("Before saving city= "+city);
		City savedCity = cityDao.save(city);
		System.out.println("After saving city= "+savedCity);

	}
	@RequestMapping(value = "/")
	public String helloWorld() {
		return "Hello World";
	}
}
