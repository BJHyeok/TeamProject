package retire.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import employee.model.EmployeeInfo;
import jdbc.connection.ConnectionProvider;
import retire.dao.RetireDao;

public class ListRetireService {
	private RetireDao retireDao = new RetireDao();
	private int size = 10;

	public RetirePage getRetirePage(int pageNum) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = retireDao.selectCount(conn);
			List<EmployeeInfo> content = retireDao.select(conn, pageNum);

			return new RetirePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
