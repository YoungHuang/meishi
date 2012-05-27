<%@ page import="meishi.DishCategory" %>



<div class="fieldcontain ${hasErrors(bean: dishCategoryInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="dishCategory.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${dishCategoryInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dishCategoryInstance, field: 'shop', 'error')} required">
	<label for="shop">
		<g:message code="dishCategory.shop.label" default="Shop" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="shop" name="shop.id" from="${meishi.Shop.list()}" optionKey="id" required="" value="${dishCategoryInstance?.shop?.id}" class="many-to-one"/>
</div>

