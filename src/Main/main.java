package Main;


import java.util.ArrayList;

import java.util.Collection;
import java.util.Scanner;

import Employee1package.Employee;
import StudentPackage.Student;
import jdbc.Database;


public class main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Database d=new Database();
		d.getConnection();
		
		
	
		
		Collection<Employee> c = new ArrayList<Employee>();
 		Collection<Student> s = new ArrayList<Student>();
 		
 	
 		   Scanner sc=new Scanner(System.in);
 		
 			System.out.println("University Details");
 		
 			System.out.println("......Menu......");
 			System.out.println(" 1. employee Details");
 			System.out.println("2.Student Details");
 			System.out.println("3.exit from application");
 			System.out.println(" ask user to enter above given options");
 			int choice=sc.nextInt();
 			switch(choice)
 			{
 			
 			
 			case 1:	System.out.println("enter number of Employees:");
 			  
			   int n1=sc.nextInt();
			  			  
             for (int i = 0; i < n1; i ++)
			   {
				   Employee emp = new Employee();
				   emp.setEmployeeDetails();
				  
				  emp.getEmployeeDetails();
				  c.add(emp);
			   }  
             break;
 			
 			
 			case 2:
 				
 				
 				
 				System.out.println("enter number of students:");
 				
 				int n=sc.nextInt();
				   
				  for (int i = 0; i < n; i ++)
				   {
					  Student student = new Student();      
					   student.setStudentdetails();
					  
					   student.getStudentDetails();
			          s.add(student);
				   }
				  break;
		
 				 
 	              
 			case 3: System.out.println("application closed");
 	               
 	               
 			}
	}
}
 	               
 	               
 	               
 	               
 	              
 	 
		
	