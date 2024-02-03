<%@ page import="com.yuan.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rigen
  Date: 2024/02/03
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--仮データ--%>
<%
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1, "本田", "本田自動車", 100, "乗りやすい", 1));
    brands.add(new Brand(2, "日産", "日産自動車", 200, "安い", 0));
    brands.add(new Brand(3, "トヨタ", "トヨタ自動車", 1000, "安い,乗りやすい", 1));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="登録"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr align="center">
        <th>番号</th>
        <th>メーカー</th>
        <th>企業</th>
        <th>ランキング</th>
        <th>紹介</th>
        <th>状態</th>
        <th>操作</th>
    </tr>

    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>
    <tr>
        <td>
            <%=brand.getId()%>
        </td>
        <td>
            <%=brand.getBrandName()%>
        </td>
        <td>
            <%=brand.getCompanyName()%>
        </td>
        <td>
            <%=brand.getOrdered()%>
        </td>
        <td>
            <%=brand.getDescription()%>
        </td>

        <%
            if (brand.getStatus() == 1) {
        %>
        <td><%="起動"%>
        </td>

        <%
        } else {
        %>

        <td><%="禁止"%>
        </td>

        <%
            }
        %>

        <td><a href="#">変更</a> <a href="#">削除</a></td>
    </tr>
    <%
        }
    %>


</table>

</body>
</html>
