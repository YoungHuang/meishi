<%@ page import="meishi.OrderItem" %>



<div class="fieldcontain ${hasErrors(bean: orderItemInstance, field: 'dish', 'error')} required">
	<label for="dish">
		<g:message code="orderItem.dish.label" default="Dish" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="dish" name="dish.id" from="${meishi.Dish.list()}" optionKey="id" required="" value="${orderItemInstance?.dish?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderItemInstance, field: 'order', 'error')} required">
	<label for="order">
		<g:message code="orderItem.order.label" default="Order" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="order" name="order.id" from="${meishi.Order.list()}" optionKey="id" required="" value="${orderItemInstance?.order?.id}" class="many-to-one"/>
</div>

