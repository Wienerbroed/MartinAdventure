import java.util.ArrayList;

public class Room {
    private String name;
    private String description;

    private Room neighbourNorth;
    private Room neighbourSouth;
    private Room neighbourEast;
    private Room neighbourWest;

    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private ArrayList<Consumable> consumablesInRoom = new ArrayList<>();
    private ArrayList<Melee> meleeWeaponsInRoom = new ArrayList<>();
    private ArrayList<Range> rangeWeaponsInRoom = new ArrayList<>();

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


    public void addConsumable(Consumable consumable) {
        consumablesInRoom.add(consumable);
    }

    public ArrayList<Consumable> getConsumablesInRoom() {
        return consumablesInRoom;
    }

    public Consumable findConsumable(String itemName) {
        for (Consumable consumable : consumablesInRoom) {
            if (consumable.getType().equalsIgnoreCase(itemName)) {
                return consumable;
            }
        }
        return null;
    }
    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }

    public void removeConsumable(Consumable consumable) {
        consumablesInRoom.remove(consumable);
    }

    public ArrayList<Melee> getMeleeWeaponsInRoom() {
        return meleeWeaponsInRoom;
    }

    public void addMeleeWeapon(Melee meleeWeapon) {
        meleeWeaponsInRoom.add(meleeWeapon);
    }
    public Melee findMeleeWeapon(String itemName) {
        for (Melee meleeWeapon : meleeWeaponsInRoom) {
            if (meleeWeapon.getType().equalsIgnoreCase(itemName)) {
                return meleeWeapon;
            }
        }
        return null;
    }

    public void removeMeleeWeapon(Melee meleeWeapon) {
        meleeWeaponsInRoom.remove(meleeWeapon);
    }
    public Range findRangeWeapon(String itemName) {
        for (Range rangeWeapon : rangeWeaponsInRoom) {
            if (rangeWeapon.getType().equalsIgnoreCase(itemName)) {
                return rangeWeapon;
            }
        }
        return null;
    }

    public void removeRangeWeapon(Range rangeWeapon) {
        rangeWeaponsInRoom.remove(rangeWeapon);
    }
}



