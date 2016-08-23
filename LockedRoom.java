public class LockedRoom extends Room
{
    public LockedRoom(String description)
    {
        super(description);
    }
    
    public void doRoomFunction()
    {
        //Check if you have key item
        if (BackPack.hasItem("Key"))
        {
            System.out.println(this.getDescription());
        }
        else
        {
            System.out.println("The door is locked! Maybe you can find a key.");
            SuperAdventure.currentRoom = SuperAdventure.currentRoom.getSouth();
        }
        //Let you in if yes
        //Display no if not.
    }
}