package utilites;

import java.sql.Connection;

import java.util.Scanner;
import jdbc.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Experience 
{

    public  String organisationName;
	public String designation;
	public int experience;
	Database d=new Database();
	Connection conn = Database.getConnection();
	
	
	
	public Experience(){}
	
	public Experience(String organisationName,String designation,int experience)
	{
		this.organisationName=organisationName;
		this.designation=designation;
		this.experience=experience;	
	}
	
	

	
	
	public String getOrganisationName() 
	{
		
		return organisationName;
	}
	public void setOrganisationName(String organisationName) 
	{
		this.organisationName = organisationName;
	}
	public String getDesignation() 
	{
	
		return designation;
	}
	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setExperience()
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter Experience Details :");
		System.out.println();
		System.out.println("Enter organisation Name :");
		String organisationName=sc.nextLine();			
	    System.out.println("Enter Designation :");
		String designation=sc.nextLine();
		System.out.println("Enter employee experience :");
		int experience=sc.nextInt();
			 
		String s = " insert into Experienceinfo(organisationName,designation,experience)"
		        + " values (?, ?, ?)";

	 PreparedStatement ps = conn.prepareStatement(s);
	 ps.setString(1,organisationName);
	 ps.setString(2,designation);
	 ps.setInt(3,experience);
		ps.execute(); 
		System.out.println("inserted records sucessfully");

		}
		  catch (Exception e)
			{
			  System.err.println("Got an exception!");
			  System.err.println(e.getMessage());
					
				}

			 
	}


 public void getExperience1()
 { 
	 String s = "SELECT * " +
             "FROM  Experienceinfo";
	 
	 try
		{	
			

		PreparedStatement ps = conn.prepareStatement(s);
	 
	    ResultSet rs    = ps.executeQuery();
	  
	   // loop through the result set
	   while (rs.next()) {
		   
	       System.out.println(rs.getString(1) + "\t" + 
	                          rs.getString(2)  + "\t" +
	                          rs.getString(3));
	       
	    
	       
	   }
		}
	 catch(Exception ex) {
	   System.out.println(ex.getMessage());
			}
	
     
	 
	 

}
 }
/*public String toString() {
	return "Experience [organisationName=" + organisationName + ", designation=" + designation + ", exp=" + exp + "]";
}*/

