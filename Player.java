/*
 * Player: The uppermost abstract parent class for any kind of Player object. 
 * 
 * public Player(): A default constructor to set basic stats for all players.
 * private void calculateHP(): All player objects contains an HP counter. 

 */

abstract class Player {
  String name;
  int level;
  double HP;
  boolean alive;
  String nickname;
  int position;
  int startingPosition;
  
  Player(){    
    level = 1;
    HP = 100;
    alive = true;
  }
  
  void calculateHP() {
    this.HP = this.level * 100;
  }
  
  
  
}
