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
		    }
		    else {
				shop.errors.allErrors.each {
					println it
				}
		    }
		}
    }
	
    def destroy = {
    }
}
