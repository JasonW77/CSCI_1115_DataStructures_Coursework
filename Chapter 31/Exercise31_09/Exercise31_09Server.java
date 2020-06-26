import javafx.application.Application;
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
import java.rmi.server.*;

public class Exercise31_09Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  //IO streams
  private DataOutputStream outputToClient = null;
  private DataInputStream inputFromClient = null;
  //Sockets
  private ServerSocket serverSocket;
  private Socket socket;
  
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
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // To complete later
     taClient.setOnKeyPressed(e -> {
        if (e.getCode() == KeyCode.ENTER){
          taServer.appendText("\n" + taClient.getText().trim());
          
          try {
            outputToClient.writeUTF(taClient.getText());
          } catch (IOException ex) {
              ex.printStackTrace();
          }
          taClient.setText("");
        }
      });
      
    new Thread(() -> {
            try{
              //create server socket
              serverSocket = new ServerSocket(8000);
   
              //listen for connection request
              Socket socket = serverSocket.accept();
              
              inputFromClient = new DataInputStream(socket.getInputStream());
              outputToClient = new DataOutputStream(socket.getOutputStream());
 
              
              while (true){
                  //receive messages
                  String messFromClient = inputFromClient.readUTF();
                  System.out.println("New message from client!");
                  taServer.appendText("\n" + messFromClient.trim());

              }  
            }
            catch (IOException ex) {
              ex.printStackTrace();
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
