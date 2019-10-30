package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int numEmployees = sc.nextInt();
		
		for (int i=1; i<=numEmployees; i++) {
			System.out.println("Employee #" + i + " data:");
			sc.nextLine();
			System.out.print("Outsourced (y/n)? ");
			String outsourced = sc.nextLine();
			System.out.print("Name: ");			
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			
			if (outsourced.charAt(0) == 'y') {
				System.out.print("Aditional charge: ");
				Double additionalCharge = sc.nextDouble();
				employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		
		for (Employee e : employees) {
			System.out.println(e.getName() + " - $ " + String.format("%.2f", e.payment()));
		}
		
		sc.close();
	}

}
