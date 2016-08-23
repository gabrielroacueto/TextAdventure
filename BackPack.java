import java.util.ArrayList;
public class BackPack{
    public static ArrayList<Item> backPack = new ArrayList<Item>();
    
    public static void addToBackPack(Item item){
        backPack.add(item);
    }
    
    public static void printBackPack(){
        for (Item i: backPack){
            System.out.println((backPack.indexOf(i) + 1) + ") " + i);
        }
    }
    public static boolean isEmpty(){
        return backPack.isEmpty();
    }
    
    public static Item getItem(int index){
        return backPack.get(index);
    }
    
    public static void removeItem(int index){
        backPack.remove(index);
    }
    
    public static boolean hasItem(String itemName)
    {
        boolean isThere = false;
        for (Item i : backPack)
            {
                if (i.equals(itemName))
                {
                    isThere = true;
                }
            }
        return isThere;
    }
}