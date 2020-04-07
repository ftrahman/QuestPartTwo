
/*
 * Dragon: A subclass class of the parent class Monster, that creates an instance of 1 of 10 types of Dragons.
 * 
 * public Dragon(int selection): A constructor that takes in a menu selection and instantiates it
 * private void setChracter(int selection): A setter method to help initialize the new Dragon object.
 * public void toString(): A printable form of the Dragon object.
 */


public class Dragon extends Monster {
  
  public Dragon(int selection) {
    super();
    setCharacter(selection);
    calculateHP();
  }
  
  private void setCharacter(int selection) {
    if(selection == 1) {
      name = "Natsunomeryu"; level = 1;
      damage = 100; defense = 200; dodge = 0.1;
      
    }
    else if(selection == 2) {
      name = "Chrysophylax"; level = 2;
      damage = 200; defense = 500; dodge = 0.2;
      
    }
    else if(selection == 3) {
      name = "Desghidorrah"; level = 3;
      damage = 300; defense = 400; dodge = 0.35; 
    }
    else if(selection == 4) {
      name = "Bunsen Burner"; level = 4;
      damage = 400; defense = 500; dodge = 0.45;
    }
    else if(selection == 5) {
      name = "Kas-Ethelinh"; level = 5;
      damage = 600; defense = 700; dodge = 0.6;

    }
    else if(selection == 6) {
      name = "Phaarthurnax"; level = 6;
      damage = 600; defense = 700; dodge = 0.6;

    }
    else if(selection == 7) {
      name = "The Scaleless"; level = 7;
      damage = 700; defense = 600; dodge = 0.75;

    }
    else if(selection == 8) {
      name = "The Weatherbe"; level = 8;
      damage = 800; defense = 900; dodge = 0.8;

    }
    else if(selection == 9) {
      name = "D-Maleficent"; level = 9;
      damage = 900; defense = 950; dodge = 0.85;
  
    }
    else if(selection == 10) {
      name = "Alexstraszan"; level = 10;
      damage = 1000; defense = 9000; dodge = 0.55;
    }
    
  }
  public String toString() {
    return super.toString();
  }
  
}
