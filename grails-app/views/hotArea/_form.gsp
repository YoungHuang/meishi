<%@ page import="meishi.HotArea" %>



<div class="fieldcontain ${hasErrors(bean: hotAreaInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="hotArea.city.label" default="City" />
		
	</label>
	<g:select id="city" name="city.id" from="${meishi.City.list()}" optionKey="id" value="${hotAreaInstance?.city?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hotAreaInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="hotArea.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${hotAreaInstance?.name}"/>
</div>

