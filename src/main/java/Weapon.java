public abstract class Weapon extends Item {
    private int damage;

    public Weapon(String description, String type, int damage) {
        super(description, type, "Deals damage");
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}