public class Room
{
    private String description;
    private Room north;
    private Room east;
    private Room west;
    private Room south;
    
    public Room(String description)
    {
        this.description = description;
    }
    
    public Room(Room room)
    {
       this.description = room.description;
       this.north = room.north;
       this.east = room.east;
       this.west = room.west;
       this.south = room.south;
    }
    public void setExits(Room north, Room east, Room west, Room south)
    {
        this.north = north;
        this.east = east;
        this.west = west;
        this.south = south;
    }
    public void setNorth(Room north)
    {
        this.north = north;
    }
    public void setEast(Room east)
    {
        this.east = east;
    }
    public void setSouth(Room south)
    {
        this.south = south;
    }
    public void setWest(Room west)
    {
        this.west = west;
    }
    public Room getNorth()
    {
        return this.north;
    }
    public Room getEast()
    {
        return this.east;
    }
    public Room getWest()
    {
        return this.west;
    }
    public Room getSouth()
    {
        return this.south;
    }
    public String getDescription()
    {
        return this.description;
    }
    public String toString()
    {
        return this.description;
    }
    public String getExits()
    {
        return String.format("North: %s, East: %s, West: %s, South: %s", this,north, this.east, this.west, this.south);
    }
    public void doRoomFunction()
    {
        System.out.println("You're in " + description);
    }
    public Boolean equals(Room room)
    {
        boolean same = false;
        if (this.description.equals(room.description))
        {
            same = true;
        }
        return same;
    }
}