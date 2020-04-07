/*
 * Cell: A cell class to represent the board tiles.
 * 
 * public Cell(int row, int col): Requires a row, column identifier.
 * public static boolean validCellNumber(int cellNumber): Determine if a given cell number exists. 
 * public static boolean validMove(Cell cell): Determine if a given cell is a valid move.
 */


public class Cell {
  public int row;
  public int col;
  public boolean hero;
  public String type;
  Marker curMarker;
  Marker original;
  Marker temporaryHero = new Marker("H");
  public int id;
  Marker temporaryMonster = new Marker("M");
  
  public Cell(int row, int col) {
    this.row = row; this.col = col;
    hero = false; id = 0; curMarker = new Marker(" ");
  }
  

  public String toString() {
    if(type.compareTo("I") == 0){
      return AnsiColors.ANSI_RED + "I" + AnsiColors.ANSI_RESET;
    }
    else if(type.compareTo("N") == 0){
      return AnsiColors.ANSI_BRIGHTBLUE + "N" + AnsiColors.ANSI_RESET;
    }
    else if(type.compareTo("K") == 0){
      return AnsiColors.ANSI_PRETTYPURPLE + "K" + AnsiColors.ANSI_RESET;
    }
    else if(type.compareTo("B") == 0){
      return AnsiColors.ANSI_PRETTYPURPLE + "B" + AnsiColors.ANSI_RESET;
    }
    else if(type.compareTo("C") == 0){
      return AnsiColors.ANSI_PRETTYPURPLE + "C" + AnsiColors.ANSI_RESET;
    }
    else if(type.compareTo("P") == 0){
      return AnsiColors.ANSI_WHITE + "P" + AnsiColors.ANSI_RESET;
    }
    return " ";
  }
  
  public void cellAttribute(Hero curHero) {
    if(type.compareTo("K") == 0){
      curHero.strength *= 1.1;
    }
    else if(type.compareTo("B") == 0){
      curHero.dexterity *= 1.1;
    }
    else if(type.compareTo("C") == 0){
      curHero.agility *= 1.1;
    }
  }
  
  public int compareTo(String string) {
    if(string.compareTo(type) == 0) {
      return 0;
    }
    return -1;
  }
  
  public static boolean validCellNumber(int cellNumber) {
    if(cellNumber <= QuestBoard.GAME_AREA && cellNumber > 0) return true;
    else return false;
  }
  
  public static boolean validMove(Cell cell) {
    if(!cell.hero) return true;
    else return false;
  }
  

}
