package bcit;

import java.util.Scanner;

enum ClassEnum {
    WARRIOR, MAGE, RANGER,
}

class PlayerStructure {
    String name;
    int health;
    int mana;
    int attack;
    int defense;
    double critRate;
    boolean autopilot;
    
    int playersCreated = 0; // Used in NewPlayer function

    PlayerStructure newPlayer(ClassEnum typeClass, String   name) {
        PlayerStructure tempPlayer = new PlayerStructure();

        if (playersCreated == 0) {
            tempPlayer.autopilot = true;
        } else {
            tempPlayer.autopilot = false;
        }
        playersCreated++;

        switch (typeClass) {
        case WARRIOR:
            health = 30;
            mana = 0;
            attack = 5;
            defense = 3;
            critRate = 0.5;
            this.name = name; // This will change the name outside of this function
            break;
        default:
            health = 10;
            mana = 0;
            attack = 3;
            defense = 0;
            critRate = 0.1;
            break;
        }
        
        tempPlayer.name = name; // This will not change the Hero name outside of this function.
        System.out.println("In the end of NewPlayer: " + tempPlayer.name); // Delete after resolved
        return tempPlayer;
    }
}

class DisplayMenu {
    class MainMenu {
        String menu = "(0) Exit\t" + "(1) Stats\t" + "(2) Inventory\t" + "(3) Rest\t" + "(4) Explore\t" + "(5) Shop\t"
                + "(6) Casino\n>> ";
    }

    class AttackMenu {
        String menu = "(1) Attack\t(2) Run\t\t(3) Use Hp Pot";
    }
    
    void DisplayStats(PlayerStructure target) {
        System.out.println("In DisplayStats: " + target.name + "\nHealth: " + target.health + "\tMana: " + target.mana 
                + "\t\tCrit rate: " + target.critRate * 100 + "%\tAttack: " + target.attack + "\tDefense: " 
                + target.defense + "\n------------------------------------------");
    }
}

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 1;
        System.out.println("Welcome to ConsoleRPG");
        DisplayMenu displayMenu = new DisplayMenu();
        DisplayMenu.MainMenu mainMenu = displayMenu.new MainMenu();

        // Game Loop
        while (choice != 0) {
            System.out.print(mainMenu.menu);
            choice = scan.nextInt();
            PlayerStructure Hero = new PlayerStructure();
            
           Hero.newPlayer(ClassEnum.WARRIOR, "Sir Samuel");
           System.out.println("In main: " + Hero.name); // delete after resolved

            switch (choice) {
            case 0:
                printf("Exiting");
                break;
            case 1:
                printf("--------------Character stats--------------\n");
                    displayMenu.DisplayStats(Hero);
                break;

            }
            
        }
        scan.close();
    }

    // lol
    private static void printf(String string) {
        System.out.print(string);
    }
}
