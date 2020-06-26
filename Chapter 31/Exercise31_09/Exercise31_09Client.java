import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import java.io.*;
import java.net.*;

public class Exercise31_09Client extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
 
  
  //IO streams
  DataOutputStream outputToServer = null;
  DataInputStream inputFromServer = null;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    taServer.setEditable(false);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // To complete later
    taClient.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER){ 
        taServer.appendText("\n" + taClient.getText().trim());
       
        try {
          outputToServer.writeUTF(taClient.getText());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         taClient.setText("");
      }
    });
    
    new Thread(() -> {
        try{
          //create new socket
          Socket socket = new Socket("Localhost" , 8000);
          String mess = taClient.getText().trim();     
          
          inputFromServer = new DataInputStream(socket.getInputStream());
          outputToServer = new DataOutputStream(socket.getOutputStream());   
    
          //send message to server
          //outputToServer.writeUTF(mess);

          System.out.println("Message Sent");
          taClient.setText("");
          
          while (true) {
            //receive messages
            String messFromServer = inputFromServer.readUTF();
            System.out.println("New message from server!");
            taServer.appendText("\n" + messFromServer.trim());
          }
      }catch (IOException ex) {
        System.out.println(ex);
    }
    }).start();    
  }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
