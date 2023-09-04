package com.farmequipmentrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmequipmentrental.entities.Customer;
import com.farmequipmentrental.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	List<Feedback> findByCustomer(Customer customer);
}
