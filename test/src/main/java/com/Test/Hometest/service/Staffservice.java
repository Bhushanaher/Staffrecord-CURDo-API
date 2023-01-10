package com.Test.Hometest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Test.Hometest.Dao.Staffdao;
import com.Test.Hometest.Entity.Staff;

@Service
public class Staffservice {
	
	
	@Autowired
	Staffdao Sd;

	public 	List<Staff> getStaff(Staff staff) {
		List<Staff> staf=Sd.getStaff(staff);
		return staf;
		
	}

	public Staff staffno(Staff staff) {
		Staff staf=Sd.staffno(staff);
		return staf;
		
	}

	public boolean staffinsert(Staff staff) {
		Sd.staffinsert(staff);
		return true;
		
		
	}

	public List<Staff> slist(Staff staff) {
		 List<Staff> staf=	Sd.slist(staff);
		 return staf;
		
	}

	public List<Staff> expstaff(Staff staff) {
		List<Staff> staf=Sd.expstaff(staff);
		return staf;
		
	}

	public boolean updatestaf(Staff staff) {
		Sd.updatestaf(staff);
		return true;
		
	}

	public List<Staff> profile() {
		List<Staff> staf= Sd.profile();
		return staf;
		
	}

	public List<Staff> noprofile() {
		List<Staff> staf=Sd.noprofile();
		return staf;
		
	}

	public List<String> maxsalary() {
		List<String> ls=Sd.maxsalary();
		return ls;
		
	}

	public List<Integer>  minsalary() {
		List<Integer> st=Sd.minsalary();
		return st;
		
	}

	
	

	
}
