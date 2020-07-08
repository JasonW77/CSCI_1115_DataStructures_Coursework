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

import java.text.*;

public class Pantry{
	SimpleDateFormat eDate = new SimpleDateFormat("dd/mm/yy");
	private String iN;
	private int iQ;
	private int iRL;
	private int iCL;
	private java.util.Date iE;
	private java.util.Date entryDate;
	
	/**
	 * //default Object creation settings
	 */
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
	
	/**
	 * //Construct a Pantry Object with specified iN, iQ, iRL, iCL, iE, entryDate 
	 * @param iN Item Name
	 * @param iQ Item Quantity
	 * @param iE Item Expiration Date
	 * @param iRL Item row location
	 * @param iCL Item column location
	 * entryDate item entry date
	*/
	public Pantry(String iN, int iQ, java.util.Date iE, int iRL, int iCL){
		this.iN = iN;
		this.iQ = iQ;
		this.iE = iE;
		this.iRL = iRL;
		this.iCL = iCL;
		entryDate = new java.util.Date();
	}
	
	/** Getter for item name
	 * @return iN Item Name
	 */
	public String getIn(){
		return iN;
	}
	/** Getter for item quantity
	 * @return iQ Item quantity
	 */
	public int getQuantity(){
		return iQ;
	}
	/** Getter for row location
	 * @return iRL Item row location
	 */
	public int getRow(){
		return iRL;
	}
	/** Getter for item column location
	 * @return iCL Item column location
	 */
	public int getColumn(){
		return iCL;
	}
	/** Getter for item expiration date
	 * @return iE Item expiration date
	 */
	public java.util.Date getExpiration(){
		return iE;
	}
	/** Getter for item entry date
	 * @return entryDate Item entry date
	 */
	public java.util.Date getEnterDate(){
		return entryDate;
	}
	/** Setter for setting item name
	 * @param iN item name
	*/
	public void setItemName(String iN){
		this.iN = iN;
	}
	/** Setter for setting item quantity
	 * @param iQ item quantity
	*/
	public void setQuantity(int iQ){
		this.iQ = iQ;
	}
	/** Setter for setting item location 
	 * @param iRL item row location
	 * @param iCL item column location
	*/
	public void setLocation(int iRL, int iCL){
		this.iRL = iRL;
		this.iCL = iCL;
	}
	/** Setter for setting item expiration date
	 * @param iE item expiration date
	*/
	public void setExpiration(java.util.Date iE){
		this.iE = iE;
	}
	/** Setter for setting item entry date
	 * @param entryDate item entry date
	*/
	public void setEnterDate(java.util.Date entryDate){
		this.entryDate = entryDate;
	}
	/** to string method
	 * @return Object information inside the console
	*/
	public String myToString(){
		return "Pantry: \n" + " Item Name: " + iN + "\n Item Quantitiy: " + iQ + "\n Item Row Location: " + iRL + "\n Item Column Location: " + iCL + "\n Item Expiration Date: " + iE + "\n Item Entry Date: " + entryDate;
	}
}