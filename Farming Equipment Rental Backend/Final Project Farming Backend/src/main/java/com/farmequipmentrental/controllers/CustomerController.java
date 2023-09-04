package com.farmequipmentrental.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmequipmentrental.entities.Admin;
import com.farmequipmentrental.entities.Customer;
import com.farmequipmentrental.models.LoginDTO;
import com.farmequipmentrental.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

@Autowired CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Customer cust) {
		if(customerService.verifyUserId(cust.getUserid())) {
			return ResponseEntity.badRequest().body("Email already registered");
		}
		customerService.registerCustomer(cust);
		return ResponseEntity.ok("Customer registered successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCustomers() {
		List<Customer> result = customerService.allCustomers();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Customer user=customerService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProfile(@RequestBody Customer cust) {
		customerService.updateProfile(cust);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	@PatchMapping
	public ResponseEntity<Customer> updateUser(@RequestBody LoginDTO updatepass) {
//        Optional<User> optionalUser = adminService.findById(id);
		
		Customer cust = customerService.findByUserId(updatepass.getUserid());

		if (cust!=null) {

			if (updatepass.getPwd() != null) {
				cust.setPwd(updatepass.getPwd());

				Customer cust1 = customerService.updatepass(cust);
				return ResponseEntity.ok(cust1);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.notFound().build();

	}
	
	
}
