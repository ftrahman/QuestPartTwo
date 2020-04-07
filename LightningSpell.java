/*
 * LightningSpell: A subclass class of the parent class Spell, that creates an instance of 1 of 6 types of Lightning Spells.
 * 
 * public LightningSpell(int selection): A constructor that takes in a menu selection and instantiates it.
 * private void setItem(int selection): A setter method to help initialize the new Lightning Spell object.
 * public void toString(): A printable form of the Lightning Spell object.
 * public void additionalDamage(Monster enemy): Interface method to apply specific attack.
 */
public class LightningSpell extends Spell implements AdditionalDamage{

  public LightningSpell(int selection) {
    super();
    setItem(selection);
  }
  
  private void setItem(int selection) {
    if(selection == 1) {
      name = "Light Dagger"; minLevel = 1;
      manaCost = 150; price = 400; baseDamage = 500;
    }
    else if(selection == 2) {
      name = "Thunder Blast"; minLevel = 4;
      manaCost = 400; price = 750; baseDamage = 950;
    }
    else if(selection == 3) {
      name = "Electric Arrows"; minLevel = 5;
      manaCost = 200; price = 550; baseDamage = 650;
    }
    else if(selection == 4) {
      name = "Spark Needles"; minLevel = 2;
      manaCost = 200; price = 500; baseDamage = 600;
    }
    else if(selection == 5) {
      name = "Lightning Strike"; minLevel = 3;
      manaCost = 400; price = 350; baseDamage = 700;
    }
    else if(selection == 6) {
      name = "Charged Wave"; minLevel = 1;
      manaCost = 150; price = 200; baseDamage = 300;
    }
  }
  public String toString() {
    return AnsiColors.ANSI_GREEN + "Name: " + AnsiColors.ANSI_RESET + name +  
        AnsiColors.ANSI_GREEN + " Mana Cost: " + AnsiColors.ANSI_RESET + manaCost +
        AnsiColors.ANSI_GREEN + " Base Damage: " + AnsiColors.ANSI_RESET + baseDamage; 
  }
  
  
  public void additionalDamage(Monster enemy) {
    enemy.dodge = enemy.dodge * 0.9;
  }

}
