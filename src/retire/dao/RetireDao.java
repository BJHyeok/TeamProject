package retire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employee.model.Employee;
import employee.model.EmployeeInfo;
import jdbc.JdbcUtil;

public class RetireDao {
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from emp");
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<EmployeeInfo> select(Connection conn, int page) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from( "
					+ "select rownum rnum, n.* "
					+ "from (select * "
					+ "from emp e "
					+ "join employeeinfo ei "
					+ "on e.emp_no = ei.emp_no "
					+ "order by e.emp_no desc) n) "
					+ "where rnum between ? and ?");

			pstmt.setInt(1, 1 + (page - 1) * 10 );
			pstmt.setInt(2, page * 10);
			
			rs = pstmt.executeQuery();
			
			List<EmployeeInfo> result = new ArrayList<>();
			
			while(rs.next()) {
				result.add(convertEmployee(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private EmployeeInfo convertEmployee(ResultSet rs) throws SQLException {
		return new EmployeeInfo(rs.getString("emp_no"), 
				new Employee(rs.getString("emp_no"), rs.getString("classify"), rs.getString("emp_name"), rs.getString("dept"), rs.getString("position")), 
				toDate(rs.getDate("join_date")), 
				toDate(rs.getDate("resign_date")), 
				rs.getString("resident_no"), 
				rs.getString("phone"), 
				rs.getString("email"));

	}

	
	private Date toDate(Date date) {
		if (date!=null)
			return new Date(date.getTime());
		return null;
	}
}
