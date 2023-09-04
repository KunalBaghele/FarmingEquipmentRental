package com.farmequipmentrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmequipmentrental.entities.Company;
import com.farmequipmentrental.entities.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {

	List<Variant> findByCompany(Company company);
}
