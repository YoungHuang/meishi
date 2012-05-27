
<%@ page import="meishi.Shop" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'shop.label', default: 'Shop')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-shop" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-shop" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list shop">
			
				<g:if test="${shopInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="shop.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${shopInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="shop.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${shopInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.district}">
				<li class="fieldcontain">
					<span id="district-label" class="property-label"><g:message code="shop.district.label" default="District" /></span>
					
						<span class="property-value" aria-labelledby="district-label"><g:fieldValue bean="${shopInstance}" field="district"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="shop.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${shopInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.logoName}">
				<li class="fieldcontain">
					<span id="logoName-label" class="property-label"><g:message code="shop.logoName.label" default="Logo Name" /></span>
					
						<span class="property-value" aria-labelledby="logoName-label"><g:fieldValue bean="${shopInstance}" field="logoName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="shop.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${shopInstance}" field="longitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="shop.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${shopInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="property-label"><g:message code="shop.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${shopInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.province}">
				<li class="fieldcontain">
					<span id="province-label" class="property-label"><g:message code="shop.province.label" default="Province" /></span>
					
						<span class="property-value" aria-labelledby="province-label"><g:fieldValue bean="${shopInstance}" field="province"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.rating}">
				<li class="fieldcontain">
					<span id="rating-label" class="property-label"><g:message code="shop.rating.label" default="Rating" /></span>
					
						<span class="property-value" aria-labelledby="rating-label"><g:fieldValue bean="${shopInstance}" field="rating"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.road}">
				<li class="fieldcontain">
					<span id="road-label" class="property-label"><g:message code="shop.road.label" default="Road" /></span>
					
						<span class="property-value" aria-labelledby="road-label"><g:fieldValue bean="${shopInstance}" field="road"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shopInstance?.startPrice}">
				<li class="fieldcontain">
					<span id="startPrice-label" class="property-label"><g:message code="shop.startPrice.label" default="Start Price" /></span>
					
						<span class="property-value" aria-labelledby="startPrice-label"><g:fieldValue bean="${shopInstance}" field="startPrice"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${shopInstance?.id}" />
					<g:link class="edit" action="edit" id="${shopInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
