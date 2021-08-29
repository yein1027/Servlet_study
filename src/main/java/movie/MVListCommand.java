package movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVListCommand implements MVCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MVDao mdao = MVDao.getInstance();
		ArrayList<MVBean> list = mdao.getAllCommand();
		
		request.setAttribute("list", list);
		
	}

}
