package com.Test.Hometest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Test.Hometest.Entity.Staff;
import com.Test.Hometest.service.Staffservice;

@RestController
public class Staffcontroller {

	
	@Autowired
	Staffservice st;
	
	@GetMapping("sshow")
 public List<Staff> getStaff(@RequestBody Staff staff) {
		List<Staff> staf=st.getStaff(staff);
		return staf;
	}
	@GetMapping("staffno3")
	public Staff staffno(@RequestBody Staff  staff) {
		Staff staf=st.staffno(staff);
		return staf;
	}
	@PostMapping("insert")
	public boolean staffinsert(@RequestBody Staff staff) {
		st.staffinsert(staff);
		return true;	
	}
	
	@GetMapping("list")
	List<Staff> slist(@RequestBody Staff staff ) {
		List<Staff> staf=st.slist(staff);
		return staf;	
	}
	
	@GetMapping("exp")
	public List<Staff>  expstaff(@RequestBody Staff staff) {
		List<Staff> staf=st.expstaff(staff);
		return staf;
		
	}
	
	@PutMapping("update")
	public boolean updatestaf(@RequestBody Staff  staff) {
		st.updatestaf(staff);
		return true;
	}
	
	
	@GetMapping("profile")
	public List<Staff> profile() {
		List<Staff> staf=st.profile();
		return staf;
	}
	
	
	@GetMapping("notprofile")
	public List<Staff> noprofile() {
		List<Staff> staf=st.noprofile();
		return staf;
	}
	
	@GetMapping("max")
	public List<String> maxsalary() {
		List<String> ls=st.maxsalary();
		return ls;
	}
	
	@GetMapping("min")
	public List<Integer>  minsalary(){
		List<Integer> t=st.minsalary();
		return t;
		
	}
	
	
}
