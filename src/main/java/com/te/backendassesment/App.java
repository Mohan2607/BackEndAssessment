package com.te.backendassesment;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
		boolean status = true;
		while (status) {
			System.out.println("Employee Portal");
			System.out.println("•	Press 1 to login\n•	 Press 2 to register");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {

				Login.login();
				break;
			}
			case 2: {
				Register.register();
				break;
			}
			default: {
				System.out.println("Your choice is invalid");
				status = false;
				break;
			}
			}
		}
    }
}
