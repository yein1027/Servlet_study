package movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVSelectDeleteCommand implements MVCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] rowcheck = request.getParameterValues("rowCheck");
	
		
		MVDao mdao = MVDao.getInstance();
		mdao.selectDelete(rowcheck);
	}

}
