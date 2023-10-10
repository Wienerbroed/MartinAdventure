import java.util.ArrayList;

public class Player {
    private Map map = new Map();
    private Room currentRoom = map.getStarterRoom();
    private int currentHp;

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
            if (item.getType().equals(item)) {
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

    public boolean dropItem(String itemName) { // Method to drop items
        boolean isNull = false;
        for (int i = 0; i < getInventoryList().size(); i++) {
            Item item = getInventoryList().get(i);
            if (item.getType().equals(itemName)) {
                inventory.remove(item);
                currentRoom.getItemList().add(item);
                isNull = true;
            }
        }
        return isNull;
    }

    public boolean takeItem(String itemName) {
        boolean isNull = false;
        Item item = currentRoom.findItem(itemName);
        if (item == null) {
            item = currentRoom.findConsumable(itemName);
        }
        if (item != null) {
            if (item instanceof Consumable) {
                Consumable consumableItem = (Consumable) item;
                inventory.add(consumableItem);
                currentRoom.removeItem(consumableItem);
                addHealingItem(consumableItem);
                isNull = true;
                System.out.println("You took the " + itemName + " (Consumable).");
            } else {
                inventory.add(item);
                currentRoom.removeItem(item);
                isNull = true;
                System.out.println("You took the " + itemName + ".");
            }
        } else {
            System.out.println("Item not found in this room.");
        }

        return isNull;
    }
    public Consumable findHealingItem(String itemName) {
        for (Consumable item : healingItems) {
            if (item.getType().equals(itemName)) {
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







    public Player () {




    }
    
}
