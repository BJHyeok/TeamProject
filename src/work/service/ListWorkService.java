package work.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import employee.model.Employee;
import jdbc.connection.ConnectionProvider;
import work.dao.WorkDao;

public class ListWorkService {
	private WorkDao workDao = new WorkDao();
	private int size = 10;
	
	public WorkPage getWorkPage(int pageNum) throws SQLException {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = workDao.selectCount(conn);
			List<Employee> content = workDao.select(conn, pageNum);
			
			return new WorkPage(total, pageNum, size, content);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
