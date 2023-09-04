package com.farmequipmentrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmequipmentrental.entities.Booking;
import com.farmequipmentrental.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	List<Payment> findByBooking(Booking booking);

}
