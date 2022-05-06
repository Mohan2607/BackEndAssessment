package com.te.backendassesment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class Manager {
	static Scanner sc = new Scanner(System.in);

	void viewRequests() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery("from EmployeeLeave");
			List<EmployeeLeave> list = query.getResultList();
			for (EmployeeLeave i : list) {
				System.out.println("ID : " + i.getEmployee_ID() + "    Date : " + i.getLeaveDate() + "    Status : "
						+ i.getLeaveStatus());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void statusChangeRequests() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		System.out.println("Enter the ID to change Status:");
		int id = sc.nextInt();
		EmployeeLeave leave = manager.find(EmployeeLeave.class, id);
		System.out.println("Enter Status: \n•	Press 1 for Approved\n•	Press 2 for Rejected\n");
		int sts = sc.nextInt();
		switch (sts) {
		case 1: {
			leave.setLeaveStatus("Approved");
			break;
		}
		case 2: {
			leave.setLeaveStatus("Rejected");
			break;
		}
		default: {
			leave.setLeaveStatus("Pending");
			break;
		}
		}
		transaction.begin();
		manager.persist(leave);
		transaction.commit();
		System.out.println("\nEmployee Status Updated Successfully\n");

	}

	void manager_screen(EmployeeInfo info) {
		boolean status = true;
		while (status) {
			System.out.println("Hello Manager " + info.getEmployeeName());
			System.out.println("	Press 1 to show all leave requests\n"
					+ "	Press 2 to Approve or reject leave requests\n" + "	Press 3 to go back to Main menu\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				viewRequests();
				break;
			}
			case 2: {
				statusChangeRequests();
				break;
			}
			default: {
				System.out.println("please enter a correct option");
				status = false;
				break;
			}
			}
		}

	}
}
