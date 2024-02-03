<%--
  Created by IntelliJ IDEA.
  User: rigen
  Date: 2024/02/04
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
	<tr>
		<th>番号</th>
		<th>メーカー</th>
		<th>企業</th>
		<th>ランキング</th>
		<th>紹介</th>
		<th>状態</th>
		<th>操作</th>
	</tr>


	<c:forEach items="${brands}" var="brand" varStatus="status">
		<tr align="center">
				<%--<td>${brand.id}</td>--%>
			<td>${status.count}</td>
			<td>${brand.brandName}</td>
			<td>${brand.companyName}</td>
			<td>${brand.ordered}</td>
			<td>${brand.description}</td>
			<c:if test="${brand.status == 1}">
				<td>起動</td>
			</c:if>
			<c:if test="${brand.status != 1}">
				<td>禁止</td>
			</c:if>

			<td><a href="#">変更</a> <a href="#">削除</a></td>
		</tr>

	</c:forEach>


</table>


<hr>

<c:forEach begin="1" end="10" step="1" var="i">
	<a href="#">${i}</a>
</c:forEach>


</body>
</html>
