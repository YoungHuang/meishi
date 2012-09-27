<%@ page import="meishi.District" %>



<div class="fieldcontain ${hasErrors(bean: districtInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="district.city.label" default="City" />
		
	</label>
	<g:select id="city" name="city.id" from="${meishi.City.list()}" optionKey="id" value="${districtInstance?.city?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: districtInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="district.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${districtInstance?.name}"/>
</div>

