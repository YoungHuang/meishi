
<%@ page import="meishi.Order" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-order" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list order">
			
				<g:if test="${orderInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="order.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${orderInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInstance?.people}">
				<li class="fieldcontain">
					<span id="people-label" class="property-label"><g:message code="order.people.label" default="People" /></span>
					
						<span class="property-value" aria-labelledby="people-label"><g:fieldValue bean="${orderInstance}" field="people"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInstance?.shop}">
				<li class="fieldcontain">
					<span id="shop-label" class="property-label"><g:message code="order.shop.label" default="Shop" /></span>
					
						<span class="property-value" aria-labelledby="shop-label"><g:link controller="shop" action="show" id="${orderInstance?.shop?.id}">${orderInstance?.shop?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInstance?.totalAmount}">
				<li class="fieldcontain">
					<span id="totalAmount-label" class="property-label"><g:message code="order.totalAmount.label" default="Total Amount" /></span>
					
						<span class="property-value" aria-labelledby="totalAmount-label"><g:fieldValue bean="${orderInstance}" field="totalAmount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInstance?.totalCount}">
				<li class="fieldcontain">
					<span id="totalCount-label" class="property-label"><g:message code="order.totalCount.label" default="Total Count" /></span>
					
						<span class="property-value" aria-labelledby="totalCount-label"><g:fieldValue bean="${orderInstance}" field="totalCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="order.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${orderInstance?.user?.id}">${orderInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${orderInstance?.id}" />
					<g:link class="edit" action="edit" id="${orderInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
