package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Dao;
import com.example.model.Model;

@RestController
public class CarController {
	@Autowired
	Dao d1;

	@RequestMapping(value = "/")

	public String show() {
		return "index";
	}
	
	@RequestMapping(value="/all")
	public ResponseEntity<List<Model>>AllItems(){
	System.out.println("Get all Methods");
	return new ResponseEntity<List<Model>>(d1.getAll(), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Object> addDetails(@RequestBody Model m1) {
		String message = "null";
		if (d1.additem(m1.getName(), m1.getCategory()) >= 1) {
			message = "data saved succesfully";

		} else {
			message = "please check";
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String DeleteDetails(@PathVariable("id") int id) {
		if (d1.deleteIteam(id) >= 1) {
			return "Data removed succesfully";

		} else {
			return "please check";

		}

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String updateDetails(@PathVariable("id") int id, @RequestBody Model m1)

	{
		if (d1.updateIteam(id, m1.getName(), m1.getCategory()) >= 1)
		{
			return "data update succesfully";

		} else {
			return "please check";
		}
	}

}
