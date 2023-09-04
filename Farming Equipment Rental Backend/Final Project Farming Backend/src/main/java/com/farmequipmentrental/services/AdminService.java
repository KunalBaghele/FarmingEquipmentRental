package com.farmequipmentrental.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmequipmentrental.daos.AdminRepository;
import com.farmequipmentrental.entities.Admin;

@Service
public class AdminService {
	
	@Autowired 
    private	AdminRepository dao;

	public Admin validate(String userid, String pwd) {
		// TODO Auto-generated method stub
		Optional<Admin> admin=dao.findById(userid);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}

	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(dao.getById(admin.getUserid()).getPwd());
		}
		dao.save(admin);		
	}

	public long countAdmin() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	public Admin findById(String userid) {
		Optional<Admin> admin = dao.findById(userid);
		if(admin.isPresent()) {
		return admin.get();
		}
		return null;
	}

	public Admin saveadminpass(Admin admin) {
		// TODO Auto-generated method stub
		Admin ad = dao.save(admin);
		if(ad!=null) 
		return ad;
		
		return null;
		
	}
	
	
}
