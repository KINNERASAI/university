package utilites;
import java.util.Scanner;

import java.sql.Connection;


import jdbc.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Education {
	public  String course;
	public  String university;
	public String place;
	public  float marks;
	public String yop;
	Database d=new Database();
	Connection conn = Database.getConnection();
	
public Education(){}
	
	public Education(String course,String university,String place,float marks,String yop)
	{
		this.course=course;
		this.university=university;
		this.place=place;
		this.marks=marks;	
		this.yop=yop;
	}
	
	
	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public float getMarks() {
		return marks;
	}


	public void setMarks(float marks) {
		this.marks = marks;
	}


	public String getYop() {
		return yop;
	}


	public void setYop(String yop) {
		this.yop = yop;
	}


	public void setEducationDetails()
	{
		
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter course:");
	    String course=	sc.nextLine();
		System.out.println("enter university:");
	    String university=sc.nextLine();
		System.out.println("enter place:");
		String place=sc.nextLine();
		System.out.println("enter marks:");
		Float marks=sc.nextFloat();
		System.out.println("enter year of passing:");
	    String yop=sc.nextLine();

		 String s = " insert into Educationinfo (course, university, place ,marks,yop )"
			        + " values (?, ?, ?, ?, ?)";
		 PreparedStatement ps = conn.prepareStatement(s);
		 ps.setString(1,course);
			ps.setString(2,university); 
			ps.setString(3,place);
			ps.setFloat(4,marks);
			ps.setString(5,yop);
			ps.execute();  
			System.out.println("inserted records sucesfully");
			
			conn.close();
		
	}
      catch (Exception e)
{
  System.err.println("Got an exception!");
  System.err.println(e.getMessage());
		
	}


		 
	}

public void getEducation()
	{
		
		System.out.println("Education Details :");
		
		
		
		 try
			{	
				String s = "SELECT * " +
		                "FROM Educationinfo";

			PreparedStatement ps = conn.prepareStatement(s);
		 
		    ResultSet rs    = ps.executeQuery();
		  
		   // loop through the result set
		   while (rs.next()) {
		       System.out.println(rs.getString("course") + "\t" + 
		                          rs.getString("university")  + "\t" +
		                          rs.getString(" place")+"\t"+
		                          rs.getString("marks")+"\t"+
		                          rs.getString("yop"));
		                       
		           
		   }
			}
		 catch(Exception ex) {
		   System.out.println(ex.getMessage());
				}
		
		  
	}
	
	/*public String toString() {
		return "Education [course=" + course + ", university=" + university + ", place=" + place + ", marks=" + marks
				+ ", yop=" + yop + "]";
	}*/


}	



