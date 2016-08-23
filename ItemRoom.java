import java.util.Scanner;
public class ItemRoom extends Room{
    private Item roomItem = new Item();
    private Scanner keyboard = new Scanner(System.in);
    private boolean hasBeenTaken = false;
    public ItemRoom(String description, Item item){
        super(description);
        roomItem = item;
    }
    public void doRoomFunction(){
        System.out.println(super.getDescription());
        if (!hasBeenTaken){
            System.out.println("You found a " + this.roomItem.getName() + ". Would you like to take it?");
            String response = keyboard.nextLine();
            if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")){
                    //Now I think I should have a static array list class stored in a backpack class..
                    BackPack.addToBackPack(roomItem);
                    System.out.println("You added the " + this.roomItem.getName() + " to the backpack.");
                    hasBeenTaken = true;
            }
        }
        //Now we need to remove the item from the room after it has been taken!
    }
}