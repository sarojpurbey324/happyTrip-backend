package com.verscend.HappyTrip.CustomerController;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.verscend.HappyTrip.Entity.Customers;
import com.verscend.HappyTrip.Entity.Repository.CustomersRepository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Customers")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class CustomerController {
	
	
	@Autowired
	CustomersRepository cusRep;
	//TODO: need to store the username and password in the list
	//List<HashMap<String, String>> CustomersLogin = new ArrayList<>();
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public List<Customers> getAll(){
		return (List<Customers>) cusRep.findAll();
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void insert(@RequestBody Customers customer) {
		//saving the data to the database
		System.out.println(customer.toString());
		cusRep.save(customer);
		
	}
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public void update(@RequestBody Customers customer) {
		cusRep.save(customer);
		System.out.println("data updated!!!");
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		System.out.println(id);
		cusRep.deleteById(id);
	}
	@RequestMapping(value = "/sendMail")
	public void message() {
		
	}
	
	//This is used for login	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<String, String> login(@RequestBody String login) {
		
		//This hashmap is used to return data back to angular
		HashMap<String, String> returnedData = new HashMap<>();
		
		
		JSONObject loginObject = new JSONObject(login);
		String userName = loginObject.getString("userName");
		String password = loginObject.getString("password");
		
		List<Customers> customerList = (List<Customers>) cusRep.findAll();
		String result = "failed";
		returnedData.put("res",result);
		for(Customers cus : new ArrayList<>(customerList))
		{
			String name = cus.getFirstName()+" "+cus.getLastName();
			String pass = cus.getPassword();
			if(userName.equals(name) && password.equals(pass))
			{
				result = "passed";
				returnedData.put("res",result);
				return returnedData;
			}
		}
		
		return returnedData;
	}

		 

	
	
	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() 
	{
		  return new WebMvcConfigurerAdapter() 
		  {
			  @Override
			  public void addCorsMappings(CorsRegistry registry) 
			  {
				  	registry.addMapping("/*").allowedOrigins("*");
			  }
		  };
	 }
}

