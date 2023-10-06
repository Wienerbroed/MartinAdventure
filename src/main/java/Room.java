import java.util.ArrayList;

public class Room {
    private String name;
    private String description;

    private Room neighbourNorth;
    private Room neighbourSouth;
    private Room neighbourEast;
    private Room neighbourWest;

    private ArrayList<Item> itemsInRoom  = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void setNeighbours(Room neighbourNorth, Room neighbourSouth, Room neighbourWest, Room neighbourEast) {
        this.neighbourEast = neighbourEast;
        this.neighbourNorth = neighbourNorth;
        this.neighbourSouth = neighbourSouth;
        this.neighbourWest = neighbourWest;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getNeighbourEast() {
        return neighbourEast;
    }

    public Room getNeighbourSouth() {
        return neighbourSouth;
    }

    public Room getNeighbourNorth() {
        return neighbourNorth;
    }

    public Room getNeighbourWest() {
        return neighbourWest;
    }

    public void addItemToRoom(Item item) {
        itemsInRoom.add(item);
    }


    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }
    public ArrayList<Item> getItemList() {
        return itemsInRoom;
    }

    public String getItem(String itemName) {
        for (Item item : itemsInRoom) {
            if (item.getType().equals(itemName)) {
                itemsInRoom.add(item);
            }
        }
        return null;
    }

    public Item findItem(String itemName) {
        for (Item item : itemsInRoom) {
            if (item.getType().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }


}
