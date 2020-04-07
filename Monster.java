/*
 * Monster: An abstract class that extends Player, and defines a Monster object.
 * 
 * public Monster(): Call to the super constructor Player.
 * public String toString(): Provide a string representation of the Monster object.
 */


import java.util.ArrayList;
import java.util.List;


abstract class Monster extends Player {
  double damage;
  double defense;
  double dodge;
  
  Monster(){
    super();
  }
  
  public String toString() {
    return AnsiColors.ANSI_GREEN + "Name: " + AnsiColors.ANSI_RESET + name + AnsiColors.ANSI_GREEN + " HP: " 
      + AnsiColors.ANSI_RESET + HP +  AnsiColors.ANSI_GREEN + " Level: " +  AnsiColors.ANSI_RESET + level + 
        AnsiColors.ANSI_GREEN + " Damage: " +  AnsiColors.ANSI_RESET + damage + AnsiColors.ANSI_GREEN + " Defense: " +  
        AnsiColors.ANSI_RESET + defense + AnsiColors.ANSI_GREEN + " Dodge: " + AnsiColors.ANSI_RESET + dodge;
      }
  
}
