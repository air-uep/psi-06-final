package pl.air.hr;

import pl.air.hr.dao.DAO;

public class Application {
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		
		dao.getDepartment(20);
		dao.getDepartment(30);
		dao.getAllDepartments();

		dao.getEmployee(120);
		dao.getEmployee(108);
		
		dao.close();
	}

}
