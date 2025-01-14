package zombieuniversity.character;

public abstract class Character {
    /**
     * Attack the other character, reducing its health by this character's damage.
     * @param otherCharacter 
     */
    public void attack(Character otherCharacter) {
        // If the other character is dead, then there is nothing to be done
        if(!otherCharacter.isAlive()) {
            return;
        }
        
        // If we are going below 0, set it to 0 and output to the kill feed
        if(otherCharacter.health <= damage) {
            otherCharacter.health = 0;
            System.out.printf("    %s killed %s\n", this, otherCharacter);
        }
        else {
            otherCharacter.health -= damage;
        }
    }
    
    /**
     * Get the health of the character
     * @return health
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * Set the damage of the character
     * @param damage new damage of the character
     */
    protected void setDamage(int damage) {
        this.damage = damage;
    }
    
    /**
     * Get the damage of the character
     * @return damage of the character
     */
    public int getDamage() {
        return damage;
    }
    
    /**
     * Get the health of the character
     * @return true if the character has at least 0 health
     */
    public boolean isAlive() {
        return health > 0;
    }
    
    /**
     * Initialize a character
     * @param maxHealth maximum health of the character
     * @param damage    damage of the character
     */
    protected Character(int maxHealth, int damage) {
        this.health = maxHealth;
        this.damage = damage;
    }
    
    /**
     * Get the name of the type
     * @return the name of the type
     */
    public abstract String getTypeName();
    
    /**
     * Get the name of the character
     * @return name of the character
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name of the character
     * @param newName new name of the character
     */
    public void setName(String newName) {
        name = newName;
    }
    @Override
    public String toString() {
        if(name == null) {
            return getTypeName();
        }
        else {
            return String.format("%s %s", getTypeName(), name);
        }
    }
    
    private int health;
    private int damage;
    private String name;
}
