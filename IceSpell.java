/*
 * IceSpell: A subclass class of the parent class Spell, that creates an instance of 1 of 6 types of Ice Spells.
 * 
 * public IceSpell(int selection): A constructor that takes in a menu selection and instantiates it.
 * private void setItem(int selection): A setter method to help initialize the new Ice Spell object.
 * public void toString(): A printable form of the Ice Spell object.
 * public void additionalDamage(Monster enemy): Interface method to apply specific attack.
 */
public class IceSpell extends Spell implements AdditionalDamage{

  public IceSpell(int selection) {
    super();
    setItem(selection);
  }
  
  private void setItem(int selection) {
    if(selection == 1) {
      name = "Snow Cannon"; minLevel = 2;
      manaCost = 250; price = 500; baseDamage = 650;
    }
    else if(selection == 2) {
      name = "Ice Blade"; minLevel = 1;
      manaCost = 100; price = 250; baseDamage = 450;
    }
    else if(selection == 3) {
      name = "Frost Blizzard"; minLevel = 5;
      manaCost = 350; price = 750; baseDamage = 850;
    }
    else if(selection == 4) {
      name = "Frozen Bazooka"; minLevel = 4;
      manaCost = 300; price = 650; baseDamage = 750;
    }
    else if(selection == 5) {
      name = "Arctic Storm"; minLevel = 6;
      manaCost = 300; price = 700; baseDamage = 800;
    }
    else if(selection == 6) {
      name = "Snow Cannon"; minLevel = 1;
      manaCost = 100; price = 250; baseDamage = 450;
    }
  }
  
  public String toString() {
    return AnsiColors.ANSI_GREEN + "Name: " + AnsiColors.ANSI_RESET + name + 
        AnsiColors.ANSI_GREEN + " Mana Cost: " + AnsiColors.ANSI_RESET + manaCost +
        AnsiColors.ANSI_GREEN + " Base Damage: " + AnsiColors.ANSI_RESET + baseDamage; 
  }
  
  public void additionalDamage(Monster enemy) {
    enemy.damage = enemy.damage * 0.9;
  }

  

}
