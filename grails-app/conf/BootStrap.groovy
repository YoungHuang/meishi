import meishi.Dish
import meishi.DishCategory
import meishi.Shop

class BootStrap {

    def init = { servletContext ->
		return
		
		(1..20).each { i ->
			def shop = new Shop(
				name : "海底捞$i",
				rating : 4.5,
				phone : 12346798,
				startPrice : 7,
				description : "海底捞",
				province : "江苏",
				city : "南京",
				district : "白下区",
				road : "太平南路1号大行宫新世纪广场4楼(近中山东路)"
				)
			if (shop.validate()) {
				shop.save(flush :true)
		    } else {
				shop.errors.allErrors.each {
					println it
				}
		    }
		}
		
		Shop.list().each { shop ->
			(1..2).each { i ->
				def dishCategory = new DishCategory(
						name : "系列套餐",
						dishCount : 10,
						shop : shop
					)
				if (dishCategory.validate()) {
					dishCategory.save(flush :true)
				} else {
					dishCategory.errors.allErrors.each {
						println it
					}
				}
			}
		}
		
		DishCategory.list().each { dishCategory ->
			(1..10).each { i ->
				def dish = new Dish(
						name : "培根蛋三明治套餐",
						price : 35.5,
						description : "培根蛋三明治套餐 早餐（7点至11点供应）",
						dishCategory : dishCategory
					)
				if (dish.validate()) {
					dish.save(flush :true)
				} else {
					dish.errors.allErrors.each {
						println it
					}
				}
			}
		}
    }
	
    def destroy = {
    }
}
