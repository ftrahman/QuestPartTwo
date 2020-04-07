
/*
 * Team: Allows us to create a Team object out of a group of Players.
 * 
 * 
 * public void assignWarrior(int selection), public void assignSorcerer(int selection),
 *      public void assignPaladin(int selection): All team setter methods. 
 * public Player getPlayer(int index): Getter method.
 * public String toString(): String representation.
 * public Player choosePlayer(): Select a player. 
 */

import java.util.List;
import java.util.Scanner;

public class Team {
  public static Hero[] team = null;
  public int length;
  private boolean setUp = false;
  public boolean allDown = false;
  public String newMarker;
  public static int position = 64;
  private static Scanner inputEnter = new Scanner(System.in);
  
  
  public Team(int length) {
    team = new Hero[length];
    this.length = length;
  }
  
  public void assignPaladin(int selection) {
    setUp = false;
    while(!setUp) {
      for(int i = 0; i < length; i++) {
        if(team[i] == null) {
          team[i] = new Paladin(selection);
          team[i].nickname = "H" + i;
          setUp = true;
          System.out.println("Your #" + (i + 1) + " Hero is " + team[i].name);
          break;
        }
      }
    }
  }
  
  public void assignWarrior(int selection) {
    setUp = false;
    while(!setUp) {
      for(int i = 0; i < length; i++) {
        if(team[i] == null) {
          team[i] = new Warrior(selection);
          team[i].nickname = "H" + i;
          setUp = true;
          System.out.println("Your #" + (i + 1) + " Hero is " + team[i].name);
          break;
        }
      }
    }
  }
  
  public void assignSorcerer(int selection) {
    setUp = false;
    while(!setUp) {
      for(int i = 0; i < length; i++) {
        if(team[i] == null) {
          team[i] = new Sorcerer(selection);
          team[i].nickname = "H" + i;
          setUp = true;
          System.out.println("Your #" + (i + 1) + " Hero is " + team[i].name); 
          break;
        }
      }
    }
  }
  
  public void startingPosition(int input) {
    Cell target = null;
    if(input == 1) {
      team[0].position = 57;
      team[0].startingPosition = 57;
      target = QuestOfLegendsBoard.findRowColNumber(team[0].position);
    }
    if(input == 2) {
      team[0].position = 58;
      team[0].startingPosition = 58;
      target = QuestOfLegendsBoard.findRowColNumber(team[0].position);
    }
    if(input == 3) {
      team[1].position = 60;
      team[1].startingPosition = 60;
      target = QuestOfLegendsBoard.findRowColNumber(team[1].position);
    }
    if(input == 4) {
      team[1].position = 61;
      team[1].startingPosition = 61;
      target = QuestOfLegendsBoard.findRowColNumber(team[1].position);
    }
    if(input == 5) {
      team[2].position = 63;
      team[2].startingPosition = 63;
      target = QuestOfLegendsBoard.findRowColNumber(team[2].position);
    }
    if(input == 6) {
      team[2].position = 64;
      team[2].startingPosition = 64;
      target = QuestOfLegendsBoard.findRowColNumber(team[2].position);
    }
    System.out.println(target.id);
    target.curMarker = target.temporaryHero;
    newMarker = target.original.id;
  }
  
  public Hero getPlayer(int index) {
    return team[index];
  }
  
  public static Cell getPlayerPosition(int position) {
    Cell locateHero = QuestOfLegendsBoard.findRowColNumber(position);
    return locateHero;
  }
  
  public Player choosePlayer() {
    if (length == 1) {
      return (Hero) getPlayer(0);
    }
    boolean temp = false;
    System.out.println("Please pick a hero to modify. Press the number corresponding to the list order.");
    toString();
    
    int input = inputEnter.nextInt();
    while(!temp) {
      if(input < 0 || input > 3) {
        System.out.println("Please enter a number between 1-3.");
      }
      else temp = true;
    }
    Hero chosen = getPlayer(input-1);
    return chosen;
  }
  
  public String toString() {
    for(int i = 0; i < team.length; i++) {
      if(team[i] != null)
        System.out.println("\n");
        System.out.println(team[i].toString());
        if(team[i].curInventory == null) System.out.println("There are no items in your inventory. \n");
        else team[i].curInventory.display();
    }
    return null;
  }
  
  
  
  
  
}
