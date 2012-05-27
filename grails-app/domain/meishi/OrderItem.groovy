package meishi

/**
* 订单项
*/
class OrderItem {
	Dish dish
	Integer count = 0

	static belongsTo = [order : Order]
	
    static constraints = {
    }
}
