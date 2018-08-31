package com.verscend.HappyTrip.CustomerController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.verscend.HappyTrip.Entity.Repository.UserMessageRepository;
import com.verscend.HappyTrip.Entity.UserQuery;
@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/UserQuery")

public class UserQueryController {

			@Autowired
			UserMessageRepository messageRepo;
			
			@RequestMapping(value = "/all",method = RequestMethod.GET)
			public List<UserQuery> getAll() {
				return (List<UserQuery>) messageRepo.findAll();
			}
			@RequestMapping(value = "/add",method = RequestMethod.POST)
			public void insert(@RequestBody UserQuery userQ) {
				messageRepo.save(userQ);
			}
			@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
			public void delete(@PathVariable("id") int id) {
				messageRepo.deleteById(id);
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
