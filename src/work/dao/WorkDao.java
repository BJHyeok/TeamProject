package work.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employee.model.Employee;
import jdbc.JdbcUtil;

public class WorkDao {
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from "
					+ "(select * "
					+ "from emp e "
					+ "join employeeinfo ei "
					+ "on e.emp_no = ei.emp_no "
					+ "order by e.emp_no desc)");
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Employee> select(Connection conn, int page) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from( "
					+ "select rownum rnum, a.*  "
					+ "from (select * from emp order by emp_no desc) a) "
					+ "where rnum between ? and ?");

			pstmt.setInt(1, 1 + (page - 1) * 10 );
			pstmt.setInt(2, page * 10);
			
			rs = pstmt.executeQuery();
			
			List<Employee> result = new ArrayList<>();
			
			while(rs.next()) {
				result.add(convertEmployee(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Employee convertEmployee(ResultSet rs) throws SQLException {
		return new Employee(rs.getString("emp_no"), 
				rs.getString("classify"), 
				rs.getString("emp_name"), 
				rs.getString("dept"), 
				rs.getString("position"));

	}


}
