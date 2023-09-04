package com.farmequipmentrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmequipmentrental.models.EquipmentDTO;
import com.farmequipmentrental.services.EquipmentService;

@CrossOrigin
@RestController
@RequestMapping("/api/equips")
public class EquipmentController {

	@Autowired private EquipmentService bservice;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody EquipmentDTO dto) {		
		bservice.saveEquipment(dto);
		return ResponseEntity.ok("Saved successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(bservice.listAll());
	}
	
	@GetMapping("variants/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.listVariantEquipments(id));
	}
	
	@GetMapping("search")
	public ResponseEntity<?> findById(String id) {		
		return ResponseEntity.ok(bservice.findById(id));
	}
	
	@GetMapping("filter/{id}")
	public ResponseEntity<?> filterByStatus(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.filterEquipments(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		System.out.println(id);
		bservice.deleteEquipment(id);
		return ResponseEntity.ok("Equipment deleted successfully");
	}
}
