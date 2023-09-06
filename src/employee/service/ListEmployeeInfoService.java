package employee.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import employee.dao.EmployeeDao;
import employee.model.EmployeeInfo;
import jdbc.connection.ConnectionProvider;

public class ListEmployeeInfoService {
	private EmployeeDao employeeDao = new EmployeeDao();
	private int size = 10;
	
	public EmployeePage getEmployeePage(int pageNum) throws SQLException {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = employeeDao.selectCount(conn);
			List<EmployeeInfo> content = employeeDao.select(conn, pageNum);
			
			return new EmployeePage(total, pageNum, size, content);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
