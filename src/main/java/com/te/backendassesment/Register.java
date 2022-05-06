package com.te.backendassesment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register {
	static Scanner sc = new Scanner(System.in);

	static void register() {
		EmployeeInfo employee_Info = new EmployeeInfo();
		System.out.println("Enter your Name");
		employee_Info.setEmployeeName(sc.next());

		System.out.println("Enter Employee Type: \n•	Press 1 for Manager\n•	Press 2 for Employee\n ");
		int option = sc.nextInt();
		if (option == 1) {
			employee_Info.setEmployeeType("manager");
		} else {
			employee_Info.setEmployeeType("employee");
		}

		System.out.println("Enter your mail id");
		employee_Info.setEmail(sc.next());

		System.out.println("Enter your password");
		employee_Info.setPassword(sc.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(employee_Info);
		transaction.commit();

		System.out.println("Details Registered Successfully");
	}


}
