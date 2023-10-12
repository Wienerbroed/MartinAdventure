import java.util.ArrayList;

public class Player {
    private Map map = new Map();
    private Room currentRoom = map.getStarterRoom();
    private int currentHp;

    private Weapon equippedWeapon;
    private Melee equippedMeleeWeapon;
    private Range equippedRangeWeapon;

    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Consumable> healingItems = new ArrayList<>();


    public ArrayList<Consumable> getHealingItems() {
        return healingItems;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public ArrayList<Item> getInventoryList() {
        return inventory;
    }

    public boolean goNorth() {
        if (currentRoom.getNeighbourNorth() == null) {
            System.out.println("You walked into a wall... Why?");
        } else {
            setCurrentRoom(currentRoom.getNeighbourNorth());
        }
        return true;
    }

    public boolean goSouth() {
        if (currentRoom.getNeighbourSouth() == null) {
            System.out.println("You walked into a wall... Why?");
        } else {
            setCurrentRoom(currentRoom.getNeighbourSouth());
        }
        return true;
    }

    public boolean goWest() {
        if (currentRoom.getNeighbourWest() == null) {
            System.out.println("You walked into a wall... Why?");
        } else {
            setCurrentRoom(currentRoom.getNeighbourWest());
        }
        return true;
    }

    public boolean goEast() {
        if (currentRoom.getNeighbourEast() == null) {
            System.out.println("You walked into a wall... Why?");
        } else {
            setCurrentRoom(currentRoom.getNeighbourEast());
        }
        return true;
    }

    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getType().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void useHealingItem(Consumable item) {
        int newHp = currentHp + item.getHpHeal();
        setCurrentHp(newHp); // Update the player's health directly
        System.out.println("You used a " + item.getType() + " and healed for " + item.getHpHeal() + " HP.");
    }

    public boolean dropItem(String itemName) {
        for (int i = 0; i < getInventoryList().size(); i++) {
            Item item = getInventoryList().get(i);
            if (item.getType().equals(itemName)) {
                inventory.remove(item);
                currentRoom.getItemList().add(item);
                System.out.println("You dropped the " + itemName + ".");
                return true;
            }
        }
        System.out.println("Item was not found in your inventory.");
        return false;
    }


    public boolean takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            System.out.println("You took the " + itemName + ".");
            return true;
        } else {
            Melee meleeWeapon = currentRoom.findMeleeWeapon(itemName);
            if (meleeWeapon != null) {
                inventory.add(meleeWeapon);
                currentRoom.removeMeleeWeapon(meleeWeapon);
                System.out.println("You took the " + itemName + " (Melee).");
                return true;
            }
        }

        System.out.println("Item not found in this room.");
        return false;
    }


    public Consumable findHealingItem(String itemName) {
        for (Consumable item : healingItems) {
            if (item.getType().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item instanceof Melee && item.getType().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


    public void addHealingItem(Consumable item) {
        healingItems.add(item);
    }

    public void removeHealingItem(Consumable item) {
        healingItems.remove(item);
    }

    public void consumeItem(String itemName) {
        Consumable healingItem = findHealingItem(itemName);

        if (healingItem != null) {
            System.out.println("Found healing item: " + healingItem.getType());

            int newHp = getCurrentHp() + healingItem.getHpHeal();
            setCurrentHp(newHp);
            removeHealingItem(healingItem);
            System.out.println("You consumed a " + healingItem.getType() + " and gained " + healingItem.getHpHeal() + " HP.");
        } else {
            System.out.println("Healing item not found in your inventory.");
        }
    }




    public Range findRangeWeaponInInventory(String weaponName) {
        for (Item item : inventory) {
            if (item instanceof Range) {
                Range rangeWeapon = (Range) item;
                if (rangeWeapon.getType().equalsIgnoreCase(weaponName)) {
                    return rangeWeapon;
                }
            }
        }
        return null; // Return null if the weapon is not found in the inventory
    }


    public Melee getEquippedMeleeWeapon() {
        return equippedMeleeWeapon;
    }


    public Range getEquippedRangeWeapon() {
        return equippedRangeWeapon;
    }


    public Weapon findWeaponInInventory(String weaponName) {
        for (Item item : inventory) {
            if (item instanceof Weapon && item.getType().equalsIgnoreCase(weaponName)) {
                return (Weapon) item;
            }
        }
        return null;
    }

    public void equipWeapon(String itemName) {
        Item itemToEquip = findItemInInventory(itemName);

        if (itemToEquip != null) {
            // Check the type of the item and perform actions accordingly
            if (itemToEquip instanceof Melee) {
                equippedMeleeWeapon = (Melee) itemToEquip;
                System.out.println("You have equipped the " + equippedMeleeWeapon.getType() + ".");
            } else if (itemToEquip instanceof Range) {
                equippedRangeWeapon = (Range) itemToEquip;
                System.out.println("You have equipped the " + equippedRangeWeapon.getType() + ".");
            } else if (itemToEquip instanceof Weapon) {
                equippedWeapon = (Weapon) itemToEquip;
                System.out.println("You have equipped the " + equippedWeapon.getType() + ".");
            }
        } else {
            System.out.println("No item with the name '" + itemName + "' found in your inventory.");
        }
    }
}