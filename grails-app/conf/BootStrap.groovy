import meishi.Area
import meishi.City
import meishi.Dish
import meishi.DishCategory
import meishi.District
import meishi.HotArea
import meishi.Order
import meishi.OrderItem
import meishi.Shop
import meishi.User

class BootStrap {

  def init = { servletContext ->
    //		return

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
        shop.errors.allErrors.each { println it }
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
          dishCategory.errors.allErrors.each { println it }
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
          dish.errors.allErrors.each { println it }
        }
      }
    }

    (1..10).each { i ->
      def user = new User(
          name : "张三$i",
          phone : 12346798,
          address : "太平南路1号大行宫新世纪广场4楼(近中山东路)"
          )
      if (user.validate()) {
        user.save(flush :true)
      } else {
        user.errors.allErrors.each { println it }
      }
    }

    User.list().each { user ->
      (1..5).each { i ->
        def order = new Order(
            shop : Shop.get(i),
            user : user,
            totalAmount : 35.5,
            description : "早餐$i",
            totalCount : 2,
            people : 2
            )
        if (order.validate()) {
          order.save(flush :true)
        } else {
          order.errors.allErrors.each { println it }
        }
      }
    }

    Order.list().each { order ->
      (1..5).each { i ->
        def orderItem = new OrderItem(
            dish : Dish.get(i),
            count : 2,
            order : order
            )
        if (orderItem.validate()) {
          orderItem.save(flush :true)
        } else {
          orderItem.errors.allErrors.each { println it }
        }
      }
    }
    
    (1..10).each { i ->
      def city = new City(
        name : "城市$i"
        )
      if (city.validate()) {
        city.save(flush :true)
      } else {
        city.errors.allErrors.each { println it }
      }
    }
    
    City.list().each { city ->
      (1..5).each { i ->
        def district = new District(
          name : "白下区$i",
          city : city
          )
        if (district.validate()) {
          district.save(flush :true)
        } else {
          district.errors.allErrors.each { println it }
        }
        
        def hotArea = new HotArea(
          name : "热门商圈$i",
          city : city
          )
        if (hotArea.validate()) {
          hotArea.save(flush :true)
        } else {
          hotArea.errors.allErrors.each { println it }
        }
      }
    }
    
    District.list().each { district ->
      (1..5).each { i ->
        def area = new Area(
          name : "商圈$i",
          district : district
          )
        if (area.validate()) {
          area.save(flush :true)
        } else {
          area.errors.allErrors.each { println it }
        }
      }
    }
  }

  def destroy = {
  }
}
