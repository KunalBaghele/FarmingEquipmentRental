package com.farmequipmentrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.farmequipmentrental.daos.CompanyRepository;
import com.farmequipmentrental.entities.Company;

@Service
public class CompanyService {

	@Autowired private CompanyRepository repo;
	
	public void saveCompany(Company comp) {
		repo.save(comp);
	}
	
	public List<Company> listall(){
		return repo.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	public void deleteCompany(int id) {
		repo.deleteById(id);
	}
	
	public Company findById(int id) {
		return repo.findById(id).orElse(null);
	}
}
