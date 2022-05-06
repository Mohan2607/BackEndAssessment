package com.te.backendassesment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Login {
	static Scanner sc = new Scanner(System.in);

    static void login() {
		System.out.println("Enter your Id");
		int emp_id = sc.nextInt();
		System.out.println("Enter your Password");
		String emp_password = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		try {
			EmployeeInfo info = manager.find(EmployeeInfo.class, emp_id);
			int id = info.getEmployeeId();
			String pass = info.getPassword();
			if (emp_password.equals(pass) && emp_id == id) {
				System.out.println("Successfully Logged in");
				if(info.getEmployeeType().contentEquals("manager")) {
					 Manager manage = new Manager();
					 manage.manager_screen(info);
				}
				else{
					Employee employee = new Employee();
					employee.employee_screen(info);
				}
			} else if (emp_id == id) {
				System.out.println("Wrong password");
			} else {
				System.out.println("User Record Not found");
			}
		} catch (NullPointerException e) {
			System.out.println("Invalid User\nTry to register");
		}
}

}
