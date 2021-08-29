<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
list.jsp<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script type="text/javascript">

	function allDelete(){
			
		var allchk = document.myform.allcheck.checked;
		var selchk = document.getElementsByName("rowCheck");
		
		if(allchk == true){
			for(i=0;i<selchk.length;i++){
				selchk[i].checked=true;
			}
		}
		else{
			for(i=0;i<selchk.length;i++){
				selchk[i].checked=false;
			}
		}
		
		
		}//allDelete
		
		
		function selectDel(){
			//alert(1);
			      
			var selchk = document.myform.rowCheck;
			
			var flag=false;
			for(i=0;i<selchk.length;i++){
				if(selchk[i].checked){
					flag=true;
				}				
			}
			
			if(!flag){
				alert('체크박스 선택하세요');
				return;
			}
			document.myform.submit();
		} 
</script>


<form action="alldelete.mv" method="post" name="myform">
<input type="button" value="삭제" onClick="selectDel()">
<input type="button" value="추가" onClick="location.href='insertForm.jsp'">

<table border="1" width="80%">
	<tr align="center">
		<td><input type="checkbox" name="allcheck" onClick="allDelete()"></td>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
		<td>좋아하는 장르</td>
		<td>즐겨보는 시간대</td>
		<td>동반 관객수</td>
		<td>개선사항</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	
	<c:forEach var="list" items="${list }">
	
		<tr align="center">
			<td><input type="checkbox" name="rowCheck" value="${list.num }"></td>
			<td>${list.num }</td>
			<td>
			<a href="content.mv?id=${list.id }">${list.id }</a>
			</td>
			<td>${list.name }</td>
			<td>${list.age }</td>
			<td>${list.genre }</td>
			<td>${list.time }</td>
			<td>${list.partner }</td>
			<td>${list.memo }</td>
			<td>
				<a href="updateForm.mv?num=${list.num }">수정</a>
			</td>
			<td>
				<a href="delete.mv?num=${list.num }">삭제</a>
			</td>
		</tr>
	
	</c:forEach>
	</table>
</form>    