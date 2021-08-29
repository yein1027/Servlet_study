package movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVInsertCommand implements MVCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] genre_arr = request.getParameterValues("genre");
		String time = request.getParameter("time");
		int partner = Integer.parseInt(request.getParameter("partner"));
		String memo = request.getParameter("memo");
		
		String genre=null;
		if(genre_arr==null) { //�̰Ÿ� ���� �ؾ���. for�� �ȿ� ������ �� �Ǵ°� null�̶� for���� �� ����=nullpoint
			genre="���� �帣 ����";
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
		//System.out.println(id+name+age+genre+time+partner+memo);
		
		MVBean mb = new MVBean(0,id,name,age,genre,time,partner,memo);
		MVDao mdao = MVDao.getInstance();
		mdao.insertCommand(mb);
		
	}

}
