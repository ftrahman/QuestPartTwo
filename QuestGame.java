
/*
 * 
 * QuestGame: A class that implements the actual gameplay of The Quest.
 * 
 * public QuestGame(): Simply calls the setter method for the game.
 * void setUpGame(): Require all future games to have a set up procedure.
 * void startPlay(): Require all future games to have a start play method to begin the game.
 * boolean validMove(): Require all games to check for move validity.
 * public void assignTeamMembers() : Help to assign the team members for play.
 * public void gameInfo(String move): Shows the informational aspects of the game (stats/inventory). 
 * public static Team getTeamMembers(): Getter method for the team members.
 * public void setTeamMembers(int input): Setter method for the team members.
 * 
 * 
 */

import java.util.Random;
import java.util.Scanner;


public class QuestGame implements GameRequirements, TeamsAllowed {
  
  private static final int FIGHT_CHANCE = 75;
  private static boolean proceed = false;
  private static boolean continuePlay = false;
  private static int counter;
  public static Team teamMembers;
  public static QuestBoard gameBoard;
  static Scanner inputInts = new Scanner(System.in);
  static Scanner inputEnter = new Scanner(System.in);
  private static boolean gameOver = false;
  
  public QuestGame() {
    setUpGame();
  }
  
  public void setUpGame() {
    TextFiles.Intro();
    while(!proceed) {
      if(!inputEnter.nextLine().isEmpty()) {
        System.out.println("Press ENTER to begin.");
      }
      else proceed = true;
    }
    proceed = false;
    TextFiles.Fairy();
    int numTeam = inputInts.nextInt();
    if(!proceed) setTeamMembers(numTeam);
    proceed = false;
    assignTeamMembers();
    System.out.println("\n");
    System.out.println("Great! Now we're ready to play!");
    TextFiles.Wizard();
    System.out.println("         Press ENTER to begin.");
    while(!proceed) {
      if(!inputEnter.nextLine().isEmpty()) {
        System.out.println("         Press ENTER to begin.");
      }
      else 
        while(!gameOver)
          startPlay();
    }
    
  }
  
  
  public void startPlay() {
    String move = "";
    gameBoard = new QuestBoard(8,8);
    gameBoard.printBoard();
    System.out.println("\n");
    System.out.println("You spawned on the board! Please use the A/W/S/D keys to move your Heroes. Press R/r to reset your board if you are blocked in. Press I/i for information and Q/q to quit.\n");
    while(!continuePlay) {
      move = inputEnter.next();
      if(move.compareTo("R") == 0 || move.compareTo("r") == 0) {
        gameBoard = new QuestBoard(8,8);
        gameBoard.printBoard();
      }
      else if(validMove(move)) {
        QuestBoard.moveHero(move, Team.position);
        if (QuestBoard.newMarker.compareTo("M") == 0) {
          Market.marketplace();
          gameBoard.printBoard();
        }
        else if (QuestBoard.newMarker.compareTo(" ") == 0) {
          Random rand = new Random();
          boolean fightMonsters = rand.nextInt(100) < FIGHT_CHANCE;
          if(fightMonsters) {
            Fight fight = new Fight(teamMembers);
            gameBoard.printBoard();
          }
          else {
            gameBoard.printBoard();
          }
        }
      }
      else if(move.compareTo("I") == 0 || move.compareTo("i") == 0 ||
              move.compareTo("Q") == 0 || move.compareTo("q") == 0) {
        gameInfo(move);
        
      }
      else {
        gameBoard.printBoard();
        System.out.println("Sorry, that wasn't a valid move. Please use the A/W/S/D keys.");
      }
    }
  }
  
  public void assignTeamMembers() {
    while(counter != 0) {
      TextFiles.Heroes();
      int heroType = inputInts.nextInt();
      if(heroType == 1) {
        TextFiles.Paladins();
        getTeamMembers().assignPaladin(inputInts.nextInt());
        counter--;
      }
      else if(heroType == 2) {
        TextFiles.Warriors();
        getTeamMembers().assignWarrior(inputInts.nextInt());
        counter--;
      }
      else if(heroType == 3) {
        TextFiles.Sorcerers();
        getTeamMembers().assignSorcerer(inputInts.nextInt());
        counter--;
      }
      
    }
  }
  
  public void setTeamMembers(int input) {
    if(input <= 3 && input > 0) {
      proceed = true;
      if(input == 1) {
        teamMembers = new Team(1); counter = 1;
      }
      else if(input == 2) {
        teamMembers = new Team(2); counter = 2;
      }
      else if(input == 3) {
        teamMembers = new Team(3); counter = 3;
      }
    }
    else System.out.println("Sorry, that was incorrect input. Please re-enter a number.");
  }
  
  public boolean validMove(String move) {
    if(move.compareTo("W") == 0 || move.compareTo("w") == 0) {
      return QuestBoard.moveUp();
    }
    else if(move.compareTo("A") == 0 || move.compareTo("a") == 0) {
      return QuestBoard.moveLeft();
    }
    else if(move.compareTo("D") == 0 || move.compareTo("d") == 0) {
      return QuestBoard.moveRight();
    }
    else if(move.compareTo("S") == 0 || move.compareTo("s") == 0) {
      return QuestBoard.moveDown();
    }
    return false;
  }
  
  public void gameInfo(String move) {
    if(move.compareTo("I") == 0 || move.compareTo("i") == 0) {
      for(int i = 0; i < teamMembers.length; i++) {
        System.out.println(Team.team[i]);
        Team.team[i].curInventory.display();
      }
    }
    if(move.compareTo("Q") == 0 || move.compareTo("q") == 0) {
       gameOver = true;
    }
  }

  public static Team getTeamMembers() {
    return teamMembers;
  }

  @Override
  public void initializePosition() {
    
  }




 
  
}
