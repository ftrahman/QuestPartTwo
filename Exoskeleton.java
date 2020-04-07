
/*
 * Exoskeleton: A subclass class of the parent class Monster, that creates an instance of 1 of 10 types of Exoskeletons.
 * 
 * public Exoskeleton(int selection): A constructor that takes in a menu selection and instantiates it
 * private void setChracter(int selection): A setter method to help initialize the new Exoskeleton object.
 * public void toString(): A printable form of the Exoskeleton object.
 */

public class Exoskeleton extends Monster {

  public Exoskeleton(int selection) {
    super();
    setCharacter(selection);
    calculateHP();
  }
  
  private void setCharacter(int selection) {
    if(selection == 1) {
      name = "Big Bad Wolf"; level = 1;
      damage = 150; defense = 250; dodge = 0.15;

    }
    else if(selection == 2) {
      name = "Wicked Witch"; level = 2;
      damage = 250; defense = 350; dodge = 0.25;

    }
    else if(selection == 3) {
      name = "Brandobaris"; level = 3;
      damage = 350; defense = 450; dodge = 0.3;

    }
    else if(selection == 4) {
      name = "Aasterinian"; level = 4;
      damage = 400; defense = 500; dodge = 0.45;

    }
    else if(selection == 5) {
      name = "St Shargaas"; level = 5;
      damage = 550; defense = 650; dodge = 0.55;

    }
    else if(selection == 6) {
      name = "Chronepsish"; level = 6;
      damage = 650; defense = 750; dodge = 0.6;

    }
    else if(selection == 7) {
      name = "Cyrrollalee"; level = 7;
      damage = 700; defense = 800; dodge = 0.75;

    }
    else if(selection == 8) {
      name = "Kiaransalee"; level = 8;
      damage = 850; defense = 950; dodge = 0.85;

    }
    else if(selection == 9) {
      name = "St Yeenoghu"; level = 9;
      damage = 950; defense = 850; dodge = 0.9;
    }
    else if(selection == 10) {
      name = "Merrshaullk"; level = 10;
      damage = 1000; defense = 900; dodge = 0.55;

    }
  }
  public String toString() {
    return super.toString();
  }
 
}
