
<%@ page import="meishi.Shop" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'shop.label', default: 'Shop')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-shop" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-shop" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="city" title="${message(code: 'shop.city.label', default: 'City')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'shop.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="district" title="${message(code: 'shop.district.label', default: 'District')}" />
					
						<g:sortableColumn property="latitude" title="${message(code: 'shop.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="logoName" title="${message(code: 'shop.logoName.label', default: 'Logo Name')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'shop.longitude.label', default: 'Longitude')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${shopInstanceList}" status="i" var="shopInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${shopInstance.id}">${fieldValue(bean: shopInstance, field: "city")}</g:link></td>
					
						<td>${fieldValue(bean: shopInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: shopInstance, field: "district")}</td>
					
						<td>${fieldValue(bean: shopInstance, field: "latitude")}</td>
					
						<td>${fieldValue(bean: shopInstance, field: "logoName")}</td>
					
						<td>${fieldValue(bean: shopInstance, field: "longitude")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${shopInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
