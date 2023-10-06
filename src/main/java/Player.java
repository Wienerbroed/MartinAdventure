import java.util.ArrayList;

public class Player {
    private Map map = new Map();
    private Room currentRoom = map.getStarterRoom();

    private ArrayList<Item> inventory = new ArrayList<>();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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
        boolean itemTaken = false;
        Item item = currentRoom.findItem(itemName);

        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            itemTaken = true;
            System.out.println("You took the " + itemName + ".");
        } else {
            System.out.println("Item not found in this room.");
        }

        return itemTaken;
    }



    public Player () {




    }
    
}
