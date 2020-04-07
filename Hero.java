/*
 * Hero: An abstract class, that is a subclass of Player, that contains the requirements for a Quest Hero.
 * 
 * public Hero(): Initialize all heroes using the super constructor.
 * void calculateMana(): Getter method to calculate mana.
 * void calculateDamage(): Getter method to calculate damage with a weapon.
 * void calculateDodge(): Getter method to calculate the dodge chance.
 * void calculateGoalXP(): Getter method for goal XP.
 * void setCurrentWeapon(Weapon current): Setter for weapon.
 * void setCurrentArmor(Armor current): Setter for armor.
 * public void changeArmor(): Allows to go through inventory and assign new weapons.
 * private String weaponString(): Helper method to get Weapon.
 * private String armorString(): Helper method to get Armor.
 * private String potionString(): Helper method to get Potion.
 * private String spellString(): Helper method to get Spell.
 * 
 */

import java.util.Scanner;

abstract class Hero extends Player {
  double strength; 
  double dexterity; 
  double agility; 
  double money;
  int currentXP;
  int goalXP;
  double damage;
  double dodge;
  double defense;
  double currentMana;
  Weapon currentWeapon;
  Spell currentSpell;
  Potion currentPotion;
  Armor currentArmor;
  Inventory curInventory = new Inventory();
  Scanner input = new Scanner(System.in);
  Scanner input2 = new Scanner(System.in);
  boolean replace = false;
  
  
  
  public Hero(){
    super();
    currentWeapon = null; currentArmor = null;
    currentPotion = null; currentSpell = null;
  }
  
  void calculateMana() {
    currentMana = currentMana + (currentMana*0.1);
  }
  
  void calculateDamage() {
    damage = (strength + currentWeapon.damage)*0.05;
  }
  
  void calculateDodge() {
    dodge = agility*0.02;
  }
  
  void calculateGoalXP() {
    goalXP = level * 10;
  }
  
  void setCurrentWeapon(Weapon current) {
    currentWeapon = current;
  }
  void setCurrentArmor(Armor current) {
    currentArmor = current;
  }
  
  public void equip() {
    replace = false;
    do {
      if(curInventory.size() == 0)  {
        System.out.println("\n");
        System.out.println("You don't have anything in your inventory.");
        replace = true;
      }
      System.out.println("Press Y/y to equip your hero. Press Q/q to exit. \n");
      String user = input.nextLine();
      if(user.compareTo("Q") == 0 || user.compareTo("q") == 0) {
        replace = true;
      }
      if(user.compareTo("Y") == 0 || user.compareTo("y") == 0) {
          int selection = 0;
          System.out.println("Please select a weapon from your inventory below:\n");
          curInventory.display();
          boolean check = false;
          while(!check) {
            selection = input.nextInt(); 
            if(selection - 1 > curInventory.size()) {
              System.out.println("That was not a valid number. Try again.");
            }
            else check = true;
          } 
          Item temp = curInventory.get(selection - 1);
          if(temp instanceof Armor) {
            currentArmor =  (Armor) curInventory.get(selection - 1);
            defense = currentArmor.defense;
            System.out.println("You changed your armor to " + currentArmor.name);
          }
          if(temp instanceof Weapon) {
            currentWeapon =  (Weapon) curInventory.get(selection - 1);
            damage = currentWeapon.damage;
            currentSpell = null;
            currentPotion = null;
            System.out.println("You changed your weapon to " + currentWeapon.name);
            }
          if(temp instanceof Spell) {
            currentSpell =  (Spell) curInventory.get(selection - 1);
            damage = currentSpell.calculateDamage(this);
            currentPotion = null;
            currentWeapon = null;
            System.out.println("You changed your weapon to the spell " + currentSpell.name);
            }
          if(temp instanceof Potion) {
            currentPotion =  (Potion) curInventory.get(selection - 1);
            currentSpell = null;
            currentWeapon = null;
            System.out.println("You have consumed " + currentPotion.name);
            Potion.typeOfPotion(currentPotion, this);
            curInventory.remove(currentPotion);
            }
          System.out.println("Do you want to equip another item? Press Y/y to equip, and any key to exit.");
          String again = input2.nextLine();
          if(again.compareTo("Y") == 0 || again.compareTo("y") == 0) continue;
          else replace = true;
      }  
      else System.out.println("Please enter Y/y or Q/q.");
      }while(!replace);

  }
  
  
  
  public String toString() {

    //String.format("%-15s %15s %n", "Name", "HP", "Level", "Mana", "Strength", "Dexterity", "Agility", "Money", "Damage", "XP"); 
    return 
        AnsiColors.ANSI_GREEN + "Name: " + AnsiColors.ANSI_RESET + name + AnsiColors.ANSI_GREEN + " HP: " 
      + AnsiColors.ANSI_RESET + HP +  AnsiColors.ANSI_GREEN + " Level: " +  AnsiColors.ANSI_RESET + level + 
        AnsiColors.ANSI_GREEN + " Mana: " +  AnsiColors.ANSI_RESET + currentMana + AnsiColors.ANSI_GREEN + " Strength: " +  
        AnsiColors.ANSI_RESET + strength +  AnsiColors.ANSI_GREEN + " Dexterity: "+   AnsiColors.ANSI_RESET + dexterity +  
        AnsiColors.ANSI_GREEN + " Agility: " +  AnsiColors.ANSI_RESET + agility +  AnsiColors.ANSI_GREEN + " Money: " +  AnsiColors.ANSI_RESET + money +  
        AnsiColors.ANSI_GREEN + " Damage: " +  AnsiColors.ANSI_RESET + damage +  
        AnsiColors.ANSI_GREEN + " Defense: " +  AnsiColors.ANSI_RESET + defense +
        AnsiColors.ANSI_GREEN + " Dodge: " +  AnsiColors.ANSI_RESET + dodge +
        AnsiColors.ANSI_GREEN + " XP: " +  AnsiColors.ANSI_RESET +  
      + currentXP + ".\n";
//        AnsiColors.ANSI_CYAN + name + AnsiColors.ANSI_RESET + "\t" 
//        + HP + "\t\t" + level + "" + currentMana + "\t" + 
//        "\t" + strength + "\t"+ dexterity + "\t" + 
//        agility + "\t" + money + "\t\t" + damage + "\t" +
//        currentXP + "\t\t\n"
//        + "You currently have " + weaponString() + ", " + potionString() + ", " 
//        + spellString() + ", and " + armorString() + "\n";
  }
  

  
}
