package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteArticleService {
	ArticleDao articleDao = new ArticleDao();
	ArticleContentDao articleContentDao = new ArticleContentDao();
	
	public void delete(DeleteRequest delReq) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = articleDao.selectById(conn, delReq.getArticleNumber());
			
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			
			if(!canDelete(delReq.getUserId(), article)) {
				throw new DataNotFoundException();
			}
			
			articleDao.delete(conn, delReq.getArticleNumber());
			articleContentDao.delete(conn, delReq.getArticleNumber());
			
			conn.commit();			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public void allDelte() {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			articleDao.allDelete(conn);
		} catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canDelete(String deletingUserId, Article article) {
		return article.getWriter().getId().equals(deletingUserId);
	}
}
