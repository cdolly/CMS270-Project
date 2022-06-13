/***
 * Felon class for the blueprint to make Felon objects 
 * 
 * Purpose: defines the data members and methods to make Felon objects in order to create and manage new Felon objects 
 * Ultimately, law enforcement will have an array list of Felon objects in order to be organized and efficient in the digital age
 * 
 * Contains data members: 
 * Strings name, id, dna 
 * Character F or M representing gender
 * an ArrayList of Strings to store the list of crimes that felon has committed 
 * 
 * Contains a constructor method 
 * 
 * Contains methods:
 * all getters and setters
 * printFelon that prints out the name, ID, gender, and list of crimes of the felon 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;import java.util.ArrayList;

//create a blueprint class for Felon 
public class Felon {
	//private data members: String name, ID, DNA; Character for gender
	//and ArrayList of Strings to store the list of crimes that felon has committed
	private String name; 
	private String id; 
	private String dna; 
	private char gender;         //F or M to represent gender
	private ArrayList<String> crimes = new ArrayList<String>(); 
	
	
	//constructor method that takes 2 strings felon's name and ID
	public Felon(String name, String id) {
		this.name = name; 
		this.id = id; 
	}
	
	//printFelon methods: prints out the name, id, gender, and list of crimes of the felon
	public void printFelon() {
		System.out.print("Name:" +  this.name + " ID:" + this.id + " Gender:" + this.gender + " Crimes:"); 
		for(int i = 0; i < crimes.size(); i++) {
			System.out.print(crimes.get(i) + " "); 
		}
		System.out.println(); 
	}
	
	//GETTER METHODS: in order to access and return private data members of the Felon object
	public String getName() {
		return name; 
	}
	
	public String getId() {
		return id; 
	}
	
	public String getDna() {
		return dna; 
	}
	
	public char getGender() {
		return gender; 
	}
	
	public ArrayList<String> getCrimes(){
		return crimes; 
	}
	
	//SETTER METHODS: in order to mutate private data members of the Felon object
	public void setName(String newName) {
		this.name = newName; 
	}
	
	public void setId(String newId) {
		this.id = newId; 
	}
	
	public void setDna(String newDna) {
		this.dna = newDna; 
	}
	
	public void setGender(char newGender) {
		this.gender = newGender; 
	}
	
	public void setCrimes(String newCrimes) {
		this.crimes.add(newCrimes); 
	}
	
	
}
