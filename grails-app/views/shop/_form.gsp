<%@ page import="meishi.Shop" %>



<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="shop.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${shopInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="shop.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${shopInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'district', 'error')} ">
	<label for="district">
		<g:message code="shop.district.label" default="District" />
		
	</label>
	<g:textField name="district" value="${shopInstance?.district}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="shop.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="latitude" required="" value="${fieldValue(bean: shopInstance, field: 'latitude')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'logoName', 'error')} ">
	<label for="logoName">
		<g:message code="shop.logoName.label" default="Logo Name" />
		
	</label>
	<g:textField name="logoName" value="${shopInstance?.logoName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="shop.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="longitude" required="" value="${fieldValue(bean: shopInstance, field: 'longitude')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="shop.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${shopInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="shop.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" value="${shopInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'province', 'error')} ">
	<label for="province">
		<g:message code="shop.province.label" default="Province" />
		
	</label>
	<g:textField name="province" value="${shopInstance?.province}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'rating', 'error')} required">
	<label for="rating">
		<g:message code="shop.rating.label" default="Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="rating" required="" value="${fieldValue(bean: shopInstance, field: 'rating')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'road', 'error')} ">
	<label for="road">
		<g:message code="shop.road.label" default="Road" />
		
	</label>
	<g:textField name="road" value="${shopInstance?.road}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'startPrice', 'error')} required">
	<label for="startPrice">
		<g:message code="shop.startPrice.label" default="Start Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="startPrice" required="" value="${fieldValue(bean: shopInstance, field: 'startPrice')}"/>
</div>

