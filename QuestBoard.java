
/*
 * QuestBoard: A subclass of BoardRequirements, class that contains the game board for The Quest.
 * 
 * public Quest(int rows, int cols): A constructor requiring rows and columns to instantiate a board.
 * public abstract void setBoard(): Require all future Board games to set up the board.
 * public abstract void reset(): Require all future Board games to reset the board.
 * public static String stringMultiplication(String s): Helps to created the printed board. 
 * public abstract void printBoard(): Require all future Board games to have a print method.
 * public static Cell findRowColNumber(int cellNumber): Accessor method for cells on the board.
 * public static boolean moveUp(), public static boolean moveDown(), public static boolean moveRight(),
 *      public static boolean moveLeft(): All methods to helps determine the validity of a move.
 * public static void moveHero(String move, int position): Method to actually shift the position of the heroes. 
 */

import java.util.*;


public class QuestBoard extends BoardRequirements{
  
  private static double notAccessible = .2;
  private static double market = .3;
  private static double commonCell = .5;
  public static String newMarker;
  
  
  public QuestBoard(int rows, int cols){
    super(rows, cols);
    setBoard();
  }
  
  public void setBoard() {
    List<String> tiles = new ArrayList<>();
    for(int i = 0; i < GAME_AREA*market; i++) {
      tiles.add("M");
    }
    for(int i = 0; i < GAME_AREA*notAccessible; i++) {
      tiles.add("X");
    }
    for(int i = 0; i < GAME_AREA*commonCell; i++) {
      tiles.add(" ");
    }
    Collections.shuffle(tiles);
    for(int i = 0; i < GAME_ROWS; i++) {
      for(int j = 0; j < GAME_COLS; j++) {
          board[i][j].original = new Marker(tiles.get(i*GAME_ROWS + j));
          board[i][j].curMarker = board[i][j].original;
      }
    }
    board[GAME_ROWS - 1][GAME_COLS - 1].original = new Marker(" ");
    board[GAME_ROWS - 1][GAME_COLS - 1].curMarker = board[GAME_ROWS - 1][GAME_COLS - 1].temporaryHero;
    
  }
  
  // Allows players to play another game by clearing the board.
  public void reset() {
    setBoard();
  }
  
  public static String stringMultiplication(String s){
    StringBuilder ret = new StringBuilder();
    for(int i = 0; i < GAME_COLS; i++){
      ret.append(s);
    }
    return ret.toString();
}
  // Displays the board itself.
  public void printBoard(){
    System.out.println("Legend:");
    System.out.println(AnsiColors.ANSI_RED + "X ~ Not Accessible" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_YELLOW + "M ~ Market" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_CYAN + "H ~ Hero" + AnsiColors.ANSI_RESET);
    String boarder = stringMultiplication("+-----");
    System.out.print(boarder + "+ \n");
    for(int i = 0; i < GAME_ROWS; i++) {
      for(int j = 0; j < GAME_COLS; j++) {
        if(j == 0) {
          System.out.print("|  ");
        }
        System.out.print(board[i][j].curMarker.toString() + "  |  ");    
      }
      System.out.print("\n");
      System.out.print(boarder + "+\n");
    }
  }
  
  public static Cell findRowColNumber(int cellNumber) {
    for(int i = 0; i <  GAME_ROWS; i++) {
      for(int j = 0; j < GAME_COLS; j++) {
        if(board[i][j].id == cellNumber) {
          return board[i][j];
        }
      }
      }
    return null;
  }
  
 public static boolean moveUp() {
   int potentialMove = Team.position - GAME_ROWS;
   if(potentialMove < 0 || potentialMove > GAME_AREA + 1) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.id.compareTo("X") == 0)return false;
   else return true; 
 }
 
 public static boolean moveDown() {
   int potentialMove = Team.position + GAME_ROWS;
   if(potentialMove < 0 || potentialMove > GAME_AREA + 1) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.id.compareTo("X") == 0) return false;
   else return true; 
 }
 
 public static boolean moveRight() {
   int potentialMove = Team.position + 1;
   if(potentialMove % GAME_ROWS == 1) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.id.compareTo("X") == 0) return false;
   else return true; 
 }
 
 public static boolean moveLeft() {
   int potentialMove = Team.position - 1;
   if(potentialMove % GAME_ROWS == 0) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.id.compareTo("X") == 0) return false;
   else return true; 
 }

 public static void moveHero(String move, int position) {
   Cell revert = findRowColNumber(position);
   revert.curMarker = revert.original;

   if(move.compareTo("W") == 0 || move.compareTo("w") == 0) {
     Team.position = position - GAME_ROWS;
     Cell target = findRowColNumber(position - GAME_ROWS);
     target.curMarker = target.temporaryHero;
     newMarker = target.original.id;
     
   }
   else if(move.compareTo("A") == 0 || move.compareTo("a") == 0) {
     Team.position = position - 1;
     Cell target = findRowColNumber(position - 1);
     target.curMarker = target.temporaryHero;
     newMarker = target.original.id;
   }
   else if(move.compareTo("D") == 0 || move.compareTo("d") == 0) {
     Team.position = position + 1;
     Cell target = findRowColNumber(position + 1);
     target.curMarker = target.temporaryHero;
     newMarker = target.original.id;
   }
   else if(move.compareTo("S") == 0 || move.compareTo("s") == 0) {
     Team.position = position + GAME_ROWS;
     Cell target = findRowColNumber(position + GAME_ROWS);
     target.curMarker = target.temporaryHero;
     newMarker = target.original.id;
   }
  
 }
  
 
}
