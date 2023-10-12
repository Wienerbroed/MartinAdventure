import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private  Adventure adventure = new Adventure();
    private Map map = new Map();
    private Player player = new Player();

    private Scanner input = new Scanner(System.in);
    private boolean gameRunning = true;





public void startgame() {
    System.out.println("""
            Hello and Welcome to your new adventure!
            You have been tasked with locating and retrieving 'The Magical Chalice of Eternal Riches'.
            To do this you have been sent to an abandoned farm, which is rumored to house a despicable monster.
            You have been given no items and are expected to gather equipment, for this adventure by yourself.""");
    while (gameRunning) {
        String userInput = input.nextLine().toLowerCase();
        switch (userInput) {
            case "help":
            case "info":
                System.out.println("If you want to got North enter 'North', 'Go North' or 'N' the same rule for East, West and South.");
            case "go north":
            case "north":
            case "n":
                boolean goNorth = adventure.player.goNorth();
                roomDirection(goNorth);
                break;
            case "go south":
            case "south":
            case "s":
                boolean goSouth = adventure.player.goSouth();
                roomDirection(goSouth);
                break;
            case "go east":
            case "east":
            case "e":
                boolean goEast = adventure.player.goEast();
                roomDirection(goEast);
                break;
            case "go west":
            case "west":
            case "w":
                boolean goWest = adventure.player.goWest();
                roomDirection(goWest);
                break;
            case "inventory":
            case "inv":
            case "invent":
                showPlayerItems();
                break;
            case "look":
                lookForItems();
                break;
            case "take":
                System.out.println("Please enter the name of the item you want to take.");
                String itemToTake = input.nextLine().toLowerCase();

                if (adventure.player.takeItem(itemToTake)) {
                    System.out.println("Item added to inventory.");
                } else {
                    System.out.println("Item was not found in this room.");
                }
                break;
            case "drop":
                System.out.println("Please enter the name of the item you want to drop");
                String itemDrop = input.nextLine().toLowerCase();
                if (adventure.player.dropItem(itemDrop) == true) {
                    System.out.println("Item removed from inventory");
                } else {
                    System.out.println("Item was not found in your inventory");
                }
            case "use":
                System.out.println("Please enter the name of the healing item you want to use.");
                String itemToUse = input.nextLine().toLowerCase();
                Consumable healingItem = adventure.player.findHealingItem(itemToUse);

                if (healingItem != null) {
                    adventure.player.useHealingItem(healingItem);
                } else {
                    System.out.println("Item not found in your inventory.");
                }
                break;
            case "consume":
                System.out.println("Please enter the name of the healing item you want to consume.");
                String itemToConsume = input.nextLine().toLowerCase();
                adventure.player.consumeItem(itemToConsume);
                break;
            case "equip":
                System.out.println("Please enter the name of the weapon you want to equip.");
                String itemToEquip = input.nextLine().toLowerCase();
                player.equipWeapon(itemToEquip);
                break;


            case "quit":
            case "exit":
                gameRunning = false;
                System.out.println("Thank you for playing. Goodbye!");
                break;
            default:
                System.out.println("Invalid command. Please enter a valid direction or command.");
                break;
        }


    }



}
    public void lookForItems() {
        Room currentRoom = adventure.player.getCurrentRoom();
        ArrayList<Item> itemsInRoom = currentRoom.getItemsInRoom();
        ArrayList<Melee> meleeWeaponsInRoom = currentRoom.getMeleeWeaponsInRoom();

        if (itemsInRoom.isEmpty() && meleeWeaponsInRoom.isEmpty()) {
            System.out.println("You don't see any items in this room.");
        } else {
            System.out.println("You see the following items in this room:");
            for (Item item : currentRoom.getItemList()) {
                System.out.println(item.getType() + "\n" + item.getDescription() + "\n" + item.getFunction() + "\n");
            }

            for (Melee meleeWeapon : meleeWeaponsInRoom) {
                System.out.println(meleeWeapon.getType() + "\n" + meleeWeapon.getDescription() + "\n" + meleeWeapon.getFunction());
            }
        }
    }

    public void showPlayerItems() {
        if (adventure.player.getInventoryList().isEmpty()) {
            System.out.println("Inventory is empty");
        }
        for (Item item : adventure.player.getInventoryList()) {
            System.out.println(item.getType());
        }
    }

public void roomDirection(boolean goDirection) {
    if(goDirection) {
        System.out.println("You are going to " + adventure.player.getCurrentRoom().getName());



}

}}
