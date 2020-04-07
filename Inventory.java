
/*
 * Inventory: A class to maintain a hero's objects. 
 * 
 * public Inventory(): Initizalize using an arraylist.
 * public void add(Item selection): Add an Item to the inventory.
 * public static Item get(int index): A getter method for an Item in the inventory.
 * public static boolean check(int index): A contains methods for inventory.
 * public void display(): Help to display the contents of the arrayList.
 * private static void displayHelper(): Helper method for the former method.
 * public void remove(Item selection): Remove an Item from the inventory.
 * public int size(): Allows us to quickly size the array.
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
  List<Item> inventory; //= new ArrayList<>();
  
  public Inventory() {
    inventory = new ArrayList<Item>(); 
  }

  public void add(Item selection) {
    inventory.add(selection);
  }
  
  public Item get(int index) {
    return inventory.get(index);
  }
  
  public boolean check(int index) {
    if(inventory.get(index) == null) {
      return false;
    }
    return true;
  }
  
  public void display() {
    if(inventory.size() == 0) {
      System.out.println("Nothing in our inventory yet.\n");
    }
    else displayHelper();
  }
  
  private void displayHelper() {
    System.out.println(AnsiColors.ANSI_PURPLE + "Inventory");
    for(int i = 0; i < size(); i++) {
      if(inventory.get(i) instanceof Spell) {
      System.out.println((Spell)inventory.get(i));
      }
      if(inventory.get(i) instanceof Weapon) {
        System.out.println((Weapon)inventory.get(i));
      }
      if(inventory.get(i) instanceof Potion) {
        System.out.println((Potion)inventory.get(i));
      }
      if(inventory.get(i) instanceof Armor) {
        System.out.println((Armor)inventory.get(i));
      }
    }
  }
  


  public void remove(Item selection) {
    inventory.remove(selection);
  }


  public int size() {
    return inventory.size();
  }
}
