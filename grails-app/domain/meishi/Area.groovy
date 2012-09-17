package meishi

class Area {
  String name
  
  static belongsTo = [district : District]
  
  static constraints = {
  }
  
  String toString() {
    name
  }
}
