package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.service.EmployeePage;
import employee.service.ListEmployeeInfoService;
import mvc.command.CommandHandler;

public class ListEmployeeInfoHandler implements CommandHandler {
	
	private ListEmployeeInfoService listService = new ListEmployeeInfoService();
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		EmployeePage employeePage = listService.getEmployeePage(pageNo);
		req.setAttribute("employeePage", employeePage);
		
		return "/WEB-INF/view/listEmployeeInfo.jsp";
	}
}
