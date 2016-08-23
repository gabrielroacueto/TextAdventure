public class Potion extends Item{
    public Potion(){
        super("Potion");
    }
    @Override
    public void doFunction(){  //I think this will override and solve my function problem..
        Hero.hero.reduceHealthBy(-10);
        System.out.println("You drink the potion and recover 10 health points.");
    }
}

//Shall we brute force a constructor that takes an item and just basically turns the default item into a potion?
//It feels right..