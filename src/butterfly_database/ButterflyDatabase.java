/**
 * ButterflyDatavase.java
 * @author Ethan Ly
 * @author Chandan Reddy
 * CIS 36B, Lab 5.1
 */

package butterfly_database;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ButterflyDatabase {
    public static void main(String[] args) throws IOException{
        ArrayList<Butterfly> butterflies = new ArrayList<Butterfly>();
        File file = new File("butterflies.txt");
        Scanner input = new Scanner(file);
        String species, family, color, choice = "";
        //read in data from the file here
		int i = 1;
		while (input.hasNext()) {
			family = input.nextLine().toUpperCase();
			species = input.nextLine();
			color = input.nextLine();
			Butterfly b = new Butterfly(family, species, color);
			int speciesNumber = Butterfly.generateSpeciesNumber();
			b.setSpeciesNumber(speciesNumber);
			butterflies.add(b);
		}
        input.close();
        input = new Scanner(System.in);
        System.out.println("Welcome to the Butterfly Database!\n");
        while (!choice.equalsIgnoreCase("q")) {
            System.out.println("Menu:");
            System.out.println("A. Add a butterfly");
            System.out.println("R. Remove a butterfly");
            System.out.println("V. View butterfly family members");
            System.out.println("Q. Quit");
            System.out.print("\nEnter your choice: ");
            choice = input.nextLine();
            if(choice.equalsIgnoreCase("A")) {
                System.out.println("\nSelect from one of our accepted families of butterfly: ");
                System.out.println("\tBrush-footed Butterfly");
                System.out.println("\tGossamer Wing");
                System.out.println("\tPieridae");
                System.out.println("\tSwallowtail");
                System.out.print("\nEnter your choice: ");
                choice = input.nextLine().toUpperCase();
                int index = linearFamilySearch(butterflies, choice);
                if(index != -1) {
                    //call the copy constructor here!
                	Butterfly b = new Butterfly(butterflies.get(index));
                    System.out.print("Enter the species: ");
                    species = input.nextLine();
                    b.setSpecies(species);
                    System.out.print("Enter the color: ");
                    color = input.nextLine();
                    b.setColor(color);
                    //set the species number here!
                    int speciesNumber = Butterfly.generateSpeciesNumber();
                    b.setSpeciesNumber(speciesNumber);
                    butterflies.add(b);
                    System.out.println("\nThe following butterfly has been added:\n" + b + "\n");
                } else {
                    System.out.println("Sorry, " + choice + " is not an accepted family!\n");
                }    
            } else if (choice.equalsIgnoreCase("R")) {
                //fill in here
				System.out.println("\nEnter the Species Number: ");
				int speciesNumber = input.nextInt();
				int index = linearSpeciesNumberSearch(butterflies, speciesNumber);
				if(index == -1) {
					System.out.println("Sorry, we don't have a butterfly of that number!");
				} else {
					System.out.println("Removing...\n");
					butterflies.get(index).toString();
				}
            } else if (choice.equalsIgnoreCase("V")) {
                //fill in here
            	System.out.println("\nSelect from one of our accepted families of butterfly:");
            	System.out.println("\tBrush-footed Butterfly");
                System.out.println("\tGossamer Wing");
                System.out.println("\tPieridae");
                System.out.println("\tSwallowtail");
                System.out.print("\nEnter your choice: ");
                choice = input.nextLine().toUpperCase();
                if(choice.equalsIgnoreCase("Brush-footed Butterfly") || choice.equalsIgnoreCase("Gossamer Wing") || choice.equalsIgnoreCase("Pieridae") || choice.equalsIgnoreCase("Swallowtail")) {
                	ArrayList butterflyFamily = new ArrayList<Butterfly>();
                	butterflyFamily = findAFamily(butterflies, choice);
                	System.out.println("\nButterflies of the " + choice + " family:");
                	for(i = 0; i < butterflyFamily.size(); i++) {
                		System.out.println(butterflyFamily.get(i).toString());
                	}
                } else {
                	System.out.println("Sorry, " + choice + " is not an accepted family!\n");
                }
            } else if (choice.equalsIgnoreCase("Q")) {
                File outfile = new File("butterflyList.txt");
                //fill in here to write to file
                PrintWriter out = new PrintWriter(outfile);
                for(i = 0; i < butterflies.size(); i++) {
                	out.println(butterflies.get(i).toString());
                }
                out.close();
                System.out.println("\nGoodbye!");
            } else {
                System.out.println("\nInvalid choice.\n");
            }
        }
        input.close();
    }
    
    /**
     * Searches an ArrayList of Butterfly objects for
     * all Butterfly objects of the given family
     * @param al the ArrayList of Butterfly objects
     * @param family the family to search for
     * @return an ArrayList containing ALL butterfly objects
     * belonging to the given family.
     */
    public static ArrayList<Butterfly> findAFamily(ArrayList<Butterfly> al, String family) {
        ArrayList butterflyFamily = new ArrayList<Butterfly>();
    	for(int i = 0; i < al.size(); i++) {
    		if(al.get(i).getFamily().equals(family)) {
    		Butterfly b = new Butterfly(al.get(i));
    	    butterflyFamily.add(b);
    		}
    	}
        return butterflyFamily;
    }
    
    /**
     * Searches an ArrayList of Butterfly objects for
     * the first Butterfly object of the given family
     * @param al the ArrayList of Butterfly objects
     * @param family the family to search for
     * @return the index in the ArrayList of the first Butterfly 
     * belonging to the given family
     */
    public static int linearFamilySearch(ArrayList<Butterfly> al, String family) {
        for(int i = 0; i < al.size(); i++) {
        	if(al.get(i).getFamily().equals(family)) {
        		return i;
        	}
        }
    	return -1;
    }
    
    /**
     * Searches an ArrayList of Butterfly objects for the 
     * Butterfly whose species number matches the given
     * speciesNumber
     * @param al the ArrayList of Butterfly objects
     * @param speciesNumber the species number
     * @return the index of the Butterfly with
     * the matching speciesNumber in the ArrayList
     */
    public static int linearSpeciesNumberSearch(ArrayList<Butterfly> al, int speciesNumber) {
        for(int i = 0; i < al.size(); i++) {
        	if(al.get(i).getSpeciesNumber() == speciesNumber) {
        		return i;
        	}
        }
    	return -1;
    }
}