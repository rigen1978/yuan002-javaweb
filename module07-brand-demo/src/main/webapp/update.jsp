<%--
  Created by IntelliJ IDEA.
  User: rigen
  Date: 2024/02/04
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>メーカー更新</title>
</head>
<body>
<h3>メーカー更新</h3>
<form action="/module07-brand-demo/updateServlet" method="post">
	<%--idが必要--%>
	<input type="hidden" name="id" value="${brand.id}">

	メーター名称：<input name="brandName" value="${brand.brandName}"><br>
	会社名：<input name="companyName" value="${brand.companyName}"><br>
	ランキング：<input name="ordered" value="${brand.ordered}"><br>
	インフォメーション：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
	状態：
	<c:if test="${brand.status==0}">
		<input type="radio" name="status" value="0" checked>禁止
		<input type="radio" name="status" value="1">起動<br>
	</c:if>

	<c:if test="${brand.status==1}">
		<input type="radio" name="status" value="0">禁止
		<input type="radio" name="status" value="1" checked>起動<br>
	</c:if>


	<input type="submit" value="登録">
</form>
</body>
</html>
