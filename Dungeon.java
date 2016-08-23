public class Dungeon
{
    private Room southHall;
    private Room northHall;
    private Room kitchen;
    private Room skeleton;
    private Room bathroom;
    private Room bedroom;
    private Room garden;
    private Room bossHall;
    private Room bossRoom;
    
    public Dungeon()
    {
        //Initialize Rooms
        this.southHall = new Room("South Hall");
        this.northHall = new Room("North Hall");
        this.kitchen = new ItemRoom("Kitchen",ItemList.sword);
        this.garden = new ItemRoom("Garden",ItemList.key);
        this.bedroom = new CombatRoom("Bedroom",MonsterList.vampire, "The vampire disappeared from the room.");
        this.bathroom = new ItemRoom("Bathroom",ItemList.potion);
        this.skeleton = new CombatRoom("Skeleton Chamber",MonsterList.skeleton,"You see the dead skeleton on the floor.");
        this.bossHall = new LockedRoom("You entered the room leading with another long hall.");
        this.bossRoom = new CombatRoom("Boss Room.",MonsterList.boss, "You have defeated the game. Congratulations!");
        
        
        //Set Exits
        this.skeleton.setExits(this.skeleton, this.skeleton, this.northHall, this.kitchen);
        this.southHall.setExits(this.northHall, this.kitchen, this.bedroom, this.southHall);
        this.northHall.setExits(this.bossHall, this.skeleton, this.northHall, this.southHall);
        this.kitchen.setExits(this.skeleton, this.garden, this.southHall, this.kitchen);
        this.garden.setExits(this.garden, this.garden, this.kitchen, this.garden);
        this.bedroom.setExits(this.bathroom, this.southHall, this.bedroom, this.bedroom);
        this.bathroom.setExits(this.bathroom, this.northHall, this.bathroom, this.bedroom);
        this.bossHall.setExits(this.bossRoom, this.bossHall, this.bossHall,this.northHall);
        this.bossRoom.setExits(this.bossRoom, this.bossRoom, this.bossRoom, this.bossHall);
    }
    
    public Room getRoom0()
    {
        return this.southHall;
    }
}