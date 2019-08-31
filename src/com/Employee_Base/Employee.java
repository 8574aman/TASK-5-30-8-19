package com.Employee_Base;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Employee {
	int eno;
	String ename;
	int salary;
	String desg;
	String dept;

	static Scanner sc = new Scanner(System.in);

	public void addEmp() {

		System.out.println("Enter employee number");
		eno = sc.nextInt();
		System.out.println("Enter employee name");
		ename = sc.next();
		System.out.println("Enter employee salary");
		salary = sc.nextInt();
		System.out.println("Enter employee designation");
		desg = sc.next();
		System.out.println("Enter employee Dept");
		dept = sc.next();

	}

	public static void main(String args[]) {
		HashMap<Integer, Employee> hm = new HashMap<>();
		outer: while (true) {
			System.out.println(
					"1. Add employee \n 2.View employees \n 3.Remove employee \n 4. Clear Data \n 5. Change Salary fo specefic \n 6.Search employee \n 7. View department Wise employee \n 8. Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				Employee e = new Employee();
				e.addEmp();
				hm.put(e.eno, e);

				break;
			case 2:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 3:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				System.out.println("Enter Eno from above table to delete Employee");
				int del = sc.nextInt();
				hm.remove(del);
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 4:
				Set<Integer> s = hm.keySet();
				for (int i : s) {
					hm.remove(i);

				}
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 5:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				System.out.println("enter E number to update salary");
				int empno = sc.nextInt();
				System.out.println("Enter Updated salary");
				int sal = sc.nextInt();
				Employee e2 = hm.get(empno);
				e2.salary = sal;
				hm.put(empno, e2);
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}

				break;
			case 6:
				System.out.println("enter Eno to search");
				int empno1 = sc.nextInt();
			
				Employee e3 = hm.get(empno1);
				System.out.println(e3.eno + " " + e3.ename + " " + e3.salary + " " + e3.desg + " " + e3.dept);
				break;
			case 7:
				
				System.out.println("enter dept to search all employee");
				String deptSearch = sc.next();
				 for(Employee empl :hm.values()){
					 if(empl.dept.equals(deptSearch)){
						 System.out.println(empl.eno + " " + empl.ename + " " + empl.salary + " " + empl.desg + " " + empl.dept);
						 
						 
					 }
					 
				 }
				 break;
				 

			case 8:
				break outer;

			}

		}

	}

}