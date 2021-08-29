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
			out = response.getWriter(); //3�� �������� �ߴ� �� ��� ���
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String userid = request.getParameter("userid");
		//System.out.print("userid:"+userid);
		
		MVDao mdao = MVDao.getInstance();
		boolean flag = mdao.idCheck(userid);
	
		String msg="";
		if(flag==true){
			msg="NO"; //���̺��� ã������ ��� �Ұ�
			out.write(msg); //out�� jsp ���� ��ü, ���⼭�� ��û�� ���� ������ ����߰ڴ�, print�� ��.
		}
		else{
			msg="YES";
			out.append(msg); //���̺� ������ ��� ����
		}
	}

}
