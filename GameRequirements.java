/*
 * 
 * GameRequirements: An interface class that contains the foundational elements of all games.
 * 
 * void setUpGame(): Require all future games to have a set up procedure.
 * void startPlay(): Require all future games to have a start play method to begin the game.
 * boolean validMove(): Require all games to check for move validity.
 * 
 */

public interface GameRequirements {

  void setUpGame();
  void startPlay();
  boolean validMove(String move);
}
