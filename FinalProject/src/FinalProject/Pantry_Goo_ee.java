/**
 * <h1>JavaDoc</h1>
 * 
 *  This is my Pantry application interface class (or Pantry_Goo_ee.java).
 * 	I created this program for the CSCI_1115_DataStructures_Final_Project
 * 	 
 * 
	<p>Date created 7/7/2020 <p/>
	
	@author Jason Waters
 */
package FinalProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import java.text.*;
import java.util.*;




public class Pantry_Goo_ee extends Application {
	
	@Override //Override the start method in the Application class
	public void start(Stage primaryStage){
		
		Map<String,Object> map = new HashMap<>();

		Button btFinish = new Button("Finish");
		Button btNewItem = new Button("Enter New Item");
		Button btItemSearch = new Button("Item Search");
		Button btClearEntry = new Button("Clear Entry");
		
		TextField itemName = new TextField();
		TextField itemQuan = new TextField();
		TextField itemExp = new TextField();
		TextField itemRLoc = new TextField();
		TextField itemCLoc = new TextField();
		
		VBox vb = new VBox();
		
		GridPane pane = new GridPane();
		
		Label label1 = new Label("Item Name: ");
		Label label2 = new Label("Quantity: ");
		Label label3 = new Label("Expiration: ");
		Label label4 = new Label("Row Location: ");
		Label label5 = new Label("Column Location: ");
		
		btFinish.setVisible(false);
		btNewItem.setVisible(true);
		btItemSearch.setVisible(true);
		btClearEntry.setVisible(false);
		
		itemName.setVisible(false);
		itemQuan.setVisible(false);
		itemExp.setVisible(false);
		itemRLoc.setVisible(false);
		itemCLoc.setVisible(false);
		
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		

		//Create a scene and a pane, then place them in the stage		
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);
		
		Scene scene = new Scene(pane, 300, 350);
		
		pane.getChildren().addAll(vb);
		vb.getChildren().addAll(label1, itemName, label2, itemQuan, label3, itemExp, label4, itemRLoc,label5, itemCLoc,btFinish,btNewItem,btItemSearch,btClearEntry);
		
		primaryStage.setTitle("Angie's Pantry");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//set on actions for buttons
		itemName.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				if (itemQuan.isVisible() != true){
				String seaItem;
				seaItem = itemName.getText().trim();
				System.out.println("Search Item Detected: " + seaItem);
				System.out.println(map.get(seaItem));
				}
			}
		});
		
		btFinish.setOnAction(e -> {
			//Enter new item constructor Constructor here
			SimpleDateFormat eDate = new SimpleDateFormat("dd/mm/yy");
			String iN = itemName.getText().trim();
			int iQ = Integer.parseInt(itemQuan.getText().trim());
			java.util.Date iE = new java.util.Date();
			try {
				iE = eDate.parse(itemExp.getText().trim());
			} catch (ParseException parseEx) {
				parseEx.printStackTrace();
				
			}
			
			int iRL = Integer.parseInt(itemRLoc.getText().trim());
			int iCL = Integer.parseInt(itemCLoc.getText().trim());
			
			Pantry pan = new Pantry(iN, iQ, iE, iRL, iCL);
			map.put(pan.getiN(), pan);

			System.out.println(pan.toString() + "\n");
			System.out.println(map + "/n");
			
		});
		
		btNewItem.setOnAction(e -> {
			
			itemName.setVisible(true);
			itemQuan.setVisible(true);
			itemExp.setVisible(true);
			itemRLoc.setVisible(true);
			itemCLoc.setVisible(true);
			
			label1.setVisible(true);
			label2.setVisible(true);
			label3.setVisible(true);
			label4.setVisible(true);
			label5.setVisible(true);
			
			btFinish.setVisible(true);
			btNewItem.setVisible(false);
			btItemSearch.setVisible(false);
			btClearEntry.setVisible(true);
		
		});
		
		btItemSearch.setOnAction(e -> {
			btFinish.setVisible(false);
			btNewItem.setVisible(false);
			btItemSearch.setVisible(false);
			btClearEntry.setVisible(true);
			
			itemName.setVisible(true);
			itemQuan.setVisible(false);
			itemExp.setVisible(false);
			itemRLoc.setVisible(false);
			itemCLoc.setVisible(false);
			
			label1.setVisible(true);
			label2.setVisible(false);
			label3.setVisible(false);
			label4.setVisible(false);
			label5.setVisible(false);
			
		});
		
		btClearEntry.setOnAction(e -> {
			
			btFinish.setVisible(false);
			btNewItem.setVisible(true);
			btItemSearch.setVisible(true);
			btClearEntry.setVisible(false);
			
			itemName.setVisible(false);
			itemName.setText(" ");
			itemQuan.setVisible(false);
			itemQuan.setText(" ");
			itemExp.setVisible(false);
			itemExp.setText(" ");
			itemRLoc.setVisible(false);
			itemRLoc.setText(" ");
			itemCLoc.setVisible(false);
			itemCLoc.setText(" ");
			
			label1.setVisible(false);
			label2.setVisible(false);
			label3.setVisible(false);
			label4.setVisible(false);
			label5.setVisible(false);
				
		});
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}