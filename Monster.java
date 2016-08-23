import java.util.Random;
public class Monster extends GameCharacter {
    //Props
    private Random randomGenerator = new Random();
    private Item monsterItem;
    
    //Construct
    public Monster(String characterName, int characterHealth, int characterAttack, int characterXp, Item monsterItem){
        super(characterName, characterHealth, characterAttack, characterXp);
        this.monsterItem = monsterItem;
    }
    public Item getMonsterItem(){
        return this.monsterItem;
    }
    //Take turn
    public void takeTurn(GameCharacter player){
        if (this.getCharacterHealth() > 0){
            int enemyDamage = this.getCharacterAttack() + randomGenerator.nextInt(10);
            player.reduceHealthBy(enemyDamage);
            System.out.println("The " + this.getCharacterName() + " attacked you for " + enemyDamage + " damage.");
        }
    }
    
    //Take damage
    public void reduceHealthBy(int damage){
        this.setCharacterHealth(this.getCharacterHealth() - damage);
    }
}