public class Key extends Item
{
    public Key()
    {
        super("Key");
    }
    
    public void doFunction()
    {
        System.out.println("You can't use this in combat!");
    }
}