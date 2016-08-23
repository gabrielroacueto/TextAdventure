public class Sword extends Item{
    public Sword(){
        super("Sword");
    }
    @Override
    public void doFunction(){
        Hero.hero.setCharacterAttack (Hero.hero.getCharacterAttack() + 15);
        System.out.println("You take the sword and feel significantly more powerful.");
    }
}