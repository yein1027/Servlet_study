<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
contentView.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>${mb.num}</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${mb.id }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${mb.name }</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${mb.age }</td>
	</tr>
	<tr>
		<td>좋아하는 장르</td>
		<td>${mb.genre }</td>
	</tr>
	<tr>
		<td>즐겨보는 시간대</td>
		<td>${mb.time }</td>
	</tr>
	<tr>
		<td>동반 관객수</td>
		<td>${mb.partner }</td>
	</tr>
	
	<tr>
		<td>영화관 개선사항</td>
		<td>${mb.memo }</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<a href="list.mv">목록보기</a>
		</td>
	</tr>
</table>

체크박스, 라디오, 셀렉트 옵션 꼭 들어가게 테이블 하나 자리로. 주제 정해서.