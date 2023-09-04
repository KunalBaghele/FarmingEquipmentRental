package com.farmequipmentrental.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmequipmentrental.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
