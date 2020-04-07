/*
 * Warrior: A subclass class of the parent class Hero, that creates an instance of 1 of 4 Warrior.
 * 
 * public Warrior(int selection): A constructor that takes in a menu selection and instantiates it.
 * private void setCharacter(int selection): A setter method to help initialize the new Warrior object.
 * public void toString(): A printable form of the Warrior object.
 * public void adjustSkills(): Interface method to apply specific skills.
 */
public class Warrior extends Hero implements AdditionalSkills{

  public Warrior(int selection) {
    super();
    setCharacter(selection);
    calculateGoalXP();
  }
  
  private void setCharacter(int selection) {
    if(selection == 1) {
      name = "Gaerdal Ironhand";
      currentMana = 100; money = 2500; currentXP = 7;
      strength = 700; agility = 500; dexterity = 600;  
    }
    else if(selection == 2) {
      name = "Sehanine Moonbow";
      currentMana = 600; money = 2500; currentXP = 8;
      strength = 700; agility = 800; dexterity = 500;
    }
    else if(selection == 3) {
      name = "Muamman Duathall";
      currentMana = 300; money = 2500; currentXP = 6;
      strength = 900; agility = 500; dexterity = 750;
    }
    else if(selection == 4) {
      name = "Flandal Steelskin";
      currentMana = 200; money = 2500; currentXP = 7;
      strength = 750; agility = 650; dexterity = 700;
    }
  }
  
  public String toString() {
    return super.toString();
  }

  public void adjustSkills() {
    strength = strength + (strength * 0.1);
    dexterity = dexterity + (dexterity * 0.05);
    agility = agility + (agility * 0.1);
  }

  
}
