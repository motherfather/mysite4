<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="gallery">
				<div>
					<h1>갤러리</h1>
					<a href="${pageContext.request.contextPath }/gallery" id="upload-image">리스트 가기</a>
				</div><br><br><br>
				<div>
					<form method="post" action="${pageContext.request.contextPath }/gallery/upload" enctype="mulitpart/form-data">
						<input type="hidden" value=${no }>
						<label>내용:</label>
						<input type="text" name="comment" title="코멘트 입력" placeholder="코멘트를 입력하세요">
						<br><br>
						<label>파일:</label>
						<input type="file" name="file">
						<br><br>
						<input type="submit" value="업로드" title="업로드">
					</form>
				</div>		
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="gallery"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>