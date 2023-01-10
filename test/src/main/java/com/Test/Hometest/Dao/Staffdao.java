package com.Test.Hometest.Dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Test.Hometest.Entity.Staff;

@Repository
public class Staffdao {
	
	@Autowired
	SessionFactory sf;

	
	public List<Staff> getStaff(Staff staff) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		List<Staff> staf=criteria.list();
		session.close();
		return staf;	
	}

	public Staff staffno(Staff staff) {
		Session session=sf.openSession();
		Staff staf=session.get(Staff.class, 3);
		session.close();
		return staf;
		
	}

	public boolean staffinsert(Staff staff) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(staff);
		session.close();
		tr.commit();
		return true;
	}

	public  List<Staff> slist(Staff staff) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", 20000));
	    List<Staff> staf=criteria.list();
		session.close();
		return staf;
		
	}

	public List<Staff> expstaff(Staff staff) {
	Session session=sf.openSession();
	Criteria criteria=session.createCriteria(Staff.class);
	criteria.add(Restrictions.between("experience",10,20));
	List<Staff> staf=criteria.list();
	session.close();
	return staf;
		
	}

	public boolean updatestaf(Staff staff) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(staff);
		tr.commit();
		session.close();
		return true;
		
	}

	public List<Staff> profile() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile", "Trainer"));
		List<Staff> staf=criteria.list();	
		session.close();
		return staf;
		
	}

	public List<Staff> noprofile() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "Trainer"));
		List<Staff> staf=criteria.list();
		session.close();
		return staf;
		
	}

	public List<String> maxsalary() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.setProjection(Projections.max("salary"));
		List<Integer> list=criteria.list();
		int maxsalary=list.get(0);
		criteria=session.createCriteria(Staff.class);
		criteria.setProjection(Projections.property("name"));
		criteria.add(Restrictions.eq("salary", maxsalary));
		List<String> ls=criteria.list();			
		session.close();
		return ls;
		
		
	}

	public List<Integer> minsalary() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.setProjection(Projections.min("experience"));
		List<Integer> list=criteria.list();
		int minsalary=list.get(0);
		criteria=session.createCriteria(Staff.class);
		criteria.setProjection(Projections.property("experience"));
		criteria.add(Restrictions.eq("experience", minsalary));
		List<Integer> st=criteria.list();
		session.close();
		return st;	
	}

}
