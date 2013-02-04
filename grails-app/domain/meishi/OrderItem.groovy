package meishi

/**
 * 订单项
 */
class OrderItem {
  Dish dish
  Integer orderItemCount
  Double amount

  static belongsTo = [order : Order]
  
  static mapping = {
    dish fetch: 'join'
  }

  static constraints = {
  }
}
