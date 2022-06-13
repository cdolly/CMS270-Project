//Accounts super class- abstract 
public abstract class Account {
	//private data members
	String number; 
	String owner; 
	double balance;
	
	//**********************
	//Constructor 
	public Account(String n, String o, double b) {
		number = n; 
		owner = o;
		balance = b; 
	}
	
	
	
	//************************************
	//Getters and Setters
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	} 
	
}
