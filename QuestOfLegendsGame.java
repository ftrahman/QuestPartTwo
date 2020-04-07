
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


public class QuestOfLegendsGame extends QuestGame implements GameRequirements, TeamsAllowed {
  

  private static boolean proceed = false;
  private static boolean continuePlay = false;
  private static int counter;
  public static Team teamMembers;
  public static MonsterTeam enemyMembers = new MonsterTeam(3);
  public static QuestOfLegendsBoard gameBoard;
  static Scanner inputInts = new Scanner(System.in);
  static Scanner inputEnter = new Scanner(System.in);
  private static boolean gameOver = false;
  
  public QuestOfLegendsGame() {
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
    TextFiles.FairyQL();
    if(!proceed) setTeamMembers(3);
    proceed = false;
    assignTeamMembers();
    System.out.println("\n");
    gameBoard = new QuestOfLegendsBoard(8,8);
    gameBoard.printBoard();
    System.out.println("\n");
    initializePosition();
    gameBoard.printBoard();
    System.out.println("\n");
    System.out.println("Great! Now we're ready to play!");
    TextFiles.WizardQL();
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
    enemyMembers.assignEnemies();
    gameBoard.printBoard();
    System.out.println("\n");
    System.out.println("Your enemies have spawned on the board!\n Press ENTER to continue."); //Press A/W/S/D to move. \n"
    String move = "";
    boolean temp = false;
    while(!temp) {
      if(!inputEnter.nextLine().isEmpty()) {
        System.out.println("Press ENTER to begin.");
      }
      else temp = true;
    }
    System.out.println("\n");
    while(!continuePlay) {
      for(int i = 0; i < teamMembers.length; i++) {
        Hero curHero = teamMembers.getPlayer(i);
        if(Team.getPlayerPosition(curHero.position).compareTo("N") == 0) {
          QuestOfLegendsMarket.marketplace(curHero);
          gameBoard.printBoard();
        }
        System.out.println("\nPress A/W/S/D to move. \nPress B/b to go back to Nexus.\n "
            + "Press I/i to see stats and inventory. \nPress Q/q to quit the game.\n");
        move = inputEnter.next();
        if(validMove(move, curHero)) {
          QuestOfLegendsBoard.moveHero(move, curHero.position, curHero);
          Cell getType = Team.getPlayerPosition(curHero.position);
          if (getType.original.compareTo("N") == 0) {
            Market.marketplace();
            gameBoard.printBoard();
          }
          // Fight stuff needs to go here
          
          else if (getType.original.compareTo(" ") == 0) {
            gameBoard.printBoard();
          }
  //          Random rand = new Random();
  //          boolean fightMonsters = rand.nextInt(100) < FIGHT_CHANCE;
  //          if(fightMonsters) {
  //            Fight fight = new Fight(teamMembers);
  //            gameBoard.printBoard();
  //          }
//            else {
//              gameBoard.printBoard();
//            }
          
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
  
  public void initializePosition() {
    System.out.println("Please choose a starting lane for your first hero (1/2).\n");
    int input = 0; boolean go = false;
    while(!go) {
      input = inputInts.nextInt();
      if (input == 1 || input == 2) {
        getTeamMembers().startingPosition(input);
        go = true;
      }
      else System.out.println("That was an invalid number. Try again. \n");
    }
    gameBoard.printBoard();
    System.out.println("Please choose a starting lane for your second hero (3/4).\n");
    go = false;
    while(!go) {
      input = inputInts.nextInt();
      if (input == 3 || input == 4) {
        getTeamMembers().startingPosition(input);
        go = true;
      }
      else System.out.println("That was an invalid number. Try again.\n");
    }
    gameBoard.printBoard();
    System.out.println("Please choose a starting lane for your second hero (5/6).\n");
    go = false;
    while(!go) {
      input = inputInts.nextInt();
      if (input == 5 || input == 6) {
        getTeamMembers().startingPosition(input);
        go = true;
      }
      else System.out.println("That was an invalid number. Try again.\n");
    }
  }
  
  public void setTeamMembers(int input) {
      proceed = true;
      teamMembers = new Team(3); counter = 3;
  }
  
  public boolean validMove(String move, Hero curHero) {
    if(move.compareTo("W") == 0 || move.compareTo("w") == 0) {
      return QuestOfLegendsBoard.moveUp(curHero);
    }
    else if(move.compareTo("A") == 0 || move.compareTo("a") == 0) {
      return QuestOfLegendsBoard.moveLeft(curHero);
    }
    else if(move.compareTo("D") == 0 || move.compareTo("d") == 0) {
      return QuestOfLegendsBoard.moveRight(curHero);
    }
    else if(move.compareTo("S") == 0 || move.compareTo("s") == 0) {
      return QuestOfLegendsBoard.moveDown(curHero);
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




 
  
}
