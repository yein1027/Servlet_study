<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
updateForm.jsp<br>


<% 
	String[] genre_arr = {"공포","다큐","액션","애니메이션"};
	request.setAttribute("genre_arr", genre_arr);
	
	//굳이 여기에서 안 구하고 밑에서 genre_arr로 fn:length 이용해서 바로 출력도 가능함
	int genre_length = genre_arr.length-1;
	request.setAttribute("genre_length", genre_length);
	
	
%>
<h2>영화 선호도 조사 수정 </h2>
	<form action="updateProc.mv" method="post">
	<input type="hidden" name="num" value="${mb.num }">
		<table border="1" width="700px">
			<tr>
				<td>아이디</td>
				<td>
					${mb.id }
				</td>
			</tr>
		
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${mb.name }"></td>
			</tr>
			
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="${mb.age }"></td>
			</tr>
		
			<tr>
				<td>좋아하는 장르</td> 
				<td>  
					<%-- 위에서 길이 구해서 쓸 거면 이거 ${genre_length}. 바로 출력할 거면 아래. --%>
				<c:forEach var="i" begin="0" end="${fn:length(genre_arr)-1}" step="1">
					<input type="checkbox" name="genre" value="${genre_arr[i]}" 
					<c:if test="${fn:contains(mb.genre,genre_arr[i])}"> checked </c:if>>${genre_arr[i]}
				</c:forEach>
								
					<%-- <input type="checkbox" name="genre" value="공포" <c:if test="${fn:contains(mb.genre,'공포')}"> checked </c:if>>공포
					<input type="checkbox" name="genre" value="다큐" <c:if test="${fn:contains(mb.genre,'다큐')}"> checked </c:if>>다큐
					<input type="checkbox" name="genre" value="액션" <c:if test="${fn:contains(mb.genre,'액션')}"> checked </c:if>>액션
					<input type="checkbox" name="genre" value="애니메이션" <c:if test="${fn:contains(mb.genre,'애니메이션')}"> checked </c:if>>애니메이션 --%>
				</td>
			</tr>
			
			<tr>
				<td>즐겨보는 시간대</td>
				<td>
					<select name="time">
						<c:forEach var="i" begin="8" end="18" step="2">
							<option value="${i }~${i+2}"
								<c:if test="${fn:contains(mb.time,i) && fn:contains(mb.time,i+2) }"> selected</c:if>>${i}~${i+2 }
							</option> 
						</c:forEach>					
						
						<%-- <option value="8~10" <c:if test="${mb.time=='8~10'}"> selected </c:if>>8~10</option>
						<option value="10~12" <c:if test="${mb.time=='10~12'}"> selected </c:if>>10~12</option>
						<option value="12~14" <c:if test="${mb.time=='12~14'}"> selected </c:if>>12~14</option>
						<option value="14~16" <c:if test="${mb.time=='14~16'}"> selected </c:if>>14~16</option>
						<option value="16~18" <c:if test="${mb.time=='16~18'}"> selected </c:if>>16~18</option>
						<option value="18~20" <c:if test="${mb.time=='18~20'}"> selected </c:if>>18~20</option>
					 --%>
					</select>
				</td>
			</tr>
		
			<tr>
				<td>동반 관객수</td>
				<td>
					<c:forEach var="i" begin="1" end="4" step="1">
						<input type="radio" name="partner" value="${i }" <c:if test="${mb.partner==i}"> checked</c:if>>${i }
					</c:forEach>
					<%-- <input type="radio" name="partner" value="1" <c:if test="${mb.partner==1}"> checked </c:if>>1
					<input type="radio" name="partner" value="2" <c:if test="${mb.partner==2}"> checked </c:if>>2
					<input type="radio" name="partner" value="3" <c:if test="${mb.partner==3}"> checked </c:if>>3
					<input type="radio" name="partner" value="4" <c:if test="${mb.partner==4}"> checked </c:if>>4 --%>
				</td>
			</tr>
			
			<tr>
				<td>영화관 개선 사항</td>
				<td>
					<textarea name="memo" cols="40" rows="5">${mb.memo }</textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>	
	</form>	