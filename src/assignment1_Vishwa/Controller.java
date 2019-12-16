package assignment1_Vishwa;

	
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
	
	
	public class Controller {
		Access_Database db = new Access_Database();
	
		
	    @FXML
	    private Button btn_show;

	    @FXML
	    private TextField serch_name;

	    @FXML
	    private TextField search_num;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private Button btn_exit;

	    @FXML
	    private Button btn_search_name;

	    @FXML
	    private Button btn_add;

	    @FXML
	    private Button btn_delete;
	    
	    @FXML
	    private Button btn_search_num;

	    @FXML
	    private Button btn_edit_go;

	    @FXML
	    private  TextArea display;
	    
	    @FXML
	    private TextField id_delete;


	    @FXML
	    void add(ActionEvent event) {
	    	PhoneBook pb = getData();
			db.insertPhoneData(pb);
	   }

	    @FXML
	    void edit(ActionEvent event) {
	    	int id = Integer.parseInt(txt_id.getText());
			PhoneBook pb = getData();
			db.editData(id, pb);						
			txt_id.clear();
	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	System.exit(0);

	    }

	    @FXML
	    void search1(ActionEvent event) {
	    	String val ;
	    	val = serch_name.getText();
	    	try {
			ArrayList<PhoneBook> dataFound = db.searchData(val);
			dispayListOfData(dataFound);
			}catch (Exception e) {
				display.appendText("No data found!");
			}
	    	
			serch_name.clear();
	    }
	    
	    
	    @FXML
	    void search2(ActionEvent event) {
	    	String val1 ;
	    	val1 = search_num.getText();
	    	ArrayList<PhoneBook> dataFound = db.searchData1(val1);
	    	dispayListOfData(dataFound);
	    	search_num.clear();
	    }


	    @FXML
	    void showTable(ActionEvent event) {
	    	if(event.getSource() == btn_show) {
	     	ArrayList<PhoneBook> all = db.getAllData();
	     	dispayListOfData(all);

	     	}
	   	}
	    
	    @FXML
	    void delete(ActionEvent event) {
	    	int id_del = Integer.parseInt(id_delete.getText());
	    	
	    	if(db.deleteData(id_del))
	    		JOptionPane.showMessageDialog(null, "Removed!");
				//System.out.println("Removed!!!");
			else
				JOptionPane.showMessageDialog(null, "Data not found, id is wrong!");
				//System.out.println("error, product not found!, id is wrong.");
	    	id_delete.clear();

	    }

	    


	public void displayData(PhoneBook pb)
	{
		
		//System.out.printf("%4d%15s%13d \n", pb.getId(), pb.getName(), pb.getPhone());
		
		display.appendText(""+ pb.getId() + " \t\t " + pb.getName() + " \t\t " + pb.getPhone() + "\n");
	}
	
	public  void dispayListOfData(ArrayList<PhoneBook> list)
	{
		display.appendText("ID \t\t NAME \t\t PHONE NUMBER \n");
		//System.out.printf("%4s%12s%15s \n", "ID", "NAME ", "PHONE NUMBER ");
		
		for(PhoneBook pb : list)
		{
			displayData(pb);
			
		}
	}	

	public PhoneBook getData()
	{
		PhoneBook pb = null;
		int number = 0;
		String name = "";
		
//	System.out.println("Enter name : ");
//		String name = sc.nextLine();
		try {
		name = JOptionPane.showInputDialog("Enter name:");
		
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
//	System.out.println("Enter phone number : ");
//	int number = sc.nextInt();
		try {
			
		number = Integer.parseInt(JOptionPane.showInputDialog("Enter number:"));
		int length = String.valueOf(number).length();
        if(length != 10) {
        	  Alert alert = new Alert(Alert.AlertType.ERROR, "Please Enter 10 digit number" );
              alert.showAndWait();

        }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "please, Enter number!");
		}
		
	//String name = serch_name.getText();
		//int num = Integer.parseInt( serch_name.getText());
		
	pb = new PhoneBook(-1, name, number);
		
		return pb;
	}
	
}