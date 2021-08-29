package movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MVCommand {

	void execute(HttpServletRequest request, HttpServletResponse response);
}
