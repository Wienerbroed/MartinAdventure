public class Map {
    Room room1 = new Room("Entrance", "A dark and dusty hallway.");
    Room room2 = new Room("Kitchen", "You're surrounded by old pans and the smell of rotten food.");
    Room room3 = new Room("Living room", "You find yourself in a ruined room with cracks in the wall and broken furniture");
    Room room4 = new Room("Basement", "A creepy room filled with insects and torn fabric.");

    public Map() {
        adventureMap();
        room1.addItemToRoom(new Item("Old pot","Cookware","Cooks meat"));
        room1.addConsumable(new Consumable("Burrito", "food", "Heal", 10));

    }


    public void adventureMap () {
        room1.setNeighbours(room2, null, null, null);
        room2.setNeighbours(null, room1, room3, null);
        room3.setNeighbours(room4, null, null, room2);
        room4.setNeighbours(null, room3, null, null);


    }
    public Room getStarterRoom(){
        return room1;
    }



}

