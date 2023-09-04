package com.farmequipmentrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmequipmentrental.entities.Equipment;
import com.farmequipmentrental.entities.Variant;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, String> {

	List<Equipment> findByVariantAndStatus(Variant variant,String status);
	List<Equipment> findByStatus(String status);
}
