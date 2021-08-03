 package StudentPackage;
import java.util.Scanner;


import java.sql.*;
import jdbc.Database;
import utilites.Address;
	import utilites.Education;

	public class Student {

		public int rollnum;
		public String name;
		public int percentage;
		
		Education studentEducation=new Education();
		Address studentAddress=new Address();
		Database d=new Database();
		Connection conn = Database.getConnection();

	public int getRollnum() {
		return rollnum;
	}



	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public int getPercentage() {
		return percentage;
	}



	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public Education getStudentEducation() {
		return studentEducation;
	}



	public void setStudentEducation(Education studentEducation) {
		this.studentEducation = studentEducation;
	}



	public Address getStudentAddress() {
		return studentAddress;
	}



	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public void setStudentdetails()
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("enter student roll number :");
	    int rollnum=sc.nextInt();
	    System.out.println("enter Student name :");
		String name=sc1.nextLine();
		
		System.out.println("enter   percentage :");
		int percentage=sc.nextInt();
		
		 String s = " insert into Studentinfo (rollnum, name ,pecentage )"
			        + " values (?, ?, ?)";
		 PreparedStatement ps = conn.prepareStatement(s);
		 ps.setInt(1,rollnum);
			ps.setString(2,name); 
			
			ps.setFloat(3,percentage);
			
			ps.execute(); 
			System.out.println("insert records sucessfully");
			
			conn.close();
		
	}
   catch (Exception e)
{
System.err.println("Got an exception!");
System.err.println(e.getMessage());
		
	}


	}
	
	public void getStudentDetails()
	{
		System.out.println("Student Details :");  
	    System.out.println("student Education Details");
	   studentEducation.getEducation();
	    System.out.println("Student Address Details :");
	     studentAddress.getAddress();
	     try
			{	
				String s = "SELECT * " +
		                "FROM Studentinfo";

			PreparedStatement ps = conn.prepareStatement(s);
		 
		    ResultSet rs    = ps.executeQuery();
		  
		    while (rs.next()) {
		       System.out.println(rs.getString("rollnum") + "\t" + 
		                          rs.getString("name")  + "\t" +
		                          rs.getString("percentage"));
				
		         }
			}
		   
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
					}
			 
			}

	}
	


	



	




