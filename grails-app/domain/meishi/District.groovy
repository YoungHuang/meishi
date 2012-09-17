package meishi

class District {
  String name
  List<Area> areas
  
  static belongsTo = [city : City]
  
  static constraints = {
  }
  
  String toString() {
    name
  }
}
