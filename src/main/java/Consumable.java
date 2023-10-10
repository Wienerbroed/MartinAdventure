public class Consumable extends Item{
    private int hpHeal;


    public Consumable(String description, String type, String function, int hpHeal) {
        super(description, type, function);
        this.hpHeal = hpHeal;
    }
    public int getHpHeal() {
        return hpHeal;
    }
    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getFunction() {
        return super.getFunction();
    }
}
