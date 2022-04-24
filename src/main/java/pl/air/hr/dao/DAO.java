package pl.air.hr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.service.PrintService;

public class DAO {
	
	Session session;
	private SessionFactory sessionFactory;
	
	public DAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	public void close() {
		session.close();
		sessionFactory.close();
	}
	
	// Department
	public void getDepartment(Integer id) {
		Transaction tx = session.beginTransaction();
		Department dep = session.get(Department.class, id);

		String depPrint = PrintService.print(dep);
		System.out.println(depPrint);

		tx.commit();
	}
	
	public void getAllDepartments() {
		Transaction tx = session.beginTransaction();
		
		Query<Department> query = session.createQuery("from Department", Department.class);
		List<Department> all = query.getResultList();

		System.out.println("Lista działów");
		System.out.println("-------------");
		for (Department dep : all) {
			String depPrint = PrintService.print(dep);
			System.out.println(" - " + depPrint);
		}
		System.out.println();
		
		tx.commit();
	}
	
	public Integer createDepartment(String name, String location) {
		Transaction tx = session.beginTransaction();
		
		Department one = new Department();
		one.setName(name);
		one.setLocation(location);
		
		session.persist(one);

		tx.commit();

		Integer id = one.getId();
		return id;
	}
	
	
	// Employee
	public void getEmployee(Integer id) {
		Transaction tx = session.beginTransaction();
		
		Employee emp = session.get(Employee.class, id);
		Department dep = emp.getDepartment();

		String empPrint = PrintService.print(emp);
		String depPrint = PrintService.print(dep);

		System.out.println(empPrint);
		System.out.println(" - dział: " + depPrint);
		System.out.println();

		tx.commit();		
	}

}
