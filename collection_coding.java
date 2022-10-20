

package Toll_Collection_Coding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Collection_Coding {
	
	static Scanner sc=new Scanner(System.in);
	int total_amount;
	
	
	public void input() {
		try {
		System.out.println("WELCOME TO NAGPUR | TOLL PLAZA....YOUR TRUST OUR STRENGTH");
		Thread.sleep(1000);
		
		System.out.println("enter vehical type \n 1.4 wheeler \n 2. More than 4 wheeler heavy weight vehicals \n 3. more than 4 wheeler light weight vehical ");
		System.out.println();
		System.out.println();
		byte Vehical_type=sc.nextByte();
		
		switch(Vehical_type){
		case 1:{
			Thread.sleep(500);
			System.out.println(" your vehical type is 4 wheeler and passing thorugh lane number 1");
			System.out.println();
			try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    	//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/toll_plaza_data","root","pranju@p92");
					
			String jdbcUrl = "jdbc:mysql://localhost:3306/Toll_Plaza_data ?useSSL=false";
	        String username = "root";
	        String password = "pranju@p92";
	      //System.out.println("ENTER ID NUMBER FETCH DATA");
			//int id=25000;
	        System.out.println("enter vehical number");
	        sc.nextLine();
	        String Vehical=sc.nextLine();
			Thread.sleep(800);
			
		    String sql = ("select * from vehical_details where Vehical_number=?");
	        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

		        PreparedStatement stmt = conn.prepareStatement(sql); 
		        stmt.setString(1,Vehical);
		        //System.out.println("this statement for cheak");
		      ResultSet rs=stmt.executeQuery();
		      
				//to print the resultset on console
		      System.out.println("this statement for cheak");
				if(rs.next() && rs!=null)
				{
					
						System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4)+","+rs.getInt(5));
						
				}
				else
				{
					System.out.println("Record Not Found...");
				}
				int amount=rs.getInt(4);
				Thread.sleep(599);
				System.out.println();
		      System.out.println("This is your data and we are deducting 500rs for toll ");
		      System.out.println();
		      System.out.println();
		      
		      if(amount>500) {
		    	   total_amount=amount-500;
		    	  Thread.sleep(500);
		    	  System.out.println("Toll Deducted 500 and remaining balance is:- "+(total_amount )+"\nthank you visit again....");
		      }
		      else {
		    	  System.out.println("please recharge your balance is low");
		      }
//		      System.out.println("Enter id :");
				// total_amount;
				//sc.nextLine();
				//System.out.println("Enter name for update: ");
				//String na=sc.nextLine();
				try {
					//String vehical;
					String sql1="update vehical_details set bank_balance=? where Vehical_number=?";
					PreparedStatement ps=conn.prepareStatement(sql1);
					ps.setInt(1, total_amount);
					ps.setString(2, Vehical);
					
					ps.executeUpdate();
					System.out.println("Record updated successfully in bank_balance");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      	
		      	
		    } catch (Exception e) {
		      //e.printStackTrace();
		    }
							
			break;
		}
	
		case 2:{
			System.out.println("your vehical type is more than 4 wheeler heavy weight and passing thorugh lane number 2");
			
			
			
			break;
		}
		case 3:{
			System.out.println("your vehical type is more than 4 wheeler light weight and passing thorugh lane number 3");
			break;
		}
		default:{
			System.out.println("airoplane not acceptable here");
			break;
		}
		}
		}
		catch(Exception e)
		   {
		     System.out.println(e);
		   }
	}
	public static void main(String args[]) {
		Collection_Coding ob=new Collection_Coding();
		ob.input();
	}

}