
<%@ page import="meishi.Dish" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dish.label', default: 'Dish')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dish" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dish" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'dish.description.label', default: 'Description')}" />
					
						<th><g:message code="dish.dishCategory.label" default="Dish Category" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'dish.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'dish.price.label', default: 'Price')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dishInstanceList}" status="i" var="dishInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dishInstance.id}">${fieldValue(bean: dishInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: dishInstance, field: "dishCategory")}</td>
					
						<td>${fieldValue(bean: dishInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: dishInstance, field: "price")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dishInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
