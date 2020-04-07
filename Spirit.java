/*
 * Spirit: A subclass class of the parent class Monster, that creates an instance of 1 of 10 types of Spirit.
 * 
 * public Spirit(int selection): A constructor that takes in a menu selection and instantiates it
 * private void setChracter(int selection): A setter method to help initialize the new Spirit object.
 * public void toString(): A printable form of the Spirit object.
 */
public class Spirit extends Monster {

  public Spirit(int selection) {
    super();
    setCharacter(selection);
    calculateHP();
  }
  
  private void setCharacter(int selection) {
    if(selection == 1) {
      name = "Aim-Haborym"; level = 1;
      damage = 450; defense = 350; dodge = 0.35;

    }
    else if(selection == 2) {
      name = "Andrealphus"; level = 2;
      damage = 600; defense = 500; dodge = 0.4;
 
    }
    else if(selection == 3) {
      name = "Andromalius"; level = 3;
      damage = 550; defense = 450; dodge = 0.25;
    
    }
    else if(selection == 4) {
      name = "Chiang-shih"; level = 4;
      damage = 700; defense = 600; dodge = 0.4;
  
    }
    else if(selection == 5) {
      name = "Fallen Angel"; level = 5;
      damage = 800; defense = 700; dodge = 0.5;

    }
    else if(selection == 6) {
      name = "Ereshkigall"; level = 6;
      damage = 950; defense = 450; dodge = 0.35;
 
    }
    else if(selection == 7) {
      name = "Melchiresas"; level = 7;
      damage = 350; defense = 150; dodge = 0.75;

    }
    else if(selection == 8) {
      name = "Jormunngand"; level = 8;
      damage = 600; defense = 900; dodge = 0.2;

    }
    else if(selection == 9) {
      name = "Rakkshasass"; level = 9;
      damage = 550; defense = 600; dodge = 0.35;
    
    
    }
    else if(selection == 10) {
      name = "Taltecuhtli"; level = 10;
      damage = 300; defense = 200; dodge = 0.5;
   
    }
  }
  
  public String toString() {
    return super.toString();
  }
  
  
}
