/*
 * Spell: Parent abstract class for other types of spells.
 * 
 * public double calculateDamage(Hero currentHero): Find the damage of the spell.
 * public String toString(): String representation.
 */
abstract class Spell extends Item {
  static double baseDamage;
  double manaCost;
  double finalDamage;
  
  public Spell() {
    super();
  }
  
  
  public double calculateDamage(Hero currentHero) {
    finalDamage = (baseDamage * (currentHero.dexterity/1000)) + baseDamage;
    return finalDamage;
  }
  
 
  public String toString() {
    return super.toString() + AnsiColors.ANSI_GREEN + " Mana Cost: " + AnsiColors.ANSI_RESET + manaCost +
        AnsiColors.ANSI_GREEN + " Base Damage: " + AnsiColors.ANSI_RESET + baseDamage ;
  }
}
