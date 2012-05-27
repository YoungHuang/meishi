
<%@ page import="meishi.Dish" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dish.label', default: 'Dish')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dish" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dish" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dish">
			
				<g:if test="${dishInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="dish.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${dishInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dishInstance?.dishCategory}">
				<li class="fieldcontain">
					<span id="dishCategory-label" class="property-label"><g:message code="dish.dishCategory.label" default="Dish Category" /></span>
					
						<span class="property-value" aria-labelledby="dishCategory-label"><g:link controller="dishCategory" action="show" id="${dishInstance?.dishCategory?.id}">${dishInstance?.dishCategory?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${dishInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="dish.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${dishInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dishInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="dish.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${dishInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${dishInstance?.id}" />
					<g:link class="edit" action="edit" id="${dishInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
