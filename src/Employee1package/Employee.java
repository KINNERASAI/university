package Employee1package;
import utilites.Address;



import utilites.Experience;
import utilites.Education;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.Database;
	public class Employee {
		public int id;
		public String name;
		public double salary;
		public String department;
		public String joiningYear;
		public String dob;		
		//Database d=new Database();
		Connection conn = Database.getConnection();
		Address empAddress=new Address();
		
	    Experience empExperience=new Experience();
		Education empEducation=new Education();
		private PreparedStatement ps;
		
	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getJoiningYear() {
			return joiningYear;
		}
		public void setJoiningYear(String JoiningYear) {
			this.joiningYear = JoiningYear;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		
		public Address getEmpAddress() {
			return empAddress;
		}
		public void setEmpAddress(Address empAddress) {
			this.empAddress = empAddress;
		}
		public Experience getEmpExperience() {
			return empExperience;
		}
		public void setEmpExperience(Experience empExperience) {
			this.empExperience = empExperience;
		}
		public Education getEmpEducation() {
			return empEducation;
		}
		public void setEmpEducation(Education empEducation) {
			this.empEducation = empEducation;
		}

	
		
public void setEmployeeDetails()
	{

try
		{
	Scanner sc=new Scanner(System.in);
	 Scanner sc1=new Scanner(System.in);
	System.out.println("Enter employee id :");
	 int id=sc.nextInt();
	 System.out.println("Enter Employee Name :");    
	 String name=sc1.next();
	 System.out.println("Enter salary :");
	 double salary=sc.nextDouble();
	 System.out.println("Enter department :");	
	 String department=sc1.next();
	 System.out.println("enter joining year :");
	 String joiningYear=sc.next();
	 System.out.println("enter date of birth :");
	 String dob=sc1.next();
	  System.out.println("Enter Employee Address details :");
	  empAddress.setAddress();
	  System.out.println("enter Employee Experience details");
	  empExperience.setExperience();
 String s = " insert into Employeeinfo (id, name, salary,department,joiningYear,dob )"
		        + " values (?, ?, ?, ?, ?, ?)";

	 PreparedStatement ps = conn.prepareStatement(s);
	 ps.setInt(1,id);
		ps.setString(2,name); 
		ps.setDouble(3,salary);
		ps.setString(4,department);
		ps.setString(5,joiningYear);
		ps.setString(6,dob);
	  
		ps.execute();  
		System.out.println("inserted records sucesfully");
	
		
	}
catch (Exception e)
{
  System.err.println("Got an exception!");
  System.err.println(e.getMessage());
		
	}

	}
	
	
public void getEmployeeDetails() 
	 { 
		 


		 System.out.println("Employee Address Details :");
	     empAddress.getAddress();
	    
		 System.out.println("Employee Experience details:");
		  empExperience.getExperience1();

			String s = "SELECT * " +
	                "FROM Employeeinfo";
		
		 try
			{	

			PreparedStatement ps = conn.prepareStatement(s);
		 
		    ResultSet rs    = ps.executeQuery();
		  
		   // loop through the result set
		    
		   while (rs.next()) {
		       System.out.println(rs.getString("id") + "\t" + 
		                          rs.getString("name")  + "\t" +
		                          rs.getString("salary")+"\t"+
		                          rs.getString("department")+"\t"+ rs.getString(joiningYear)+"\t"+rs.getString(dob));
		 
		   	
		   	
		   	
		    
		   
		           
		   }
			}
			
		 catch(Exception ex) {
		   System.out.println(ex.getMessage());
				}
	
		 
	
 
	 }

}