public class Item{
    private String name;
    
    //Constructors
    public Item(){
        this.name = "Exit"; //Trick to exit backpack. Will try to implement later.
    }
    
    public Item(String itemName){
        this.name = itemName;
    }
    
    public Item(Item item){
        this.name = item.getName();
    }
    
    //Set and get
    public void setName(String itemName){
        this.name = itemName;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void doFunction(){
        System.out.println();
    }
    
    public String toString(){
        return name;
    }
    
    public static boolean equals(String itemName)
    {
        boolean isEqual = false;
        if (itemName.equalsIgnoreCase(itemName))
        {
            isEqual = true;
        }
        return isEqual;
    }
}

