<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="./js/jquery.js"></script> 
<script type="text/javascript">
	$(document).ready(function(){
	
		var onidcheck=false;
		
		$('#id_Check').click(function(){ //중복 체크 했을 때
			onidcheck=true;
		
			//alert(1);
			 if($('input[name="id"]').val()==""){
				alert('아이디를 입력하세요');
				$('input[name="id"]').focus();
				return;
			}
					 
			 $.ajax({
				url : "idCheck.mv",
				data : ({
					userid : $('input[name="id"]').val()
				}),
				success:function(data){
					alert(data);
					if($.trim(data)=='YES'){
						$('#idmessage').html("<font color=red>사용 가능합니다</font>");
						$('#idmessage').show();
						use = "possible";
					}
					else{
						$('#idmessage').html("<font color=red>중복입니다</font>");
						$('#idmessage').show();
						use = "impossible";
					}
				}//success
				
			});//ajax  
		
		});//idCheck
		
		$('input[name="id"]').keydown(function(){
			$('#idmessage').css('display','none');
			onidcheck=false;
			use="";
		})//keydown
		
		$('#subm').click(function(){
			
			if(onidcheck==false){
				alert('중복체크는 필수입니다');
				return false
			}
			
			if(use == "impossible"){
				alert('중복 아이디입니다');
				$('input[name="id"]').select();
				return false;
			}
		})//subm
		
		
	});//ready
	
</script>



	 
    
insertForm.jsp<br>
<%	application.setAttribute("flag", "false"); %>
<h2>영화 선호도 조사 </h2>
	<form action="insert.mv" method="post">
		<table border="1" width="700px">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" value="IU">
					<input type="button" id="id_Check" value="중복체크">
					<span id="idmessage" style="display: none;">출력왜안돼</span>	
				</td>
			</tr>
		
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="아이유"></td>
			</tr>
			
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="20"></td>
			</tr>
		
			<tr>
				<td>좋아하는 장르</td>
				<td>
					<input type="checkbox" name="genre" value="공포">공포
					<input type="checkbox" name="genre" value="다큐">다큐
					<input type="checkbox" name="genre" value="액션">액션
					<input type="checkbox" name="genre" value="애니메이션">애니메이션
				</td>
			</tr>
			
			<tr>
				<td>즐겨보는 시간대</td>
				<td>
					<select name="time">
						<option value="08~10">08~10</option>
						<option value="10~12">10~12</option>
						<option value="12~14">12~14</option>
						<option value="14~16">14~16</option>
						<option value="16~18">16~18</option>
						<option value="18~20">18~20</option>
					</select>
				</td>
			</tr>
		
			<tr>
				<td>동반 관객수</td>
				<td>
					<input type="radio" name="partner" value="1">1
					<input type="radio" name="partner" value="2">2
					<input type="radio" name="partner" value="3">3
					<input type="radio" name="partner" value="4">4
				</td>
			</tr>
			
			<tr>
				<td>영화관 개선 사항</td>
				<td>
					<textarea name="memo" cols="40" rows="5">개선사항 쓰기</textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" id="subm" value="가입하기">
				</td>
			</tr>
		</table>	
	</form>	