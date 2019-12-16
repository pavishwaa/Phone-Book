package assignment1_Vishwa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Access_Database implements db_var {

	
	private Connection con;
	private Statement st;
	
	public Access_Database() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,uname,upass);
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<PhoneBook> getAllData()
	{
		ArrayList<PhoneBook> all = new ArrayList<PhoneBook>();
		String sql = "select id, name, phone from phonebook";
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				PhoneBook pb = new PhoneBook(rs.getInt(1),
											 rs.getString(2),
											 rs.getInt(3));
				all.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}
	

	public ArrayList<PhoneBook> searchData(String val)
	{
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
		String sql =  "select id, name, phone from phonebook "
				+ " WHERE name like '%"+val+"%' ";
				System.out.println(sql);
		
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PhoneBook pb = new PhoneBook(rs.getInt(1),
						 					 rs.getString(2),
						 					 rs.getInt(3));
				list.add(pb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<PhoneBook> searchData1(String val1)
	{
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
		String sql =  "select id, name, phone from phonebook "
				+ " WHERE phone = "+val1+" ";
				System.out.println(sql);
		
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PhoneBook pb = new PhoneBook(rs.getInt(1),
						 					 rs.getString(2),
						 					 rs.getInt(3));
				list.add(pb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public boolean insertPhoneData(PhoneBook pb)
	{
		boolean success= true;
		
		String sql = "INSERT INTO phonebook (name, phone) " +
		"VALUES ('"+pb.getName()+"', "+pb.getPhone()+" ) ";
		
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			success = false;
			e.printStackTrace();
		}
		
		return success;
	}
	
	public boolean editData(int id, PhoneBook pb)
	{
		boolean success = true;
		
		String sql = "SELECT id, name, phone " +
		"from phonebook where id = " + id;
		
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.first()) {	
				rs.updateString(2, pb.getName());
				rs.updateInt(3, pb.getPhone());
				rs.updateRow();
			}
			else {
				success = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			success = false;
			e.printStackTrace();
		}	
		return success;
		
	}
	
	public boolean deleteData(int id)
	{
		boolean success = true;
		String sql = "DELETE FROM phonebook where id = " + id;
		
		try {
			int result = st.executeUpdate(sql);
			if (result == 0) 
				success = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			success = false;
			e.printStackTrace();
		}
		
		return success;
	}
	
}
