package zombieuniversity;

import java.util.HashMap;
import java.util.Random;
import zombieuniversity.character.*;
import zombieuniversity.character.Character;

/**
 *
 * @author ianbergstrom
 */
public class CharacterFactory {
    
    /**
     * Generates a random Integer inside a specified range.
     * @param min This is the minimum value for the range of the random number generator.
     * @param max This is the maximum value for the range of the random number generator.
     * @return Returns the random Integer that was generated inside the range specified.
     */
    public int randomInt(int min, int max) {
        Random r = new Random();
        int random = min + r.nextInt((max - min) + 1);
        return random;
    }
    
    /**
     * Generates a random number to determine which Zombie type is to be returned
     * (0 for CommonInfect, 1 for Tank)
     * @return Returns a random Zombie type 
     */
    public Zombie randomZombieType(){
        switch(randomInt(0, 1)) {
            case 0:
                return new CommonInfected();
            case 1:
                return new Tank();
            default:
                throw new UnsupportedOperationException();
        }
    }
    
    /**
     * This piece of code represents the randomized generation of the survivor 
     * type.
     * @return Returns a random Survivor type 
     */
    public Survivor randomSurvivorType(){
        switch(randomInt(0, 2)) {
            case 0:
                return new Child();
            case 1:
                return new Teacher();
            case 2:
                return new Soldier();
            default:
                throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Using the randomInt and randomZombieType methods, generates an array of random size
     * (inside the specified range) and populates it randomly with Zombie types.
     * @param min Minimum number of zombies
     * @param max Maximum number of zombies (inclusive)
     * @return Return an array of Zombies that has been randomly generated.
     */
    public Zombie[] randomZombieArray(int min, int max) {
        int rand = randomInt(min, max);
        Zombie[] zombieHoard = new Zombie[rand];
        for (int i = 0; i < zombieHoard.length; i++) {
            zombieHoard[i]=randomZombieType();
        }
        setDefaultNamesForArray(zombieHoard);
        return zombieHoard;
    }
    
    /**
     * Using the randomInt and randomSurvivorType methods, generates an array of random size
     * (inside the specified range) and populates it randomly with Survivor types.
     * @param min Minimum number of survivors
     * @param max Maximum number of survivors (inclusive)
     * @return Return an array of Survivors that has been randomly generated.
     */
    public Survivor[] randomSurvivorArray(int min, int max) {
        int rand = randomInt(min, max);
        Survivor[] foxTrotCharlie = new Survivor[rand];
        for (int i = 0; i < foxTrotCharlie.length; i++) {
            foxTrotCharlie[i]=randomSurvivorType();
        }
        setDefaultNamesForArray(foxTrotCharlie);
        return foxTrotCharlie;
    }
    
    /**
     * Set the default names for the characters in the array
     * @param array array to set default names
     */
    private void setDefaultNamesForArray(Character[] array) {
        HashMap<String, Integer> counts = new HashMap<>();
        for(Character c : array) {
            // Get the type name
            String typeName = c.getTypeName();
            Integer value = counts.get(typeName);
            
            // If it doesn't exist, initialize it to 0. Otherwise, increment it
            if(value == null) {
                value = 0;
                counts.put(typeName, value);
            }
            else {
                value = value + 1;
                counts.put(typeName, value);
            }
            
            // Set the name
            c.setName(value.toString());
        }
    }
}