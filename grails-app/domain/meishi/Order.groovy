package meishi

import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 */
class Order {
  final static Integer STATUS_NEW = 0;
  final static Integer STATUS_CONFIRM = 1;

  /** 商家 **/
  Shop shop;
  /** 总金额 **/
  Double totalAmount = 0.0
  /** 总计份数 **/
  Integer totalCount = 0
  /** 就餐人数 **/
  Integer people = 0
  /** 备注 **/
  String description
  /** 状态 **/
  Integer status = STATUS_NEW
  /** 订单列表 **/
  List<OrderItem> orderItemList = new ArrayList<OrderItem>()

  static belongsTo = [user : User]

  static mapping = { table "meishi_order" }

  static constraints = {
  }
}
