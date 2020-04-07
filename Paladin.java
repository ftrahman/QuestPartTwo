/*
 * Paladin: A subclass class of the parent class Hero, that creates an instance of 1 of 4 Paladins.
 * 
 * public Paladin(int selection): A constructor that takes in a menu selection and instantiates it.
 * private void setCharacter(int selection): A setter method to help initialize the new Paladin object.
 * public void toString(): A printable form of the Paladin object.
 * public void adjustSkills(): Interface method to apply specific skills.
 */

public class Paladin extends Hero implements AdditionalSkills {

  public Paladin(int selection) {
    super();
    setCharacter(selection);
    calculateGoalXP();
  }
  
  private void setCharacter(int selection) {
    if(selection == 1) {
      name = "Solonor Thelandira";
      currentMana = 300; money = 2500; currentXP = 7;
      strength = 750; agility = 650; dexterity = 700;  
    }
    else if(selection == 2) {
      name = "Icarus Moria";
      currentMana = 300; money = 2500; currentXP = 7;
      strength = 750; agility = 700; dexterity = 700;
    }
    else if(selection == 3) {
      name = "Damienne Bloodsea";
      currentMana = 250; money = 2500; currentXP = 4;
      strength = 650; agility = 600; dexterity = 350;
    }
    else if(selection == 4) {
      name = "Fred Flycrest";
      currentMana = 100; money = 2500; currentXP = 5;
      strength = 600; agility = 500; dexterity = 400;
    }
  }

  public void adjustSkills() {
    strength = strength + (strength * 0.1);
    dexterity = dexterity + (dexterity * 0.1);
    agility = agility + (agility * 0.05);
  }
  
  public String toString() {
    return super.toString();
  }

  
}
