
<%@page import="movie.MVDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 

	String userid = request.getParameter("userid");
	//System.out.print("userid:"+userid);
	
	MVDao mdao = MVDao.getInstance();
	boolean flag = mdao.idCheck(userid);
	
	String msg="";
	if(flag==true){
		msg="NO";
		out.print(msg);
	}
	else{
		msg="YES";
		out.print(msg);
	}

%>