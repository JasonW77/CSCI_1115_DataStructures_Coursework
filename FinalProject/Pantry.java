package FinalProject;

import java.util.Date;
import java.text.*;
import java.io.*;
import java.util.*;

public class Pantry{
	SimpleDateFormat eDate = new SimpleDateFormat("dd/mm/yy");
	private String iN;
	private int iQ;
	private int iRL;
	private int iCL;
	private java.util.Date iE;
	private java.util.Date entryDate;
	
	//Default constructor 
	public Pantry(){
		this.iN = "Null";
		this.iQ = 0;
		try {
			this.iE = eDate.parse("01/01/01");
		} catch (ParseException parseEx) {
			parseEx.printStackTrace();
		}
		
		this.iRL = 0;
		this.iCL = 0;

		entryDate = new java.util.Date();
	}
	
	/** Construct a Pantry Object with specified iN, iQ, iRL, iCL, iE, entryDate */
	public Pantry(String iN, int iQ, java.util.Date iE, int iRL, int iCL){
		this.iN = iN;
		this.iQ = iQ;
		this.iE = iE;
		this.iRL = iRL;
		this.iCL = iCL;
		entryDate = new java.util.Date();
	}
	
	/** Getters */
	public String getiN(){
		return iN;
	}
	public int getQuantity(){
		return iQ;
	}
	public int getRow(){
		return iRL;
	}
	public int getColumn(){
		return iCL;
	}
	public java.util.Date getExpiration(){
		return iE;
	}
	public java.util.Date getEnterDate(){
		return entryDate;
	}
	/** Setters */
	public void setItemName(String iN){
		this.iN = iN;
	}
	public void setQuantity(int iQ){
		this.iQ = iQ;
	}
	public void setLocation(int iRL, int iCL){
		this.iRL = iRL;
		this.iCL = iCL;
	}
	public void setExpiration(java.util.Date iE){
		this.iE = iE;
	}
	public void setEnterDate(java.util.Date entryDate){
		this.entryDate = entryDate;
	}
	public String toString(){
		return "Pantry: \n" + " Item Name: " + iN + "\n Item Quantitiy: " + iQ + "\n Item Row Location: " + iRL + "\n Item Column Location: " + iCL + "\n Item Expiration Date: " + iE + "\n Item Entry Date: " + entryDate;
	}
}