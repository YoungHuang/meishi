package meishi

/**
 * 菜单
 */
class Dish {
	/** 菜名 **/
	String name
	/** 价格 **/
	Double price
	/** 描述 **/
	String description
	
	static belongsTo = [dishCategory : DishCategory]
	
    static constraints = {
    }
	
	String toString() {
		name
	}
}
