package com.Employee_Base;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Employee implements Comparable<Employee> {
	int eno;
	String ename;
	int salary;
	String desg;
	String dept;
	static int sortfield = 1;
	static int sortorder = 1;

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

	// Arrays.sort()

	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub

		if (sortfield == 1) {
			if (sortorder == 2) {
				sortorder = -1;
			}
			return sortorder * ename.compareTo(emp.ename);
		}
		if (sortfield == 2) {
			if (sortorder == 2) {
				sortorder = -1;
			}
			return sortorder * (salary - emp.salary);

		}

		return 0;
	}

	public static void main(String args[]) {
		HashMap<Integer, Employee> hm = new HashMap<>();
		outer: while (true) {
			System.out
					.println("1. Add employee \n 2.View employees \n 3.Remove employee \n 4. Clear Data \n 5. Change Salary fo specefic \n 6.Search employee \n 7. View department Wise employee \n 8. View Sorted Emp 9.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				Employee e = new Employee();
				e.addEmp();
				hm.put(e.eno, e);

				break;
			case 2:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " "
							+ e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 3:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " "
							+ e1.salary + " " + e1.desg + " " + e1.dept);

				}
				System.out
						.println("Enter Eno from above table to delete Employee");
				int del = sc.nextInt();
				hm.remove(del);
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " "
							+ e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 4:
				Set<Integer> s = hm.keySet();
				for (int i : s) {
					hm.remove(i);

				}
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " "
							+ e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 5:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " "
							+ e1.salary + " " + e1.desg + " " + e1.dept);

				}
				System.out.println("enter E number to update salary");
				int empno = sc.nextInt();
				System.out.println("Enter Updated salary");
				int sal = sc.nextInt();
				Employee e2 = hm.get(empno);
				e2.salary = sal;
				hm.put(empno, e2);
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " "
							+ e1.salary + " " + e1.desg + " " + e1.dept);

				}

				break;
			case 6:
				System.out.println("enter Eno to search");
				int empno1 = sc.nextInt();

				Employee e3 = hm.get(empno1);
				System.out.println(e3.eno + " " + e3.ename + " " + e3.salary
						+ " " + e3.desg + " " + e3.dept);
				break;
			case 7:

				System.out.println("enter dept to search all employee");
				String deptSearch = sc.next();
				for (Employee empl : hm.values()) {
					if (empl.dept.equals(deptSearch)) {
						System.out.println(empl.eno + " " + empl.ename + " "
								+ empl.salary + " " + empl.desg + " "
								+ empl.dept);

					}

				}
				break;

			case 8:
				System.out
						.println("Sort on Basis of \n 1.Employee Name \n 2.Employee Salary");
				Employee.sortfield = sc.nextInt();
				System.out
						.println("Select a Sorting Order \n 1.asceding \n 2. descending");
				Employee.sortorder = sc.nextInt();
				hm = sortByValue(hm);
				// HashMap cannot be sorted directly therefore copied items to
				// list and used comparator.

				break;
			case 9:
				break outer;

			}

		}

	}

	public static HashMap<Integer, Employee> sortByValue(
			HashMap<Integer, Employee> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Employee>> list = new LinkedList<Map.Entry<Integer, Employee>>(
				hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Employee>>() {
			public int compare(Map.Entry<Integer, Employee> o1,
					Map.Entry<Integer, Employee> o2) {
				return (o1.getValue()).compareTo(o2.getValue()); // compare to
																	// method
																	// implemented
			}
		});

		// put data from sorted list to hashmap
		HashMap<Integer, Employee> temp = new LinkedHashMap<Integer, Employee>();
		for (Map.Entry<Integer, Employee> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

}