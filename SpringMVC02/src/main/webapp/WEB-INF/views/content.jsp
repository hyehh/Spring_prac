<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>

	<form action="modify" method="post">
	
		<table border="1">
			<tr>
				<td><input type="hidden" name="bId" value="${content.bId }"></td>
			</tr>
				
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value = "${content.bName }" size="20"></td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value = "${content.bTitle }" size="50"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="10">${content.bContent }</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="delete?bId=${content.bId }">삭제</a>
				&nbsp;&nbsp;&nbsp;<a href="list">목록</a></td>
			</tr>
					
		</table>
	
	</form>
	
</body>
</html>