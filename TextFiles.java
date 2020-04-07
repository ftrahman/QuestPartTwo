/*
 * TextFiles: Contains all of the large chunks of text necessary to the game.
 * 
 * Drawings are from asciiart.eu.
 */
public class TextFiles {
  

  public static void IceSpells() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
          "#     NAME         $    Level   Damage   Mana Cost\n" + AnsiColors.ANSI_RESET 
        + "1 Snow Cannon     500     2      650        250\n"
        + "2 Ice Blade       250     1      450        100\n"
        + "3 Frost Blizzard  750     5      850        350\n"
        + "4 Frozen Bazooka  650     4      750        300\n"
        + "5 Arctic Storm    700     6      800        300\n"
        + "6 Ice Blade       250     1      450        100\n"
        );
  }
  
  public static void FireSpells() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#     NAME         $    Level   Damage   Mana Cost\n" + AnsiColors.ANSI_RESET 
      + "1 Flame Tornado   700     4      850        300\n"
      + "2 Breath of Fire  350     1      450        100\n"
      + "3 Heat Wave       450     2      600        150\n"
      + "4 Lava Comet      800     7     1000        550\n"
      + "5 Hell Fire       550     3      500        200\n"
      + "6 Blaze Bullet    250     1      450        100\n"
      );
  }
  
  public static void LightningSpells() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#     NAME            $    Level   Damage   Mana Cost\n" + AnsiColors.ANSI_RESET 
      + "1 Light Dagger       400     1      500        150\n"
      + "2 Thunder Blast      750     4      950        400\n"
      + "3 Electric Arrows    550     5      650        200\n"
      + "4 Spark Needles      500     2      600        200\n"
      + "5 Lightening Strike  350     3      700        400\n"
      + "6 Charged Wave       200     1      300        150\n"
      );
  }
  
  public static void Potions() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#     NAME          $    Level   Attribute Increase\n" + AnsiColors.ANSI_RESET 
      + "1 Healing Potion   250     1             100\n"
      + "2 Strength Potion  200     1              75\n" 
      + "3 Magic Potion     350     2             100\n" 
      + "4 Luck Elixir      500     4              65  \n" 
      + "5 Mermaid Tears    850     5             100  \n"
      + "6 Ambrosia         1000    8             150\n"
      );
  }
  
  public static void Armory() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#     NAME             $    Level   Damage Reduction\n" + AnsiColors.ANSI_RESET 
      + "1 Platinum Shield     150     1            200\n" 
      + "2 Breastplate         350     3            600\n" 
      + "3 Gold Breastplate    600     6           1000\n" 
      + "4 Full Body Armor    1000     8           1100\n" 
      + "5 Wizard Shield      1200    10           1500\n" 
      + "6 Speed Boots         550     4            600\n"
      );
  }
  
  public static void Weaponry() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#    NAME      $    Level   Damage   Hands Required \n" + AnsiColors.ANSI_RESET 
      + "1 Sword       500     1      800            1\n" 
      + "2 Bow         300     2      500            2\n"
      + "3 Scythe     1000     6     1100            2\n"
      + "4 Axe         550     5      850            1\n" 
      + "5 Shield      400     1      100            1\n" 
      + "6 TSwords    1400     8     1600            2\n" 
      + "7 Dagger      200     1      250            1\n"    
      );
  }
  
  public static void Warriors() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#       NAME         Mana   Strength  Agility  Dexterity  Starting $   XP \n" + AnsiColors.ANSI_RESET 
      + "1 Gaerdal Ironhand    100      700      500       600        2500       7\n" 
      + "2 Sehanine Moonbow    600      700      800       500        2500       8\n" 
      + "3 Muamman Duathall    300      900      500       750        2500       6\n" 
      + "4 Flandal Steelskin   200      750      650       700        2500       7\n" 
      );
  }
  
  public static void Sorcerers() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#       NAME           Mana   Strength  Agility  Dexterity  Starting $   XP \n" + AnsiColors.ANSI_RESET 
      + "1 Garl Glittergold      700      550      600       500        2500       7\n" 
      + "2 Rillifane Rallathil  1300      750      450       500        2500       9\n" 
      + "3 Segojan Earthcaller   900      800      500       650        2500       5\n" 
      + "4 Skoraeus Stonebones   800      850      600       450        2500       6\n" 
      );
  }
  
  public static void Paladins() {
    System.out.println( "\n" + AnsiColors.ANSI_GREEN +
        "#       NAME           Mana   Strength  Agility  Dexterity  Starting $   XP \n"  + AnsiColors.ANSI_RESET 
      + "1 Solonor Thelandira    300      750      650       700        2500       7\n" 
      + "2 Icarus Moria          300      750      700       700        2500       7\n" 
      + "3 Damienne Bloodsea     250      650      600       350        2500       4\n" 
      + "4 Fred Flycrest         100      600      500       400        2500       5\n" 
      );      
  }
  
  public static void Intro() {
    System.out.println("                 ___====-_  _-====___\n" + 
        "           _--^^^#####//      \\\\#####^^^--_\n" + 
        "        _-^##########// (    ) \\\\##########^-_\n" + 
        "       -############//  |\\^^/|  \\\\############-\n" + 
        "     _/############//   (@::@)   \\\\############\\_\n" + 
        "    /#############((     \\\\//     ))#############\\\n" + 
        "   -###############\\\\    (oo)    //###############-\n" + 
        "  -#################\\\\  / VV \\  //#################-\n" + 
        " -###################\\\\/      \\//###################-\n" + 
        "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" + 
        "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" + 
        "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" + 
        "   `   `  `      `   / | |  | | \\   '      '  '   '\n" + 
        "                    (  | |  | |  )\n" + 
        "                   __\\ | |  | | /__\n" + 
        "                  (vvv(VVV)(VVV)vvv)\n" +
        " \n " + 
        "                 Welcome to The Quest!\n" +
        "       Please press ENTER when you are ready to begin!\n" +
        "                    \n");
  }
  
  public static void Heroes() {
    System.out.println("\n" +
                       "Which type of HERO do you want to select for your next hero?\n" +
                       "\n" + AnsiColors.ANSI_GREEN +
                       "#   Type\n" + AnsiColors.ANSI_RESET +
                       "1 Paladins\n" +
                       "2 Warriors\n" +
                       "3 Sorcerers\n" +
                       "\n" +
                       "Please enter the number associated with your desired HERO type.");
  }
  
  public static void SpellChoice() {
    System.out.println("\n" +
        "Which type of SPELL do you want?\n" +
        "\n" + AnsiColors.ANSI_GREEN +
        "#   Type\n" + AnsiColors.ANSI_RESET +
        "1 Ice Spells\n" +
        "2 Fire Spells\n" +
        "3 Lightning Spells\n" +
        "\n" +
        "Please enter the number associated with your desired SPELL type.");

  }
  
  public static void Market() {
    System.out.println("\n" +
                       "What would you like to see today?\n" +
                       "\n" + AnsiColors.ANSI_GREEN +
                       "#  Type\n" + AnsiColors.ANSI_RESET +
                       "1 Armor\n" +
                       "2 Weapons\n" +
                       "3 Potions\n" +
                       "4 Spells\n" +
                       "\n" +
                       "Please enter the number of your desired ITEM type.");
  }
  
  public static void Wizard() {
    System.out.println("                    ____ \n" + 
        "                  .'* *.'\n" + 
        "               __/_*_*(_\n" + 
        "              / _______ \\\n" + 
        "             _\\_)/___\\(_/_ \n" + 
        "            / _((\\- -/))_ \\\n" + 
        "            \\ \\())(-)(()/ /\n" + 
        "             ' \\(((()))/ '     \n" + 
        "            / ' \\)).))/ ' \\      To control your Heroes position on the board:\n" + 
        "           / _ \\ - | - /_  \\       W/w = MOVE UP\n" + 
        "          (   ( .;''';. .'  )      A/a = MOVE LEFT\n" + 
        "          _\\\"__ /    )\\ __\"/_      D/d = MOVE RIGHT\n" + 
        "            \\/  \\   ' /  \\/        S/s = MOVE DOWN\n" + 
        "             .'  '...' ' )         I/i = STATS AND INVENTORY\n" + 
        "              / /  |  \\ \\          Q/q = QUIT GAME\n" + 
        "             / .   .   . \\\n" + 
        "            /   .     .   \\\n" + 
        "           /   /   |   \\   \\\n" + 
        "         .'   /    b    '.  '.\n" + 
        "     _.-'    /     Bb     '-. '-._ \n" + 
        " _.-'       |      BBb       '-.  '-. \n" + 
        "(________mrf\\____.dBBBb.________)____)\n");
  }
  
  public static void WizardQL() {
    System.out.println("                    ____ \n" + 
        "                  .'* *.'\n" + 
        "               __/_*_*(_\n" + 
        "              / _______ \\\n" + 
        "             _\\_)/___\\(_/_ \n" + 
        "            / _((\\- -/))_ \\\n" + 
        "            \\ \\())(-)(()/ /\n" + 
        "             ' \\(((()))/ '     \n" + 
        "            / ' \\)).))/ ' \\      To control your Heroes position on the board:\n" + 
        "           / _ \\ - | - /_  \\       W/w = MOVE UP\n" + 
        "          (   ( .;''';. .'  )      A/a = MOVE LEFT\n" + 
        "          _\\\"__ /    )\\ __\"/_      D/d = MOVE RIGHT\n" + 
        "            \\/  \\   ' /  \\/        S/s = MOVE DOWN\n" + 
        "             .'  '...' ' )         B/b = BACK TO NEXUS\n" + 
        "              / /  |  \\ \\          I/i = STATS AND INVENTORY\n" + 
        "             / .   .   . \\         Q/q = QUIT GAME\n" + 
        "            /   .     .   \\\n" + 
        "           /   /   |   \\   \\\n" + 
        "         .'   /    b    '.  '.\n" + 
        "     _.-'    /     Bb     '-. '-._ \n" + 
        " _.-'       |      BBb       '-.  '-. \n" + 
        "(________mrf\\____.dBBBb.________)____)\n");
  }
  
  public static void Fairy() {
    System.out.println("      .--.   _,\n" + 
        "  .--;    \\ /(_\n" + 
        " /    '.   |   '-._    . ' .\n" + 
        "|       \\  \\    ,-.)  -= * =-\n" + 
        " \\ /\\_   '. \\((` .(    '/. '\n" + 
        "  )\\ /     \\ )\\  _/   _/\n" + 
        " /  \\\\    .-'   '--. /_\\\n" + 
        "|    \\\\_.' ,        \\/||\n" + 
        "\\     \\_.-';,_) _)'\\ \\||       Enter the number of Heroes you want to play with. \n" + 
        " '.       /`\\   (   '._/          You may have up to 3 heroes.\n" + 
        "   `\\   .;  |  . '.\n" + 
        "     ).'  )/|      \\\n" + 
        "     `    ` |  \\|   |\n" + 
        "             \\  |   |\n" + 
        "              '.|   |\n" + 
        "                 \\  '\\__\n" + 
        "                  `-._  '. _\n" + 
        "                     \\`;-.` `._\n" + 
        "                      \\ \\ `'-._\\\n" + 
        "                       \\ |\n" + 
        "                        \\ )\n" + 
        "                         \\_\\");
  }
  
  public static void FairyQL() {
    System.out.println("      .--.   _,\n" + 
        "  .--;    \\ /(_\n" + 
        " /    '.   |   '-._    . ' .\n" + 
        "|       \\  \\    ,-.)  -= * =-\n" + 
        " \\ /\\_   '. \\((` .(    '/. '\n" + 
        "  )\\ /     \\ )\\  _/   _/\n" + 
        " /  \\\\    .-'   '--. /_\\\n" + 
        "|    \\\\_.' ,        \\/||\n" + 
        "\\     \\_.-';,_) _)'\\ \\||       \n" + 
        " '.       /`\\   (   '._/          Please select your three Heroes.\n" + 
        "   `\\   .;  |  . '.\n" + 
        "     ).'  )/|      \\\n" + 
        "     `    ` |  \\|   |\n" + 
        "             \\  |   |\n" + 
        "              '.|   |\n" + 
        "                 \\  '\\__\n" + 
        "                  `-._  '. _\n" + 
        "                     \\`;-.` `._\n" + 
        "                      \\ \\ `'-._\\\n" + 
        "                       \\ |\n" + 
        "                        \\ )\n" + 
        "                         \\_\\");
  }
  
  public static void MarketIntro() {
    System.out.println(
        "                             -|             |-\n" + 
        "         -|                  [-_-_-_-_-_-_-_-]                  |-\n" + 
        "         [-_-_-_-_-]          |             |          [-_-_-_-_-]\n" + 
        "          | o   o |           [  0   0   0  ]           | o   o |\n" + 
        "           |     |    -|       |           |       |-    |     |\n" + 
        "           |     |_-___-___-___-|         |-___-___-___-_|     |\n" + 
        "           |  o  ]              [    0    ]              [  o  |\n" + 
        "           |     ]   o   o   o  [ _______ ]  o   o   o   [     | ----__________\n" + 
        "_____----- |     ]              [ ||||||| ]              [     |\n" + 
        "           |     ]              [ ||||||| ]              [     |\n" + 
        "       _-_-|_____]--------------[_|||||||_]--------------[_____|-_-_\n" + 
        "      ( (__________------------_____________-------------_________) )\n" + 
        "                    "+  AnsiColors.ANSI_PURPLE + "       Welcome to the MARKET.\n" + 
        "                      Please press ENTER to continue." + AnsiColors.ANSI_RESET);
  }
  
  
}
