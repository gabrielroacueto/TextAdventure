import java.util.Scanner;
public class SuperAdventure
{
    private static Scanner keyboard = new Scanner(System.in);
    public static Room currentRoom = new Room("currentRoom");
    private static boolean isRunning = true;
    public static Room tempRoom;
    private static Dungeon dungeon = new Dungeon();
    public static void main(String[] args)
    {
        setHeroName();
        currentRoom = dungeon.getRoom0();
        promptWelcome();
        do
        {
            currentRoom.doRoomFunction();
            if (isRunning == true){              //Double check
                getDirection();
            }
            if (tempRoom.equals(currentRoom) && tempRoom != null)
            {
                System.out.println("You can't go there. It's just a wall in front of you.");
            }
        } while(isRunning);

        promptDeath();
    }
    
    private static void promptWelcome()
    {
        System.out.println("Welcome to the adventure game. You're journy begins in a sketchy house.\nYou have now idea how you got there.");
    }
    
    private static void getDirection()
    {
        System.out.println("Where would you like to go now?");
        System.out.println("[N]orth | [S]OUTH | [E]AST | [W]EST | [Q]UIT");
        String userInput = keyboard.nextLine();
        tempRoom = new Room(currentRoom.toString());
        
        if (userInput.equalsIgnoreCase("n")){
            currentRoom = currentRoom.getNorth();
        } else if (userInput.equalsIgnoreCase("e")){
            currentRoom = currentRoom.getEast();
        } else if (userInput.equalsIgnoreCase ("w")){
            currentRoom = currentRoom.getWest();
        } else if (userInput.equalsIgnoreCase("s")){
            currentRoom = currentRoom.getSouth();
        } else if (userInput.equalsIgnoreCase("q")){
            System.out.println("You get too scared and decide to commit suicide.");
            isRunning = false;
        } else {
            System.out.println("I don't understand that command!");
        }
    }
    
    private static void promptDeath()
    {
        System.out.println("Game over.");
    }
    
    private static void setHeroName()
    {
        System.out.println("Enter your name: ");
        Hero.hero.setCharacterName(keyboard.nextLine());
    }
    
    public static void endGame(){
        isRunning = false;
    }
}