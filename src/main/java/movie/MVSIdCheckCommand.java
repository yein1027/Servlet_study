package movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVSIdCheckCommand implements MVCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PrintWriter out=null;
		try {
			out = response.getWriter(); //3번 서블릿에서 했던 웹 출력 방식
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String userid = request.getParameter("userid");
		//System.out.print("userid:"+userid);
		
		MVDao mdao = MVDao.getInstance();
		boolean flag = mdao.idCheck(userid);
	
		String msg="";
		if(flag==true){
			msg="NO"; //테이블에서 찾았으니 사용 불가
			out.write(msg); //out은 jsp 내장 객체, 여기서는 요청에 대한 응답을 해줘야겠다, print도 됨.
		}
		else{
			msg="YES";
			out.append(msg); //테이블에 없으니 사용 가능
		}
	}

}
