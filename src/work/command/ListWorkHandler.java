package work.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import work.service.ListWorkService;
import work.service.WorkPage;

public class ListWorkHandler implements CommandHandler{
	private ListWorkService listService = new ListWorkService();
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		WorkPage workPage = listService.getWorkPage(pageNo);
		req.setAttribute("workPage", workPage);
		
		return "/WEB-INF/view/listWorkList.jsp";
	}
}
