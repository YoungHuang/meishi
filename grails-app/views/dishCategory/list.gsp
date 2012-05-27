
<%@ page import="meishi.DishCategory" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dishCategory.label', default: 'DishCategory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dishCategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dishCategory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'dishCategory.name.label', default: 'Name')}" />
					
						<th><g:message code="dishCategory.shop.label" default="Shop" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dishCategoryInstanceList}" status="i" var="dishCategoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dishCategoryInstance.id}">${fieldValue(bean: dishCategoryInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: dishCategoryInstance, field: "shop")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dishCategoryInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
