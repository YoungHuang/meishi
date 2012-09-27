package meishi

import java.util.List;

class HotArea {
  String name

  static belongsTo = [city : City]
  
  static constraints = {
  }
  
  String toString() {
    name
  }
}
