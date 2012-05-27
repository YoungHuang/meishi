<%@ page import="meishi.Dish" %>



<div class="fieldcontain ${hasErrors(bean: dishInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="dish.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${dishInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dishInstance, field: 'dishCategory', 'error')} required">
	<label for="dishCategory">
		<g:message code="dish.dishCategory.label" default="Dish Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="dishCategory" name="dishCategory.id" from="${meishi.DishCategory.list()}" optionKey="id" required="" value="${dishInstance?.dishCategory?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dishInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="dish.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${dishInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dishInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="dish.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="price" required="" value="${fieldValue(bean: dishInstance, field: 'price')}"/>
</div>

