/*
Assignment Author: Jason Waters
Date: 6/23/2020
Exercise: 31-01
Class: CSCI 1115
Discription: 
(Loan server) Write a server for a client. The client sends loan information (annual interest rate, number of years, and loan amount) to the server. The server creates a Loan object to compute monthly payment and total payment, and sends those numbers back to the client.
*/

// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;import java.net.*;
import javax.xml.crypto.*;
import java.io.*;
import java.sql.*;
import java.util.Date;


public class Exercise31_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    new Thread(() -> {
        try{
          //create server socket
          ServerSocket serverSocket = new ServerSocket(8000);
          Platform.runLater(() -> 
            ta.appendText("Exercise31_01Server started at " + new Date() + '\n'));
            
          //listen for connection request
          Socket socket = serverSocket.accept();
          
          //create data streams
          DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
          DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
          
          
          
          while (true){
            Date dateClientConnected = new Date();
            //recieve information from client
            double annualIntrestRate = inputFromClient.readDouble();
            int numberOfYears = inputFromClient.readInt();
            double loanAmount = inputFromClient.readDouble();
            
            Loan loan = new Loan(annualIntrestRate, numberOfYears, loanAmount);
            
            //compute payments
            double monthlyIntrestRate = loan.getAnnualInterestRate();
            double monthlyPayment = loan.getMonthlyPayment();
            double totalPayment = loan.getTotalPayment();
            
            //send payment data back to client
            outputToClient.writeDouble(monthlyPayment);
            outputToClient.writeDouble(totalPayment);
          
            
            Platform.runLater(() -> {
              ta.appendText("Connected to a client at " + dateClientConnected + '\n');
              ta.appendText("Annual Interest Rate: " + annualIntrestRate + '\n');
              ta.appendText("Number of Years: " + numberOfYears + '\n');
              ta.appendText("Loan Amount: " + loanAmount + '\n');
              ta.appendText("Monthly Payment: " + monthlyPayment + '\n');
              ta.appendText("Total Payment: " + totalPayment + '\n');
            });
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
