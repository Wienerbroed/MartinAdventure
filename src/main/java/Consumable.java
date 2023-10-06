public class Consumable extends Item{
    private int hpHeal;


    public Consumable(String description, String type, String function, int hpHeal) {
        super(description, type, function);
        this.hpHeal = hpHeal;
    }
}
