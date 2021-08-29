package movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVUpdateProcCommand implements MVCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));		
		String[] genre_arr = request.getParameterValues("genre");
		String time = request.getParameter("time");
		int partner = Integer.parseInt(request.getParameter("partner"));
		String memo = request.getParameter("memo");
		
		String genre="";
		if(genre_arr==null) {
			genre="선택 장르 없음";
		}
		else {
			for(int i=0;i<genre_arr.length;i++) {
				if(i != genre_arr.length-1) {
					genre+=genre_arr[i]+",";
				}
				else {
					genre+=genre_arr[i];
				}
			}
		}
		MVBean mb = new MVBean(num,id,name,age,genre,time,partner,memo);
		MVDao mdao = MVDao.getInstance();
		mdao.UpdateCommand(mb);
		
	}

}
