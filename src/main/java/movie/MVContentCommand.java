package movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVContentCommand implements MVCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		MVDao mdao = MVDao.getInstance();
		MVBean mb = mdao.getContent(id);
		
		request.setAttribute("mb", mb);
		
	}

}
