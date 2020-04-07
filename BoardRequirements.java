
/*
 * BoardRequirements: An abstract class that contains the foundational elements of all board games.
 * 
 * public BoardRequirements(int rows, int cols): A constructor requiring rows and columns to instantiate a board.
 * public abstract void setBoard(): Require all future Board games to set up the board.
 * public abstract void reset(): Require all future Board games to reset the board.
 * public abstract void printBoard(): Require all future Board games to have a print method.
 * 
 */

public abstract class BoardRequirements {
  public static int GAME_ROWS;
  public static int GAME_COLS;
  public static int GAME_AREA;
  public static Cell[][] board;
  
  public BoardRequirements(int rows, int cols) {
    int counter = 1; GAME_ROWS = rows; GAME_COLS = cols;
    GAME_AREA = GAME_ROWS * GAME_COLS;
    board = new Cell[GAME_ROWS][GAME_COLS];
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        // Leaving this in in case we need to identify specific cells later
        board[i][j] = new Cell(i, j);
        board[i][j].id = counter; counter++;
      }
    }
  }
  
  public abstract void setBoard();
  public abstract void reset();
  public abstract void printBoard();
}
