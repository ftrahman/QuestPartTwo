import java.util.Random;

public class MonsterTeam {
  public static Monster[] team = null;
  public int length;
  
  public MonsterTeam(int length) {
    team = new Monster[length];
    this.length = length;
  }
  
  private Monster getPlayer(int index) {
    return team[index];
  }
  
  public void assignEnemies() {
    Cell target = null;
    Random r = new Random();
    for(int i = 0; i < length; i++) {
      if(team[i] == null && i == 0) {
        int selection = findLevel(0);
        team[i] = new Dragon(selection);
        team[i].nickname = "M" + i;
        team[i].position = r.nextInt(2) + 1;    
        team[i].startingPosition = team[i].position;
        target = QuestOfLegendsBoard.findRowColNumber(team[0].position);
      }
      else if(team[i] == null && i == 1) {
        int selection = findLevel(1);
        team[i] = new Exoskeleton(selection);
        team[i].nickname = "M" + i;
        team[i].position = r.nextInt(2) + 4;
        team[i].startingPosition = team[i].position;
        target = QuestOfLegendsBoard.findRowColNumber(team[1].position);
      }
      else if(team[i] == null && i == 2) {
        int selection = findLevel(2);
        team[i] = new Spirit(selection);
        team[i].nickname = "M" + i;
        team[i].position = r.nextInt(2) + 7;
        team[i].startingPosition = team[i].position;
        target = QuestOfLegendsBoard.findRowColNumber(team[2].position);
      }
      target.curMarker = target.temporaryMonster;
    }
  }
  
  
  public int findLevel(int position) {
    if(Team.team[position] != null) {
          return Team.team[position].level;
        }
    return 0;
  
  }
  
}

