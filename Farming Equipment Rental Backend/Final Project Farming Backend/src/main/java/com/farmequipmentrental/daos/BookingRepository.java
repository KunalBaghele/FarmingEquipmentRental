package com.farmequipmentrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmequipmentrental.entities.Booking;
import com.farmequipmentrental.entities.Customer;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByCustomer(Customer customer);
}
