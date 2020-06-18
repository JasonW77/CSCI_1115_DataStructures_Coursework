/*
Assignment Author: Jason Waters
Date: 6/18/2020
Exercise: 30-03
Class: CSCI 1115
Discription: 
(Raise flags) Rewrite Listing 15.13 using a thread to animate a flag being raised.
*/

import javafx.animation.PathTransition; 
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
	private int cycleCount = 1;
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
	
		// Add an image view and add it to pane
		ImageView imageView = new ImageView("image/us.gif");
		pane.getChildren().add(imageView);

		/*
		// Create a path transition
		PathTransition pt = new PathTransition(Duration.millis(10000),
							new Line(100, 200, 100, 0), imageView); pt.setCycleCount(5);
		pt.play(); // Start animation
		*/
		new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					
						for (int c = 0; c < cycleCount; c++){
							imageView.setX(10);
							imageView.setY(200);
							for (int i = 0; i <= 200; i++){
								imageView.setY(imageView.getY() - 1);
								Thread.sleep(50);
							}
						}
					
				}catch (InterruptedException ex){}
			}
		}).start();
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}