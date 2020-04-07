
import java.util.*;


public class QuestOfLegendsBoard extends BoardRequirements{
  
  private static double koulou = .1;
  private static double cave = .1;
  private static double bush = .1;
  private static double plain = .7;
  private static double PERMANENT_CELLS = 28;
  public static String newMarker;
  
  
  public QuestOfLegendsBoard(int rows, int cols){
    super(rows, cols);
    setBoard();
  }
  
  public void setBoard() {
    List<String> tiles = new ArrayList<>();
    for(int i = 0; i < (GAME_AREA - PERMANENT_CELLS) * koulou; i++) {
      tiles.add("K");
    }
    for(int i = 0; i < (GAME_AREA - PERMANENT_CELLS) * cave; i++) {
      tiles.add("C");
    }
    for(int i = 0; i < (GAME_AREA - PERMANENT_CELLS) * bush; i++) {
      tiles.add("B");
    }
    for(int i = 0; i < (GAME_AREA - PERMANENT_CELLS) * plain; i++) {
      tiles.add("P");
    }
    int laneOne = 2; int laneTwo = 5;
    Collections.shuffle(tiles);
    for(int i = 0; i < GAME_ROWS; i++) {
      for(int j = 0; j < GAME_COLS; j++) {
        board[i][j].curMarker = new Marker(" ");
        board[i][j].original = new Marker(" ");
        if(board[i][j].id - 1 == laneOne) {
          board[i][j].type = "I"; laneOne += 8;
          board[i][j].curMarker = new Marker("X");
        }
        else if(board[i][j].id - 1 == laneTwo) {
          board[i][j].type = "I"; laneTwo += 8;
          board[i][j].curMarker = new Marker("X");
        }
        else if(i == 0) {
           board[i][j].type = "N";
           board[i][j].original = new Marker("N");
        }
        else if(i == 7) {
          board[i][j].type = "N";
          board[i][j].original = new Marker("N");
        }
        else {
          board[i][j].type = tiles.get(0);
          tiles.remove(0);
        }
//          board[i][j].curMarker = board[i][j].original;
      }
    }
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
    System.out.println(AnsiColors.ANSI_RED + "  I ~ Not Accessible" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_BRIGHTBLUE + "  N ~ Nexus" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_WHITE + "  P ~ Plain" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_PRETTYPURPLE + "  K ~ Koulou" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_PRETTYPURPLE + "  C ~ Cave" + AnsiColors.ANSI_RESET);
    System.out.println(AnsiColors.ANSI_PRETTYPURPLE + "  B ~ Bush" + AnsiColors.ANSI_RESET);
    String outerBoarder = stringMultiplication("*----------");
    System.out.print(outerBoarder + "*" + "\n");
    for(int i = 0; i < GAME_ROWS; i++) {
      for(int j = 0; j < GAME_COLS; j++) {
        if(j == 0) {
          System.out.print("|");
        }
        System.out.print(board[i][j].toString() + "|  " + board[i][j].curMarker.toString() + "  |" + board[i][j].toString() + "|");  
        if(j < 7) System.out.print("|");
      }
      System.out.print("\n");
      System.out.print(outerBoarder + "* \n");

    }
    System.out.print(AnsiColors.ANSI_BRIGHTYELLOW + "     1          2                     3          4                      5         6\n"  + AnsiColors.ANSI_RESET);   
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
  
 public static boolean moveUp(Hero inputHero) {
   int potentialMove = inputHero.position - GAME_ROWS;
   if(potentialMove < 0 || potentialMove > GAME_AREA + 1) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.compareTo("X") == 0)return false;
   else return true; 
 }
 
 public static boolean moveDown(Hero inputHero) {
   int potentialMove = inputHero.position + GAME_ROWS;
   if(potentialMove < 0 || potentialMove > GAME_AREA + 1) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.compareTo("X") == 0) return false;
   else return true; 
 }
 
 public static boolean moveRight(Hero inputHero) {
   int potentialMove = inputHero.position + 1;
   if(potentialMove % GAME_ROWS == 1) return false;
   Cell target = findRowColNumber(potentialMove);
   if(target.curMarker == null) return false;
   if(target.curMarker.compareTo("X") == 0) return false;
   else return true; 
 }
 
 public static boolean moveLeft(Hero inputHero) {
   int potentialMove = inputHero.position - 1;
   if(potentialMove % GAME_ROWS == 0) return false;
   Cell target = findRowColNumber(potentialMove); 
   if(target.curMarker == null) return false;
   if(target.curMarker.compareTo("X") == 0) return false;
   else return true; 
 }

 public static void moveHero(String move, int position, Hero curHero) {
   Cell revert = findRowColNumber(position);
   revert.curMarker = new Marker(" ");

   if(move.compareTo("W") == 0 || move.compareTo("w") == 0) {
     curHero.position = position - GAME_ROWS;
     Cell target = findRowColNumber(curHero.position);
     target.curMarker = target.temporaryHero;
     
   }
   else if(move.compareTo("A") == 0 || move.compareTo("a") == 0) {
     curHero.position = position - 1;
     Cell target = findRowColNumber(curHero.position);
     target.curMarker = target.temporaryHero;
   }
   else if(move.compareTo("D") == 0 || move.compareTo("d") == 0) {
     curHero.position = position + 1;
     Cell target = findRowColNumber(curHero.position);
     target.curMarker = target.temporaryHero;
   }
   else if(move.compareTo("S") == 0 || move.compareTo("s") == 0) {
     curHero.position = position + GAME_ROWS;
     Cell target = findRowColNumber(curHero.position);
     target.curMarker = target.temporaryHero;
   }
  
 }
  
 
}


