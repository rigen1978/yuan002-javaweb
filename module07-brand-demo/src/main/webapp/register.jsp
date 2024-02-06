<%--
  Created by IntelliJ IDEA.
  User: rigen
  Date: 2024/02/04
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ユーザー登録</title>
	<link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
	<div class="reg-content">
		<h1>登録</h1>
		<span>アカウントが持っている</span> <a href="login.jsp">ログイン</a>
	</div>
	<form id="reg-form" action="/module07-brand-demo/registerServlet" method="post">

		<table>

			<tr>
				<td>ユーザ名</td>
				<td class="inputs">
					<input name="username" type="text" id="username">
					<br>
					<span id="username_err" class="err_msg">${register_msg}</span>
				</td>

			</tr>

			<tr>
				<td>パスワード</td>
				<td class="inputs">
					<input name="password" type="password" id="password">
					<br>
					<span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
				</td>
			</tr>


			<tr>
				<td>認証コード</td>
				<td class="inputs">
					<input name="checkCode" type="text" id="checkCode">
					<img id="checkCodeImg" src="/module07-brand-demo/checkCodeServlet">
					<a href="#" id="changeImg">もう一度？</a>
				</td>
			</tr>

		</table>

		<div class="buttons">
			<input value="登録" type="submit" id="reg_btn">
		</div>
		<br class="clear">
	</form>

</div>

<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "/module07-brand-demo/checkCodeServlet?" + new Date().getMilliseconds();
    }

</script>
</body>
</html>
