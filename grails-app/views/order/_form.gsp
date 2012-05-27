<%@ page import="meishi.Order" %>



<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="order.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${orderInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'people', 'error')} required">
	<label for="people">
		<g:message code="order.people.label" default="People" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="people" required="" value="${fieldValue(bean: orderInstance, field: 'people')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'shop', 'error')} required">
	<label for="shop">
		<g:message code="order.shop.label" default="Shop" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="shop" name="shop.id" from="${meishi.Shop.list()}" optionKey="id" required="" value="${orderInstance?.shop?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'totalAmount', 'error')} required">
	<label for="totalAmount">
		<g:message code="order.totalAmount.label" default="Total Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalAmount" required="" value="${fieldValue(bean: orderInstance, field: 'totalAmount')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'totalCount', 'error')} required">
	<label for="totalCount">
		<g:message code="order.totalCount.label" default="Total Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="totalCount" required="" value="${fieldValue(bean: orderInstance, field: 'totalCount')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="order.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${meishi.User.list()}" optionKey="id" required="" value="${orderInstance?.user?.id}" class="many-to-one"/>
</div>

