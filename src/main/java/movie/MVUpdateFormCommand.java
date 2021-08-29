package movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVUpdateFormCommand implements MVCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MVDao mdao = MVDao.getInstance();
		MVBean mb = mdao.oneCommand(num);
		
		request.setAttribute("mb", mb);
	}

}
