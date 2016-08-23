public abstract class GameCharacter {
    //Props
    private String characterName;
    private int characterHealth;
    private int characterAttack;
    private int characterXp;
    //Construct
    public GameCharacter(String characterName, int characterHealth, int characterAttack, int characterXp){
        this.characterName = characterName;
        this.characterHealth = characterHealth;
        this.characterAttack = characterAttack;
        this.characterXp = characterXp;
    }
    //Get
    public String getCharacterName(){
        return this.characterName;
    }
    public int getCharacterHealth(){
        return this.characterHealth;
    }
    public int getCharacterAttack(){
        return this.characterAttack;
    }
    public int getCharacterXp(){
        return this.characterXp;
    }
    
    //Set
    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }
    public void setCharacterHealth(int characterHealth){
        this.characterHealth = characterHealth;
    }
    public void setCharacterAttack(int characterAttack){
        this.characterAttack = characterAttack;
    }
    public void setCharacterXp(int characterXp){
        this.characterXp = characterXp;
    }
    
    //Take turn
    public abstract void takeTurn(GameCharacter character);
    
    //Take damage
    public abstract void reduceHealthBy(int damage);
}