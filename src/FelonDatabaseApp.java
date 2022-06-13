/***
 * @Cristalle Choi and @Cameron Dolly 
 * CMS 270 Assignment 1 Java Review - Catch That Felon! 
 * October 15, 2020 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FelonDatabaseApp {
	public static String l;
	public static Scanner input; 
	private static ArrayList<Felon> felons = new ArrayList<Felon>(); //arraylist of the felons 
	
	//printDatabase
	//prints out name, id, gender, and list of crimes for each felon in the database
	public static void printDatabase() {
		for(int i = 0; i < felons.size(); i++) {
			felons.get(i).printFelon(); 
		}
	}
	
	//findByDna
	//takes a string representing a DNA profile and returns the felon objects whose DNA matches
	public static Felon findByDNA(String dna) {
		for(int i = 0; i < felons.size(); i++) {
			if(felons.get(i).getDna().equals(dna) == true) {   //if the DNA matches a felon's DNA, then return felon's data 
				return felons.get(i); 
			}
		}
		return null;
	}
	
	//genereateLineup
	//takes a string and a character representing type of crimes and gender
	//print out felons of the required gender who have also committed that type of crime
	public static Felon generateLineup(String crime, char gender) {
		for(int i = 0; i < felons.size(); i++) {
			if(felons.get(i).getGender() == gender) {
				for(int j = 0; j < felons.get(i).getCrimes().size(); j++) {
					if(felons.get(i).getCrimes().get(j).equals(crime)) {
						return felons.get(i); 
					}
				}
			}
		}
		return null;
	}
	

	//populateDatabase
	//Store the felon data in the database by creating new Felon objects and putting them in the felons arraylist
	public static void populateDatabase(int nEntries) {
		for(int i = 0; i < nEntries; i++) {
			l = input.nextLine();
			String[] a = l.split(" "); //splits on the blank space

			String name = a[0];
			String identificationNum = a[1];
			char gender = a[2].charAt(0);
            String DNAnum = a[3]; 
            felons.add(i, new Felon(name, identificationNum));
            felons.get(i).setDna(DNAnum); 
            felons.get(i).setGender(gender); 
            
            //add to the arraylist of crimes 
            for(int j = 4; j < a.length; j++ ) {        	
            	String crime = a[j];   
            	felons.get(i).setCrimes(crime);
            }
		}
	}
	
	//MAIN METHOD- driver method 
	public static void main(String[] args) {

		//reads data from file felon.txt and stores data in felon database
	    try {
	    	File f = new File("felon.txt");
	    	input = new Scanner(f); 

	    	l = input.nextLine();
			int numFelons = Integer.parseInt(l);
	    	populateDatabase(numFelons);
	    	
	    	System.out.println("The Boonies Felons Database"); 
	        //processes list of database requests
	        int r = input.nextInt();   //numbers of database requests to follow
	        
	        for(int i = 0; i < r; i++) {
	        	String request = input.next(); 
	        	
	        	//P to print the database 
				if(request.equals("P")) {
	        		System.out.println("Felonies in the Database");
	        		System.out.println("-------------------------"); 
	        		printDatabase(); 
	        		System.out.println("--------------------------");
	        	}
	        	
	        	//F to find a suspect 
	        	//followed by a string representing the DNA- find the suspect and then print out the data for that suspect
				if(request.equals("F")) {
	        		String dna = input.next(); 
	        		if(!(findByDNA(dna) == null)) {
	        			System.out.println("A match has been found for DNA: " + dna);
		        		findByDNA(dna).printFelon(); 
	        		}
	        		else{
	        			System.out.println("No matches have been found for: " + dna); 
	        		}
	        	}

	        	//L to generate a lineup- followed by a string followed by a character
	        	if(request.equals("L")) {
	        		String crime = input.next(); 
	        		char gender = input.next().charAt(0); 
	        		if(!(generateLineup(crime, gender) == null)) {
	        			System.out.println("Lineup of " + gender + " " + crime + " suspects.");
	        			System.out.println("-------------------------"); 
		        		generateLineup(crime, gender).printFelon();
		        		System.out.println("-------------------------"); 
	        		}
	        		else{
	        			System.out.println("No matches have been found for " + crime + " suspects."); 
	        		}

	        	} 
	        	System.out.println(); 
	        	System.out.println(); 
	          }
	        input.close(); //close the Scanner 
	     }
	    
	    //if it fails, then the catch block will handle errors
	    catch (FileNotFoundException e) {
	        System.out.println("Error");
	        e.printStackTrace();  //will tell you what went wrong 
	    }

	}
	
}
