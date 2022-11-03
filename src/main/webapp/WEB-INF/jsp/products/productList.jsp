<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">
    <h2>Products</h2>

    <table id="ProductsTable" class="table table-striped">
        <thead>
        <tr>
        	<th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>ProductType</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
            	<td>
                    <c:out value="${product.id}"/></a>
                </td>
                <td>
                    <c:out value="${product.name}"/></a>
                </td>
                <td>
                    <c:out value="${product.price}"/>
                </td>
                <td>
                    <c:out value="${product.productType}"/>
                </td>

                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
