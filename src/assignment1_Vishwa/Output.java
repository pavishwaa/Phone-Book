//package assignment1_Vishwa;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//	import javafx.fxml.FXML;
//	import javafx.scene.control.TextArea;
//
//	public class Output {
//
//	    @FXML
//	    private static TextArea txt_result;
//
//	    Access_Database db = new Access_Database();
//
//public static void displayData(PhoneBook pb)
//{
//	String v1 = pb.getId() + "" ;
//	String v2 =	pb.getName() + "";
//	String v3 = pb.getPhone() + "";
//	String data = txt_result.setText(v1,v2 , v3);
//}
//
//public static void dispayListOfData(ArrayList<PhoneBook> list)
//{
//	txt.setText(System.out.printf("%4s%12s%15s \n", "ID", "NAME ", "PHONE NUMBER "));
//	for(PhoneBook pb : list)
//	{
//		displayData(pb);
//	}
//}	
//
//public static PhoneBook getData()
//{
//	PhoneBook pb = null;
//	Scanner sc = new Scanner(System.in);
//	
//	System.out.println("Enter name : ");
//	String name = sc.nextLine();
//	
//	System.out.println("Enter phone number : ");
//	int number = sc.nextInt();
//	
//	pb = new PhoneBook(-1, name, number);
//	
//	return pb;
//}
//}