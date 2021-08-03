package utilites;
import java.sql.Connection;
import java.util.Scanner;
import jdbc.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Address {
public String houseNo,street,locality,area,state,country;
public long pin;
//Database d=new Database();
Connection conn = Database.getConnection();
public Address(){}
	public Address(String houseno,String street,String locality,String area,String state,String country,long pin)
	{
		this.houseNo=houseno;
		this.street=street;
		this.locality=locality;
		this.area=area;
		this.state=state;
		this.country=country;
		this.pin=pin;
	}
    public String getHouseNo() {
		return houseNo;
	}
public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
   public String getStreet() {
		return street;
}
   public void setStreet(String street) {
		this.street = street;
	}

public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long  pin) {
		this.pin = pin;
	}

	public void setAddress()
    {
		try
		{
    	Scanner sc=new Scanner(System.in);
    	Scanner c=new Scanner(System.in);
    	System.out.println("enter houseno:");
    	String houseNo=sc.nextLine();
    	System.out.println("enter street:");
    	String street=sc.nextLine();
    	System.out.println("enter locality:");
    	String locality=sc.nextLine();
    	System.out.println("enter area:");
    	String area=sc.nextLine();
    	System.out.println("enter state:");
    	String state=sc.nextLine();
    	System.out.println("enter country:");
    	String country=sc.nextLine();
    	System.out.println("enter pin:");
    	Long pin=c.nextLong();
    	
		 String s = " insert into Addressinfo2(houseNo, Street, locality,area,state,country,pin )"
			        + " values (?, ?, ?, ?, ?, ?, ?)";

		 PreparedStatement ps = conn.prepareStatement(s);
		 ps.setString(1,houseNo);
			ps.setString(2,street); 
			ps.setString(3,locality);
			ps.setString(4,area);
			ps.setString(5,state);
			ps.setString(6,country);
		    ps.setLong(7,pin);
			ps.execute();  
			System.out.println("inserted records sucesfully");
			
			
			
		}
	      catch (Exception e)
	{
	  System.err.println("Got an exception!");
	  System.err.println(e.getMessage());
			
		}

        
    }



	

	
public void getAddress()
	{

	String s = "SELECT * FROM Addressinfo2";

			 try
				{	
				

				PreparedStatement ps = conn.prepareStatement(s);
			 
			    ResultSet rs    = ps.executeQuery();
			 
			   while (rs.next()) {
			       System.out.println(rs.getString("houseNo") + "\t" + 
			                          rs.getString("street")  + "\t" +
			                          rs.getString("locality")+"\t"+
			                          rs.getString("area")+"\t"+
			                          rs.getString("state")+"\t"+
			                          rs.getString("country")+"\t"+
			                          rs.getInt("pin"));
			               
			            
			   }
				}
			 catch(Exception ex) {
			   System.out.println(ex.getMessage());
					}
	
		/*System.out.println("Address Details : ");
		return "House no :"+this.houseNo+"\n"+ "Street :"+this.street+"\n"+"locality :"+this.locality+"\n"+
		"Area :"+this.area+"\n"+"State :"+"Country :"+this.country+"pin code :"+this.pin;
	*/	
	}

	
	
}


