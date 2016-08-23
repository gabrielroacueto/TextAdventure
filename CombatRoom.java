import java.util.Scanner;
import java.util.Random;
public class CombatRoom extends Room{
    private Monster monster;
    private static final int ATTACK = 1;
    private static final int CHECKBACKPACK = 2;
    private static final int RUNAWAY = 3;
    private Random  randomGenerator = new Random();
    private Scanner keyboard = new Scanner(System.in);
    private boolean isFighting = true;
    private boolean isAlive = true;
    private boolean isEnemyAlive = true;
    private static boolean runAway = false;
    private String afterCombatDescription;
    
    public CombatRoom(String description, Monster monster, String secondDescription){ //Constructor takes an enemy parameter, that I should be able to pass on.
       super(description);
       this.monster = monster;
       this.afterCombatDescription = secondDescription;
    }
    
    public void doRoomFunction(){
        this.runAway = false;
        printRoomDescription();
        while(isEnemyAlive && isFighting && isAlive && !runAway){
            System.out.println(this.monster.getCharacterName() + "'s health: " + this.monster.getCharacterHealth());
            System.out.println(Hero.hero.getCharacterName() + "'s health: " + Hero.hero.getCharacterHealth());
            Hero.hero.takeTurn(this.monster);
            this.monster.takeTurn(Hero.hero);
            checkCombatStatus();
            //This should be replace by a take turn method.
            //Player.takeTurn();
            //Enemy.takeTurn();
            //And thats the loop.
        }
        
        if (!isEnemyAlive){
            System.out.println(afterCombatDescription);
            //Drop enemy item into backpack.
            if (this.monster.getMonsterItem() != null){
                BackPack.addToBackPack(this.monster.getMonsterItem());
                System.out.println("The " + this.monster.getCharacterName() + " dropped a " + this.monster.getMonsterItem());
            }
        }
    }
    
    private void checkCombatStatus(){ //Check if you're dead, if monster is dead, if you ran away.
        if (Hero.hero.getCharacterHealth() <= 0){
            System.out.println("You have been killed.");
            this.isAlive = false;
            SuperAdventure.endGame();
        } else if (this.monster.getCharacterHealth() <= 0){
            System.out.println("You have defeated the " + this.monster.getCharacterName());
            this.isEnemyAlive = false;
        }
    }
    
    private void printRoomDescription(){
        System.out.println(super.getDescription());
    }
    
    public static void runAway(){
        System.out.println("You ran away from combat!");
        runAway = true;
        SuperAdventure.currentRoom = SuperAdventure.currentRoom.getEast();
    }
    
}