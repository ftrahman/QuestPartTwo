/*
 * Sorcerer: A subclass class of the parent class Hero, that creates an instance of 1 of 4 Sorcerers.
 * 
 * public Sorcerer(int selection): A constructor that takes in a menu selection and instantiates it.
 * private void setCharacter(int selection): A setter method to help initialize the new Sorcerers object.
 * public void toString(): A printable form of the Sorcerers object.
 * public void adjustSkills(): Interface method to apply specific skills.
 */
public class Sorcerer extends Hero implements AdditionalSkills{
 
  public Sorcerer(int selection) {
    super();
    setCharacter(selection);
    calculateGoalXP();
  }
  
  private void setCharacter(int selection) {
    if(selection == 1) {
      name = "Garl Glittergold";
      currentMana = 700; money = 2500; currentXP = 7;
      strength = 550; agility = 600; dexterity = 500;  
    }
    else if(selection == 2) {
      name = "Rillifane Rallathil";
      currentMana = 1300; money = 2500; currentXP = 9;
      strength = 750; agility = 450; dexterity = 500;
    }
    else if(selection == 3) {
      name = "Segojan Earthcaller";
      currentMana = 900; money = 2500; currentXP = 5;
      strength = 800; agility = 500; dexterity = 650;
    }
    else if(selection == 4) {
      name = "Skoraeus Stonebones";
      currentMana = 800; money = 2500; currentXP = 6;
      strength = 850; agility = 600; dexterity = 450;
    }
  }

  public void adjustSkills() {
    strength = strength + (strength * 0.05);
    dexterity = dexterity + (dexterity * 0.1);
    agility = agility + (agility * 0.1);
  }

  public String toString() {
    return super.toString();
  }
  
  
}
