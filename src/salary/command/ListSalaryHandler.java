package salary.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import salary.service.ListSalaryService;
import salary.service.SalaryPage;

public class ListSalaryHandler implements CommandHandler{
	private ListSalaryService listService = new ListSalaryService();

	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;

		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}

		SalaryPage salaryPage = listService.getSalaryPage(pageNo);
		req.setAttribute("salaryPage", salaryPage);

		return "/WEB-INF/view/listSalary.jsp";
	}
}
