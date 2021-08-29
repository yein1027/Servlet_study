package movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("*.mv")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext sContext;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		sContext = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request,response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String viewPage="";
		MVCommand mvc; 
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		int len=conPath.length();
		String command = uri.substring(len);
		
		if(command.equals("/insert.mv")) {
			System.out.println("insert.mv ��û��");
			
			String flag = (String)sContext.getAttribute("flag");
			
			if(flag.equals("false")) {
				mvc = new MVInsertCommand();
				mvc.execute(request, response);
				sContext.setAttribute("flag", "true");
			}
			
			viewPage="/list.mv";
		}
		
		else if(command.equals("/list.mv")) {
			System.out.println("list.mv ��û ��");
			mvc = new MVListCommand();
			mvc.execute(request, response);
			
			viewPage="list.jsp";
		}
		
		else if(command.equals("/updateForm.mv")) {
			System.out.println("updateForm.mv ��û ��");
			mvc = new MVUpdateFormCommand();
			mvc.execute(request, response);
			
			viewPage="updateForm.jsp";
			
		}
		
		else if(command.equals("/updateProc.mv")) {
			System.out.println("updateProc.mv ��û ��");
			mvc = new MVUpdateProcCommand();
			mvc.execute(request, response);
			
			viewPage="/list.mv";
		}
		
		
		else if(command.equals("/delete.mv")) {
			System.out.println("delete.mv ��û ��");
			mvc = new MVDeleteCommand();
			mvc.execute(request, response);
			
			viewPage="/list.mv";
		}
		
		else if(command.equals("/alldelete.mv")) {
			System.out.println("alldelete.mv ��û ��");
			mvc = new MVSelectDeleteCommand();
			mvc.execute(request, response);
			
			viewPage="/list.mv";
			
		}
		
			
		else if(command.equals("/idCheck.mv")) {
			System.out.println("idCheck.mv ��û ��");
			mvc = new MVSIdCheckCommand();
			mvc.execute(request, response);
			
			return; 
			//viewPage�� �� ���� ���� �׷��� ������ ���µ� ������ viewpage�� ����
			//�Ǿ� �����ϱ� �ؿ� �ڵ� �� ������ return �ؾ� �ȴ�
			
		}
		
		
		else if(command.equals("/content.mv")) {
			System.out.println("content.mv ��û ��");
			mvc = new MVContentCommand();
			mvc.execute(request, response);
			
			viewPage="contentView.jsp";
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
	
}//
