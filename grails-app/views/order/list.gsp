
<%@ page import="meishi.Order" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-order" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'order.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="people" title="${message(code: 'order.people.label', default: 'People')}" />
					
						<th><g:message code="order.shop.label" default="Shop" /></th>
					
						<g:sortableColumn property="totalAmount" title="${message(code: 'order.totalAmount.label', default: 'Total Amount')}" />
					
						<g:sortableColumn property="totalCount" title="${message(code: 'order.totalCount.label', default: 'Total Count')}" />
					
						<th><g:message code="order.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${orderInstanceList}" status="i" var="orderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${orderInstance.id}">${fieldValue(bean: orderInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: orderInstance, field: "people")}</td>
					
						<td>${fieldValue(bean: orderInstance, field: "shop")}</td>
					
						<td>${fieldValue(bean: orderInstance, field: "totalAmount")}</td>
					
						<td>${fieldValue(bean: orderInstance, field: "totalCount")}</td>
					
						<td>${fieldValue(bean: orderInstance, field: "user")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${orderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
