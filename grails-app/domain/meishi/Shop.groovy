package meishi

import java.util.List;

/**
* 餐厅
*/
class Shop {
	/** 餐厅名 **/
	String name
	/** 评价 **/
	float rating
	/** 电话 **/
	String phone
	/** 起送金额 **/
	Double startPrice
	/** logo图片名 **/
	String logoName
	/** 简介 **/
	String description
	
	/** 地址 **/
	String province
	String city
	String district
	String road
	/** 纬度 **/
	Double latitude
	/** 经度 **/
	Double longitude
	
	/** 菜单目录列表 **/
	List<DishCategory> dishCategories
	
    static constraints = {
    }
}
