package article.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import article.service.DeleteRequest;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/readArticle.jsp";
	private ReadArticleService readService = new ReadArticleService();
	private DeleteArticleService deleteService = new DeleteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		}
			else {
		
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		deleteService.allDelte();
		
		return "/WEB-INF/view/deleteSuccess.jsp";
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			ArticleData articleData = readService.getArticle(no, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			req.getSession().setAttribute("no", noVal);

			if (!canDelete(authUser, articleData)) {
				resp.sendError(HttpServletResponse.SC_FORBIDDEN);

				return null;
			}

			DeleteRequest delReq = new DeleteRequest(authUser.getId(), no, articleData.getArticle().getTitle(),
					articleData.getContent());

			req.setAttribute("delReq", delReq);

			Map<String, Boolean> errors = new HashMap<>();
			req.setAttribute("errors", errors);
			delReq.validate(errors);

			if (!errors.isEmpty()) {
				return FORM_VIEW;
			}

			deleteService.delete(delReq);

			return "/WEB-INF/view/deleteSuccess.jsp";
		} catch (ArticleNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);

			return null;
		}
	}

	private boolean canDelete(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();

		return authUser.getId().equals(writerId);
	}

}
