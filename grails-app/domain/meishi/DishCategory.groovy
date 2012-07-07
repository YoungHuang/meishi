package meishi

import java.util.List;

/**
* 菜单类别
*/
class DishCategory {
	/** 菜单类别名 **/
	String name
	/** 菜单列表 **/
	List<Dish> dishList
	/** 菜品数量 **/
	Integer dishCount
	
	static belongsTo = [shop : Shop]
	
	static mapping = {
	}
	
    static constraints = {
    }
	
	String toString() {
		name
	}
}
