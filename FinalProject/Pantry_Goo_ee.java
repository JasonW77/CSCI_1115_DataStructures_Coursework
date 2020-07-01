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

//import java.awt.*;

public class Pantry_Goo_ee extends Application {
	@Override //Override the start method in the Application class
	public void start(Stage primaryStage){
		//Create a scene
		Button btOk = new Button("Enter");
		Button btSea = new Button("Search");
		
		TextField itemName = new TextField();
		TextField itemQuan = new TextField();
		TextField itemExp = new TextField();
		TextField itemLoc = new TextField();
		
		VBox vb = new VBox();
		
		GridPane pane = new GridPane();
		
		Label label1 = new Label("Item Name: ");
		Label label2 = new Label("Quantity: ");
		Label label3 = new Label("Expiration: ");
		Label label4 = new Label("Location: ");
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);
		
		Scene scene = new Scene(pane, 200, 300);
		
		pane.getChildren().addAll(vb);
		vb.getChildren().addAll(label1, itemName, label2, itemQuan, label3, itemExp, label4, itemLoc,btOk,btSea);
		
		primaryStage.setTitle("Angie's Pantry");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//set on actions
		itemName.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				System.out.println("Remember to create itemName Method!");
			}
		});
		itemQuan.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				System.out.println("Remember to create itemQuan Method!");
			}
		});
		itemExp.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				System.out.println("Remember to create itemExp Method!");
			}
		});
		itemLoc.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				System.out.println("Remember to create itemLoc Method!");
			}
		});
		btOk.setOnAction(e -> {
			
				System.out.println("Remember to create btOk Method!");
			
		});
		btSea.setOnAction(e -> {
			
				System.out.println("Remember to create btSea Method!");
			
		});
	}
	public static void main(String[] args){
		Application.launch(args);
	}
}
