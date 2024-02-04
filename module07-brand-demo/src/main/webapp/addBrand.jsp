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
	<title>新規メーカー</title>
</head>
<body>
<h3>メーカー追加</h3>
<form action="/module07-brand-demo/addServlet" method="post">
	メーター名称：<input name="brandName"><br>
	会社名：<input name="companyName"><br>
	ランキング：<input name="ordered"><br>
	インフォメーション：<textarea rows="5" cols="20" name="description"></textarea><br>
	状態：
	<input type="radio" name="status" value="0">禁止
	<input type="radio" name="status" value="1">起動<br>

	<input type="submit" value="登録">
</form>
</body>
</html>
