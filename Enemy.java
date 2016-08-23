import java.util.Random;
public class Enemy extends GameCharacter{
    private int enemyHp;
    private int enemyMagic;
    private int enemyAttack;
    private int enemyXp;
    private String enemyName;
    private Item enemyItem;
    private Random  randomGenerator = new Random();
    
    public Enemy(){ //Default constructor not meant to be used. 
        this.enemyHp = 1;
        this.enemyAttack = 1;
        this.enemyName = "Default";
        this.enemyItem = null;
    }
    public Enemy(int hp, int attack, String name, Item enemyItem){
        this.enemyHp = hp;
        this.enemyName = name;
        this.enemyAttack = attack;
        this.enemyItem = enemyItem;
    }
    public Enemy(Enemy enemy){
        this.enemyHp = enemy.getEnemyHp();
        this.enemyAttack = enemy.getEnemyAttack();
        this.enemyName = enemy.getName();
        this.enemyItem = enemy.getItem();
    }
    
    //Setters and getters
    public String getName(){
        return this.enemyName;
    }
    public int getEnemyHp(){
        return this.enemyHp;
    }
    public int getEnemyAttack(){
        return this.enemyAttack;
    }
    public void setName(String name){
        this.enemyName = name;
    }
    public void setItem(Item enemyItem){
        this.enemyItem = enemyItem;
    }
    public void setEnemyHp(int hp){
        this.enemyHp = hp;
    }
    public void setEnemyAttack(int attack){
        this.enemyAttack = attack;
    }
    public void changeArgs(Enemy enemy){
        this.enemyHp = enemy.getEnemyHp();
        this.enemyAttack = enemy.getEnemyAttack();
        this.enemyName = enemy.getName();
        this.enemyItem = enemy.getItem();
    }
    public Item getItem(){
        
        return this.enemyItem;
    }
    public void takeTurn(){
        if (this.enemyHp > 0){
            int enemyDamage = this.enemyAttack + randomGenerator.nextInt(10);
            Hero.heroHealth -= enemyDamage;
            System.out.println("The enemy attacked you for " + enemyDamage + " damage.");
        }
    }
}