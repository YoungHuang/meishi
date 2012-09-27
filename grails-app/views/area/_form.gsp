<%@ page import="meishi.Area" %>



<div class="fieldcontain ${hasErrors(bean: areaInstance, field: 'district', 'error')} ">
	<label for="district">
		<g:message code="area.district.label" default="District" />
		
	</label>
	<g:select id="district" name="district.id" from="${meishi.District.list()}" optionKey="id" value="${areaInstance?.district?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: areaInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="area.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${areaInstance?.name}"/>
</div>

