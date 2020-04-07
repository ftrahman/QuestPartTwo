
/*
 * Fight: A class to represent a fight between Heroes and Monsters. 
 * 
 * public Fight(Team teamMembers): Constructs the fight from the Heroes team.
 * private void fightEntry(): Help control the fight loop.
 * private void startFight(): Help to initialize and gather opponents.
 * private void initializeArrays(): Initializes the arrays for dead/alive characters.
 * private void updateArrays(): Maintains that current state of dead/alive characters.
 * private void endGame(): End the fight.
 * private void organizeFight(): Helps to match opponent against each other.
 * private void individualFight(Hero hero, Monster enemy): Begins a fight between two individual characters
 *       and not their teams.
 * private void assignEnemies(): Initializes the enemy array with appropriate characters.
 * public int findLevel(Team team, int position): Determine the level of the heroes to match to the monsters.
 * private void regain(): Helps heroes regain some health following a round.
 * private void levelUp(): If the heroes win, and happen to level up during the fight, increase their stats.
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class Fight {
  private static Monster[] enemies = null;
  private static boolean[] monstersAlive = null;
  private static boolean[] heroesAlive = null;
  private static int counter1;
  private static int counter2;
  static boolean winnersM = false;
  static boolean winnersH = false;
  private static boolean complete = false;
  private int length;
  public Team teamHero;
  public static boolean done = false;
  private static Scanner input = new Scanner(System.in);
  private boolean takeTurns = false;
  private final int DODGE_CHANCE = 12;
  
  
  
  public Fight(Team teamMembers) {
    enemies = new Monster[teamMembers.length];
    monstersAlive = new boolean[teamMembers.length];
    heroesAlive = new boolean[teamMembers.length];
    this.length = teamMembers.length;
    teamHero = teamMembers;
    fightEntry();
  }
  
  private void fightEntry() {
    if(!complete) {
      startFight();
    }
  }
  
 private void startFight() {
   System.out.println("Oh no! You've encountered a Monster! Get ready to fight!");
   assignEnemies();
   initializeArrays();
   do {
     System.out.println(done);
     updateArrays();
     organizeFight();
   }while(!done);
   
 }
 
 private void initializeArrays() {
   for(int i = 0; i < length; i++) {
     monstersAlive[i] = true;
     heroesAlive[i] = true;
   }
 }
 
 private void updateArrays() {
   for(int i = 0; i < length; i++) {
     if(!Team.team[i].alive) { 
       heroesAlive[i] = false;
       counter1++;
       if(counter1 == length) {
         done = true; complete  = true;
         endGame(); winnersM = true;
       }
     }
     if(Team.team[i].alive) {
       regain();
       
     }
     if(!enemies[i].alive) { 
       monstersAlive[i] = false;
       counter2++;
       if(counter2 == length) {
         done = true; complete  = true;
         endGame(); winnersH = true;
       }
     }
   }
 }
 
 private void endGame() {
   if(winnersH) {
     for(int i = 0; i < length; i++) {
       if(Team.team[i].alive) {
         Team.team[i].money += 150;
         Team.team[i].currentXP += 2;
       }
       if(Team.team[i].currentXP >= Team.team[i].goalXP) {
         levelUp();
       }
     }
   }
   else {
     System.out.println("Unfortunately, you lost.");
     done = true;
   }
   
 }
 
 private void organizeFight() {
   for(int i = 0; i < length; i++) {
       individualFight(Team.team[i], enemies[i]);
   }
 }
 
 private void individualFight(Hero hero, Monster enemy){
   System.out.println("Below are your current statistics and your enemy's statistics.\n");
   System.out.print(hero +"\n");
   System.out.print(enemy + "\n");
   System.out.println("\n");
   hero.equip();
   System.out.println("Below are your updated statistics.\n");
   System.out.print(hero +"\n");
   System.out.print(enemy + "\n");
   System.out.println("\n");
   if(!takeTurns) {
     if(hero.currentSpell != null) {
       Random rand = new Random();
       boolean dodge = rand.nextInt(100) < enemy.dodge*100;
       if(!dodge) {
         enemy.HP = enemy.HP - hero.currentSpell.calculateDamage(hero) + enemy.defense;
         
         if(hero.currentSpell instanceof IceSpell) {
           IceSpell tempSpell = (IceSpell) hero.currentSpell;
           tempSpell.additionalDamage(enemy);
           hero.currentMana =- tempSpell.manaCost;
         }
         else if(hero.currentSpell instanceof FireSpell) {
           FireSpell tempSpell = (FireSpell) hero.currentSpell;
           tempSpell.additionalDamage(enemy);
           hero.currentMana =- tempSpell.manaCost;
         }
         else if(hero.currentSpell instanceof LightningSpell) {
           LightningSpell tempSpell = (LightningSpell) hero.currentSpell;
           tempSpell.additionalDamage(enemy);
           hero.currentMana =- tempSpell.manaCost;
         }
       }
     }
     if(hero.currentWeapon != null) {
       Random rand = new Random();
       boolean dodge = rand.nextInt(100) < enemy.dodge*100;
       if(!dodge) {
         enemy.HP = enemy.HP - hero.currentWeapon.damage + enemy.defense;
       }
     }
     if(enemy.HP <= 0) {
       enemy.alive = false;
       enemy.HP = 0;
     }
   }
   takeTurns = true;
   while(takeTurns) {
     Random rand = new Random();
     boolean dodge = rand.nextInt(100) < DODGE_CHANCE;
     if(!dodge) {
       hero.HP = hero.HP + hero.defense - enemy.damage;
     }
     if(hero.HP <= 0) {
       hero.alive = false;
       hero.HP = 0;
     }
     takeTurns = false;
   } 
   
 }
  
 private void assignEnemies() {
   for(int i = 0; i < length; i++) {
     if(enemies[i] == null && i == 0) {
       int selection = findLevel(teamHero, 0);
       enemies[i] = new Dragon(selection);
     }
     else if(enemies[i] == null && i == 1) {
       int selection = findLevel(teamHero, 1);
       enemies[i] = new Exoskeleton(selection);
     }
     else if(enemies[i] == null && i == 2) {
       int selection = findLevel(teamHero, 2);
       enemies[i] = new Spirit(selection);
     }
   }   
 }
 
 public int findLevel(Team team, int position) {
   if(Team.team[position] != null) {
         return Team.team[position].level;
       }
   return 0;
 
 }
 
 private void regain() {
   for(int i = 0; i < length ; i++) {
     Team.team[i].currentMana = Team.team[i].currentMana + (Team.team[i].currentMana * 0.05);
     Team.team[i].HP = Team.team[i].HP + (Team.team[i].HP * 0.05);
   }
  }
 
 private void levelUp() {
   for(int i = 0; i < length ; i++) {
     Team.team[i].calculateMana();
     Team.team[i].level++;
     Team.team[i].calculateGoalXP();
     Team.team[i].calculateHP();
     if(Team.team[i] instanceof Paladin) {
       Paladin temp = (Paladin)Team.team[i];
       temp.adjustSkills();
     }
     if(Team.team[i] instanceof Warrior) {
       Warrior temp = (Warrior)Team.team[i];
       temp.adjustSkills();
     }
     if(Team.team[i] instanceof Sorcerer) {
       Sorcerer temp = (Sorcerer)Team.team[i];
       temp.adjustSkills();
     }
     
   }
 }


 

  
  
  
  
}
