
/*
 * Marker: A class that defines a Marker object.
 * 
 * public Marker(String type): A constructor to help assign markers. 
 * private void setMarker(String type): A setter method for defining the value of a Marker.
 * public String toString(): Provide a string representation of the Marker object.
 * public int compareTo(String string): Helps to make Marker object comparable.
 */

public class Marker {
  
  public String id;
  public Marker(String type) {
    setMarker(type);
  }
  
  private void setMarker(String type) {
    if(type.compareTo("N") == 0) {
      id = "N";
    }
    else if(type.compareTo("H") == 0) {
      id = "H";
    }
    else if(type.compareTo("M") == 0) {
      id = "M";
    }
    else if(type.compareTo("X") == 0) {
      id = "X";
    }
    else {
      id = " ";
    }
  }
  

  public String toString() {
    if(id.compareTo("H") == 0){
      return AnsiColors.ANSI_CYAN + "H" + AnsiColors.ANSI_RESET;
    }
    else if(id.compareTo("M") == 0){
      return AnsiColors.ANSI_YELLOW + "M" + AnsiColors.ANSI_RESET;
    }
    else if(id.compareTo("X") == 0){
      return AnsiColors.ANSI_RED + "X" + AnsiColors.ANSI_RESET;
    }
    return " ";
  }

  public int compareTo(String string) {
    if(string.compareTo(id) == 0) {
      return 0;
    }
    return -1;
  }
}
