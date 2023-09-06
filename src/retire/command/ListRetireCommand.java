package retire.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import retire.service.ListRetireService;
import retire.service.RetirePage;

public class ListRetireCommand implements CommandHandler{
	private ListRetireService listService = new ListRetireService();
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		RetirePage retirePage = listService.getRetirePage(pageNo);
		req.setAttribute("retirePage", retirePage);
		
		return "/WEB-INF/view/listRetire.jsp";
	}
}
