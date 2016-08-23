import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class Player extends GameCharacter {         //Most of the combat engine logic will be included here.
    //Prop
    private Scanner keyboard = new Scanner(System.in);
    private Random randomGenerator = new Random();
    private int playerMana = 0;
    private static final int ATTACK = 1;
    private static final int CHECKBACKPACK = 2;
    private static final int CHARGEMANA = 3;
    private static final int CASTSPELL = 4;
    private static final int RUNAWAY = 5;
    
    //Constructor
    public Player(String characterName, int characterHealth, int characterAttack, int characterXp, int playerMana){
        super(characterName, characterHealth, characterAttack, characterXp);
        this.playerMana = playerMana;
    }
    //Take turn
    public void takeTurn(GameCharacter monster){
        //Here goes combat menu and combat room logic.
        int input = getCombatOption();
        doCombatAction(input, monster);
    }
    
    //Take damage
    public void reduceHealthBy(int damage){
        this.setCharacterHealth(this.getCharacterHealth() - damage);
    }
    
    //Take turn methods
     private int getCombatOption(){ //Prints menu and gets the option that you're going to perform.
        boolean isNotValid = true;
        int option = -1;
        do {
            isNotValid = false;
            
            try {
                System.out.println("1) Attack");
                System.out.println("2) Check backpack");
                System.out.println("3) Charge Mana");
                System.out.println("4) Cast Spell");
                System.out.println("5) Run away");
                option = keyboard.nextInt();
                
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number .");
                keyboard.nextLine();
                isNotValid = true;
            }
            
        } while (isNotValid);
        
        return option;
    }
    
    private void doCombatAction(int input, GameCharacter monster){ //Decides option and does whatever
    
        if (input == ATTACK){           //Similar to monster's takeTurn();
            doAttack(monster);
        } else if (input == CHECKBACKPACK){
            checkBackPack();
        } else if (input == CHARGEMANA){
            chargeMana();
        } else if (input == CASTSPELL){
            castSpell(monster);
        } else if (input == CASTSPELL && this.playerMana < 3) {
            System.out.println("You need at least 3 magic points to cast this spell!");
        } else if (input == RUNAWAY){
            doRunAway();
        } else {
            System.out.println("I don't understand that command!");
        }
    }
    
    private void doAttack(GameCharacter monster){
        int damage = this.getCharacterAttack() + randomGenerator.nextInt(15);
        monster.reduceHealthBy(damage);
        System.out.println("You attack the " + monster.getCharacterName() + " for " + damage + " damage!");
    }
    private void checkBackPack(){
        if (BackPack.isEmpty()){
            System.out.println("There is nothing in there!");
        } else {
            System.out.println("You open your bag and check the items: ");
            BackPack.printBackPack();
            System.out.println("0) Exit.");
            System.out.println("What would you like to do?");
            
            doBackPackAction(getBackPackInput());
        }
    }
    private void doRunAway(){
        CombatRoom.runAway();
    }
    
    private int getBackPackInput(){
        int input = keyboard.nextInt();
        return input;
    }
    
    private void doBackPackAction(int input){
        if (input != 0){
            Item retrieve = BackPack.getItem(input - 1);
            retrieve.doFunction(); 
            if (!retrieve.equals("Key")){
                BackPack.removeItem(input - 1);
            } 
        } else {
            System.out.println("Exiting backpack.");
        }
    }
    private void chargeMana(){
        System.out.println("You focus and charge your magic power.");
        this.playerMana++;
    }
    private void castSpell(GameCharacter monster){
        monster.setCharacterHealth(monster.getCharacterHealth() / 2);
        System.out.println("You cast a strong spell on the enemy!");
        this.playerMana -= 3;
    }
}