
/*
 * Item: An abstract class that defines the essential for a Quest Item.
 * 
 * public Item(): A default constructor to prevent null objects.
 * public String toString(): Provide a parent string representation.
 */
abstract class Item {
  String name;
  int price;
  int minLevel;
  
  Item(){
    name = "UNDEFINED";
    price = 0; minLevel = 0;
  }
  
  public String toString() {
    return AnsiColors.ANSI_GREEN + "Name: " + AnsiColors.ANSI_RESET + name + AnsiColors.ANSI_GREEN + " Price: " +
        AnsiColors.ANSI_RESET + price; 

  }
}
