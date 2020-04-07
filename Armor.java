
/*
 * Armor: A subclass class of the parent class Item, that creates an instance of 1 of 6 types of Armor.
 * 
 * public Armor(int selection): A constructor that takes in a menu selection and instantiates it
 * private void setItem(int selection): A setter method to help initialize the new Armor object.
 * public void toString(): A printable form of the Armor object.
 */


public class Armor extends Item {
  int defense;
  
  public Armor(int selection) {
    super();
    setItem(selection);
  }
  
  private void setItem(int selection) {
    if(selection == 1) {
      name = "Platinum Shield"; minLevel = 1;
      defense = 200; price = 150;
    }
    else if(selection == 2) {
      name = "Breastplate"; minLevel = 3;
      defense = 600; price = 350;
    }
    else if(selection == 3) {
      name = "Gold Breastplate"; minLevel = 6;
      defense = 1000; price = 600;
    }
    else if(selection == 4) {
      name = "Full Body Armor"; minLevel = 8;
      defense = 1100; price = 1000;
    }
    else if(selection == 5) {
      name = "Wizard Shield"; minLevel = 10;
      defense = 1500; price = 1200;
    }
    else if(selection == 6) {
      name = "Speed Boots"; minLevel = 4;
      defense = 600; price = 550;
    }
  }
  
  public String toString() {
    return super.toString() + AnsiColors.ANSI_GREEN + " Defense: " + AnsiColors.ANSI_RESET + defense;
  }
}
