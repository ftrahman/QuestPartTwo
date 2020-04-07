/*
 * Market: Represents the entire marketplace interaction.
 * 
 * private static void buy(Item selection): Allows hero to buy an object.
 * private static void sell(Item selection): Allows hero to sell an object.
 * public static void marketplace(): Entry method for the marketPlace;
 * private static void marketplaceHelper(): All of the interactions between user.
 * private static void separateTeam(Team team): Pulls apart the players so they can have their own inventories.
 * private static void menu(int i): Navigates the menu options. 
 */

import java.util.Scanner;

public class QuestOfLegendsMarket {
  private static boolean proceed = false;
  private static boolean check = false;
  private static boolean enterMarket = true;
  private static boolean again = true;
  private static boolean control = false;
  private static Scanner inputEnter = new Scanner(System.in);
  private static Scanner inputInt = new Scanner(System.in);
  private static Scanner newScanner = new Scanner(System.in);

  
  private static Hero currentHero;
  
  private static void buy(Item selection) {
    if(selection.minLevel <= currentHero.level) {
      if(currentHero.money - selection.price > 0) {
        currentHero.money = currentHero.money - selection.price;
        currentHero.curInventory.add(selection);
        
        
//        if(currentHero.currentWeapon == null && selection instanceof Weapon) {
//          currentHero.currentWeapon = (Weapon) selection;
//          currentHero.damage = (double) currentHero.currentWeapon.damage;
//        }
//        if(currentHero.currentPotion == null && selection instanceof Potion) {
//          currentHero.currentPotion = (Potion) selection;
//        }
//        if(currentHero.currentSpell == null && selection instanceof Spell) {
//          currentHero.currentSpell = (Spell) selection;
//        }
//        if(currentHero.currentArmor == null && selection instanceof Armor) {
//          currentHero.currentArmor = (Armor) selection;
//          currentHero.defense = (double) currentHero.currentArmor.defense;
//        }
        check = false;
        System.out.println("\nPlease see your updated inventory below.\n");
//        System.out.println(currentHero);
        currentHero.curInventory.display();
      }
      else {
        System.out.println("You don't have enough money to buy that.\n");
      }
      
    }
    else
      System.out.println("You don't have enough experience to buy that.\n");
  }
  
  private static void sell(Item selection) {
    currentHero.money = currentHero.money + (0.5 * selection.price);
    currentHero.curInventory.remove(selection);
    check = false;
    System.out.println("Please see your updated stats below.\n");
    System.out.println(currentHero);
    //System.out.println("Please see your updated inventory below.\n");
    currentHero.curInventory.display();
    
  }
  
  public static void marketplace(Hero inputHero) {
    proceed = false; enterMarket = true; 
    currentHero = inputHero;
    while(enterMarket) {
      marketplaceHelper();
    }
  }
  
  private static void marketplaceHelper() {
    TextFiles.MarketIntro();
    while(!proceed) {
      if(!inputEnter.nextLine().isEmpty()) {
        System.out.println("Press ENTER to begin.");
      }
      else proceed = true;
    }
    proceed = false;
    while(!proceed) {
      do {
        System.out.println("\n");
        System.out.println(AnsiColors.ANSI_ORANGE + "MAIN MENU \n " + AnsiColors.ANSI_RESET +
      " + Press" + AnsiColors.ANSI_ORANGE + " (B/b) " +  AnsiColors.ANSI_RESET + "to buy.  \n " + 
      " + Press" + AnsiColors.ANSI_ORANGE + " (S/s) " +  AnsiColors.ANSI_RESET + "to sell. \n " +
      " + Press" + AnsiColors.ANSI_ORANGE + " (I/i) " +  AnsiColors.ANSI_RESET + "to see your inventory. \n " +
      " + Press" + AnsiColors.ANSI_ORANGE + " (L/l) " +  AnsiColors.ANSI_RESET + "to see your stats.  \n " + 
      " + Press" + AnsiColors.ANSI_ORANGE + " (E/e) " +  AnsiColors.ANSI_RESET + "to equip your current hero. \n " + 
      " + Press" + AnsiColors.ANSI_ORANGE + " (C/c) " +  AnsiColors.ANSI_RESET + "to change heroes. \n " + 
      " + Press" + AnsiColors.ANSI_ORANGE + " (Q/q) " +  AnsiColors.ANSI_RESET + "to exit the Market.");
        System.out.println("\n");
        String input = inputEnter.nextLine();
        if(input.compareTo("b") == 0 || input.compareTo("B") == 0) {
          while(again) {
            TextFiles.Market();
            menu(inputInt.nextInt());
            System.out.println("\n");
            System.out.println("Would you like to buy another item for your Hero? Press (Y/y) for yes, any key for no.\n");
            String user = inputEnter.nextLine();
            if(user.compareTo("Y") == 0 || user.compareTo("y") == 0)
              continue;
            else 
              again = false;
          }
        }
        else if(input.compareTo("i") == 0 || input.compareTo("I") == 0) {
          System.out.println("\n");
          currentHero.curInventory.display(); again = true;
          System.out.println("\n");
        }
        else if(input.compareTo("l") == 0 || input.compareTo("L") == 0) {
          System.out.println(currentHero); again = true;
        }
        else if(input.compareTo("e") == 0 || input.compareTo("E") == 0) {
          currentHero.equip(); again = true;
        }
        else if(input.compareTo("s") == 0 || input.compareTo("S") == 0) {
          if(currentHero.curInventory.size() == 0) {
            System.out.println("\n You have no items to sell. \n"); again = true;
          }
          else {
            boolean valid = false;
            while(!valid) {
              currentHero.curInventory.display();
              System.out.println("\n Pick an item to sell. Press the number corresponding to the list order.");
              int sell = inputInt.nextInt() - 1;
              if(currentHero.curInventory.check(sell)) {
                sell(currentHero.curInventory.get(sell)); 
                valid = true;
              }
              else System.out.println("Try entering another number.");
            }
          }
        }
//        else if(input.compareTo("C") == 0 || input.compareTo("c") == 0) {
//          if(QuestGame.getTeamMembers().length == 1) {
//            System.out.println("You only have one Hero in your team.");
//            System.out.println("\n" + currentHero);
//          }
//          else {
//            if(changeMember() == true) {
//              separateTeam(QuestGame.getTeamMembers());
//              again = true;
//            }
//           // control = true;
//          }
//        }
        else if(input.compareTo("Q") == 0 || input.compareTo("q") == 0) {
         proceed = true; control = true;
        }
      }while(!control);
    }
    if(proceed) {
      enterMarket = false;
    }
  }
  
//  private static boolean changeMember() {
//    if(QuestGame.getTeamMembers().length == 1) return false;
//    System.out.println("Would you like to modify another Hero?");
//    System.out.println("\n");
//    String input = inputEnter.nextLine();
//    if(input.compareTo("Y") == 0 || input.compareTo("y") == 0) {
//      return true;
//    }
//    else
//      return false;
//  }
//  
//  private static void separateTeam(Team team) {
//    currentHero = (Hero) team.choosePlayer();
//  }
    
    private static void menu(int i) {
      if(i == 1) {
        TextFiles.Armory();
        do {
          int input = inputInt.nextInt();
          if(input > 0 && input < 7) {
            Item choice = new Armor(input);
            buy(choice);
            check = true;
          }
        }while(!check);
      }
      if(i == 2) {
        TextFiles.Weaponry();
        do {
          int input = inputInt.nextInt();
          if(input > 0 && input < 8) {
            Item choice = new Weapon(input);
            buy(choice);
            check = true;
          }
        }while(!check);
      }
      if(i == 3) {
        TextFiles.Potions();
        do {
          int input = inputInt.nextInt();
          if(input > 0 && input < 7) {
            Item choice = new Potion(input);
            buy(choice);
            check = true;
          }
        }while(!check);
      }
      if(i == 4) {
        TextFiles.SpellChoice();
        int menuChoice = inputInt.nextInt();
        while(!check) {
          if(menuChoice < 0 || menuChoice > 4) {
            System.out.println("Please enter 1-3 to choose a spell.");
          }
          else check = true;
        }
        check = false;
        if(menuChoice == 1) {
          TextFiles.IceSpells();
          do {
            int input = inputInt.nextInt();
            if(input > 0 && input < 7) {
              Item choice = new IceSpell(input);
              buy(choice);
              check = true;
            }
          }while(!check);
        }
        if(menuChoice == 2) {
          TextFiles.FireSpells();
          do {
            int input = inputInt.nextInt();
            if(input > 0 && input < 7) {
              Item choice = new FireSpell(input);
              buy(choice);
              check = true;
            }
          }while(!check);
        }
        if(menuChoice == 3) {
          TextFiles.LightningSpells();
          do {
            int input = inputInt.nextInt();
            if(input > 0 && input < 7) {
              Item choice = new LightningSpell(input);
              buy(choice);
              check = true;
            }
          }while(!check);
        }
      }
  }

}
