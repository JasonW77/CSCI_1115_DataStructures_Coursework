public class Pantry {
	private String itemName;
	private int quan;
	private int row;
	private int column;
	private java.util.Date exp;
	private java.util.Date entry;
	
	/** Default constructor */
	public Pantry(){

	}
	
	/** Construct a Pantry Object with specified itemName, quan, row, column, exp, entry */
	public Pantry(String itemName, int quan, int row, int column){
		this.itemName = itemName;
		this.quan = quan;
		this.row = row;
		this.column = column;
		this.exp = exp;
		entry = new java.util.Date();
	}
	
	/** Getters */
	public String getItemName(){
		return itemName;
	}
	public int getQuantity(){
		return quan;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}
	public java.util.Date getExpiration(){
		return exp;
	}
	public java.util.Date getEnterDate(){
		return entry;
	}
	/** Setters */
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public void setQuantity(int quan){
		this.quan = quan;
	}
	public void setLocation(int row, int column){
		this.row = row;
		this.column = column;
	}
	public void setExpiration(java.util.Date exp){
		this.exp = exp;
	}
	public void setEnterDate(java.util.Date entry){
		this.entry = entry;
	}
}