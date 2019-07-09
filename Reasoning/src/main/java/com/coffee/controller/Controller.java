package com.coffee.controller;

import javax.json.JsonObject;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.coffee.com.coffee.reasoning.Reasoning;

@RestController
public class Controller {

	@CrossOrigin
	@RequestMapping(value = "/reasoning/validModel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean validModel(@RequestBody JSONObject data) throws Exception {
		boolean isValid = true; 
		System.out.println(data.get("data"));
		return isValid;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/reasoning/oneConfiguration", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String oneConfiguration(@RequestBody JSONObject model, @RequestBody JSONObject configuration) throws Exception {
		//TODO:fix me
		String frontEndData="{\r\n" + 
				" \"solverSelected\" : \"\",\r\n" + 
				" \"problemType\":\"BOOL\",\r\n" + 
				"\"configuration\" : \r\n" + 
				"	{\r\n" + 
				"	\"DFS\":true,\r\n" + 
				"	\"mstprim\":false\r\n" + 
				"	}\r\n" + 
				"}";
//		System.out.println("Model: " + model.get("data"));
//		System.out.println("Configuration: " + configuration.get("data"));
		Reasoning reasoning = new Reasoning();
		JsonObject solution = reasoning.coffeeCompile((String) model.get("data"), frontEndData,(String) configuration.get("data"), 1);
		return solution.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/reasoning/nConfigurations", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String nConfigurations(@RequestBody int n, @RequestBody JSONObject configuration, @RequestBody JSONObject model) throws Exception {
		String frontEndData="{\r\n" + 
				" \"solverSelected\" : \"\",\r\n" + 
				" \"problemType\":\"BOOL\",\r\n" + 
				"\"configuration\" : \r\n" + 
				"	{\r\n" + 
				"	\"DFS\":true,\r\n" + 
				"	\"mstprim\":false\r\n" + 
				"	}\r\n" + 
				"}";
//		System.out.println("Number of configurations: " + n);
//		System.out.println("Configuration: " + configuration.get("data"));
		Reasoning reasoning = new Reasoning();
		JsonObject solution = reasoning.coffeeCompile((String) model.get("data"), frontEndData,(String) configuration.get("data"), n);
		return solution.toString();
	}
	
}
