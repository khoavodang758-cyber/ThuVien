<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.book" %>
<%
List<book> books =
    (List<book>) request.getAttribute("books");
%>
<h1>
Books object =
<%= books %>
</h1>

<h1>
Size =
<%= books == null ? "NULL" : books.size() %>
</h1>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Danh sách sách</h2>
<form action="addBook" method="post">

Tên sách:
<input type="text" name="title"><br><br>

Tác giả:
<input type="text" name="author"><br><br>

Nhà xuất bản:
<input type="text" name="publisher"><br><br>

Năm xuất bản:
<input type="number" name="publishYear"><br><br>

Số lượng:
<input type="number" name="quantity"><br><br>

Mã thể loại:
<input type="number" name="categoryID"><br><br>

Tên file ảnh:
<input type="text" name="image"><br><br>

<input type="submit" value="Thêm sách">

</form>
<table border="1">

<tr>
    <th>ID</th>
    <th>Ảnh</th>
    <th>Tên sách</th>
    <th>Tác giả</th>
    <th>Số lượng</th>
</tr>

<%
for(book b : books){
%>

<tr>

<td>
<%= b.getBookID() %>
</td>

<td>

<img
src="images/<%= b.getImage() %>"
width="100">

</td>

<td>
<%= b.getTitle() %>
</td>

<td>
<%= b.getAuthor() %>
</td>

<td>
<%= b.getQuantity() %>
</td>

</tr>

<%
}
%>
<%
if(books == null){
%>

<h3>Books = NULL</h3>

<%
}else{
%>

<h3>So luong:
<%= books.size() %>
</h3>

<%
}
%>
<%
for(book b : books){
%>

<p>
<%= b.getTitle() %>
</p>

<%
}
%>

</table>
</body>
</html>