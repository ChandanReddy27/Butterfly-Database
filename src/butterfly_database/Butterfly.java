/**
 * Butterfly class
 * @author Ethan Ly
 * @author Chandan Reddy
 * CIS 36B, Lab 5, Part 1
 */

package butterfly_database;

public class Butterfly {
    private String family;
    private String species;
    private String color;
    private int speciesNumber;
    private static int speciesNum = 550;
    
    /**
     * Default constructor for Butterfly
     * Assigns the following default values
     * family: "Family unknown"
     * species: "Species unknown"
     * color: "Color unknown"
     * speciesNumber: 0
     */
    
    public Butterfly() {
    	family = "Family unknown";
    	species = "Species unknown";
    	color = "Color unknown";
    	speciesNumber = 0;
    }
    
    /**
     * Multi-argument constructor for Butterfly
     * @param family the family of butterfly
     * @param species the butterfly species
     * @param color the principle wing color
     * @param speciesNumber the species number
     * speciesNumber assigned to 0
     */
    public Butterfly(String family, String species, String color) {
    	this.family = family;
    	this.species = species;
    	this.color = color;
    	speciesNumber = 0;
    }
    
    /**
     * Creates a new butterfly that is a copy
     * of b. Except speciesNumber is assigned 0
     * @param b another Butterfly
     */
    public Butterfly(Butterfly b) {
    	if(b != null) {
    		this.family = b.family;
    		this.species = b.species;
    		this.color = b.color;
    		speciesNumber = 0;
    	}
    }
    
    /**
     * Accesses the family of butterfly
     * @return the family of butterfly
     */
    public String getFamily() {
        return family;
    }
    
    /**
     * Accesses the species of butterfly
     * @return the species of butterfly
     */
    public String getSpecies() {
        return species;
    }
    
    /**
     * Accesses the color of butterfly
     * @return the color of butterfly
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Accesses the assigned species number
     * @return the species number
     */
    public int getSpeciesNumber() {
        return speciesNumber;
    }
    
    /**
     * Assigns a new family of butterfly
     * @param family the butterfly family
     */
    public void setFamily(String family) {
        this.family = family;
    }
    
    /**
     * Assigns a new species of butterfly
     * @param species the butterfly species
     */
    public void setSpecies(String species) {
        this.species = species;
    }
    
    /**
     * Assigns a new color of butterfly
     * @param color the principle wing color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Assigns a new species number 
     * @param speciesNumber the number generated
     * by generateSpeciesNumber variable
     */
    public void setSpeciesNumber(int speciesNumber) {
        this.speciesNumber = speciesNumber;
    }
    
    /**
     * Used to generate a new species number
     * for each butterfly. To be called
     * each time a new butterfly object is 
     * created (constructor is called).
     * Increments speciesNum and returns it
     * @return the species number
     */
    public static int generateSpeciesNumber() {
        return speciesNum++;
    }
    
    /**
     * Creates a String of butterfly information
     * Species: <species>
     * Family: <family>
     * Color: <color>
     * Species Number <speciesNumber>
     * @return the butterfly information
     */
    @Override public String toString() {
        return "\nSpecies: " + species + 
        		"\nFamily: " + family +
        		"\nColor: " + color +
        		"\nSpecies Number " + speciesNumber + "\n";
    }  
}