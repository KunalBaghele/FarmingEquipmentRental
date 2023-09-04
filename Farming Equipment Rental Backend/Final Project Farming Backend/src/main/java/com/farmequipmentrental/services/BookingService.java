package com.farmequipmentrental.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.farmequipmentrental.daos.BookingRepository;
import com.farmequipmentrental.daos.FeedbackRepository;
import com.farmequipmentrental.daos.PaymentRepository;
import com.farmequipmentrental.entities.Equipment;
import com.farmequipmentrental.entities.Booking;
import com.farmequipmentrental.entities.Customer;
import com.farmequipmentrental.entities.Feedback;
import com.farmequipmentrental.entities.Payment;
import com.farmequipmentrental.entities.Variant;
import com.farmequipmentrental.models.BookingCompleteDTO;
import com.farmequipmentrental.models.BookingDTO;
import com.farmequipmentrental.models.BookingStatusDTO;

@Service
public class BookingService {

	@Autowired private BookingRepository brepo;
	@Autowired private PaymentRepository prepo;
	@Autowired private CustomerService csrv;
	@Autowired private VariantService vsrv;
	@Autowired private EquipmentService bksrv;
	@Autowired private FeedbackRepository frepo;
	
	public void saveBooking(BookingDTO dto) {
		System.out.println(dto);
		Customer customer=csrv.findByUserId(dto.getUserid());
		Variant variant=vsrv.findById(dto.getVarid());
		
		Booking bk=new Booking();
		BeanUtils.copyProperties(dto, bk);
		bk.setCustomer(customer);
		bk.setVariant(variant);
		System.out.println(bk);
		brepo.save(bk);
		
		Payment pmt=new Payment();
		BeanUtils.copyProperties(dto, pmt);
		pmt.setRemarks("Booking Amount");
		pmt.setBooking(bk);
		pmt.setAmount(dto.getAdvance());
		System.out.println(pmt);
		prepo.save(pmt);
		
	}
	
	public void updateBooking(BookingStatusDTO dto) {
		Booking bk=findById(dto.getBid());
		Equipment bik=bksrv.findById(dto.getBno());
		bk.setEquipment(bik);
		bk.setStatus("Confirmed");
		brepo.save(bk);
		
		bik.setStatus("Not Available");
		bksrv.updateEquipment(bik);
	}
	
	public void completeBooking(BookingCompleteDTO dto) {
		Booking bk=findById(dto.getBid());
		
		Equipment equipment=bk.getEquipment();
		equipment.setStatus("Available");
		bksrv.updateEquipment(equipment);		
		
		Payment pmt=new Payment();
		pmt.setAmount(dto.getAmount());
		pmt.setBooking(bk);
		pmt.setNameoncard(dto.getNameoncard());
		pmt.setCardno(dto.getCardno());
		pmt.setRemarks("Payment completed");
		pmt.setIscompleted(true);
		prepo.save(pmt);
		
		Feedback fb=new Feedback();
		fb.setCustomer(bk.getCustomer());
		fb.setDescr(dto.getFeedback());
		fb.setRatings(dto.getRatings());
		
		frepo.save(fb);
	}
	
	public List<Feedback> allFeedbacks(){
		return frepo.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	public void cancelBooking(int id) {
		List<Payment> pmts=prepo.findByBooking(brepo.findById(id).get());
		prepo.deleteAll(pmts);
		brepo.deleteById(id);
	}
	
	public Booking findById(int id) {
		return brepo.findById(id).get();
	}
	
	public List<Booking> findAllBookings(){
		return brepo.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	public List<Payment> findAllPayments(){
		return prepo.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	public List<Booking> findUserBookings(String userid){
		return brepo.findByCustomer(csrv.findByUserId(userid));
	}
	
	public List<Payment> findBookingPayments(int id){
		return prepo.findByBooking(brepo.findById(id).get());
	}
}

