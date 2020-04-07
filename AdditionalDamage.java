
/*
 * AdditionalDamage: A public interface for spells that have different modes of damage
 * on an enemy.
 * 
 * public void additionalDamage(Monster enemy): A spell can do different types of damage to an enemy.
 */
public interface AdditionalDamage {

    public void additionalDamage(Monster enemy);
}
