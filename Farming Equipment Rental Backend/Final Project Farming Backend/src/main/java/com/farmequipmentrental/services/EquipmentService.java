package com.farmequipmentrental.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.farmequipmentrental.daos.EquipmentRepository;
import com.farmequipmentrental.entities.Equipment;
import com.farmequipmentrental.models.EquipmentDTO;

@Service
public class EquipmentService {

	@Autowired private EquipmentRepository brepo;
	@Autowired private VariantService vsrv;
	
	public void saveEquipment(EquipmentDTO dto) {
		Equipment equipment=new Equipment();
		if(brepo.existsById(dto.getId())) {			
			equipment=brepo.findById(dto.getId()).get();
		}		
		BeanUtils.copyProperties(dto, equipment);
		equipment.setVariant(vsrv.findById(dto.getVarid()));
		brepo.save(equipment);
	}
	
	public void updateEquipment(Equipment bk) {
		brepo.save(bk);
	}
	
	public List<Equipment> listAll(){
		return brepo.findAll(Sort.by(Direction.DESC, "createdon"));
	}
	
	public Equipment findById(String id) {
		return brepo.findById(id).get();
	}
	
	public List<Equipment> filterEquipments(int id){
		System.out.println("Filter id "+id);
		if(id==1)
			return brepo.findByStatus("Available");
		else
			return brepo.findByStatus("Not Available");
	}
	
	public List<Equipment> listVariantEquipments(int varid){
		return brepo.findByVariantAndStatus(vsrv.findById(varid),"Available");
	}
	
	public void deleteEquipment(String id) {
		if(brepo.existsById(id)) {
			brepo.deleteById(id);
		}
	}	
}
