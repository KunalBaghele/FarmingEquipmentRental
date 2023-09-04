package com.farmequipmentrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmequipmentrental.entities.Admin;
import com.farmequipmentrental.models.LoginDTO;
import com.farmequipmentrental.models.Response;
import com.farmequipmentrental.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Admin admin = adminService.validate(dto.getUserid(), dto.getPwd());
		if (admin != null)
			return ResponseEntity.ok(admin);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> updateProfile(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PatchMapping
	public ResponseEntity<Admin> updateUser(@RequestBody LoginDTO updatepass) {
//        Optional<User> optionalUser = adminService.findById(id);
		Admin admin = adminService.findById(updatepass.getUserid());

		if (admin != null) {

			if (updatepass.getPwd() != null) {
				admin.setPwd(updatepass.getPwd());

				Admin savedUser = adminService.saveadminpass(admin);
				return ResponseEntity.ok(savedUser);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.notFound().build();

	}
		
}

//    @Autowired
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            
//            // Apply partial updates from the updatedUser to the existing user
//            if (updatedUser.getUsername() != null) {
//                user.setUsername(updatedUser.getUsername());
//            }
//            
//            if (updatedUser.getEmail() != null) {
//                user.setEmail(updatedUser.getEmail());
//            }
//            
//            User savedUser = userRepository.save(user);
//            return ResponseEntity.ok(savedUser);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
