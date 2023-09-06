package salary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employee.model.Employee;
import jdbc.JdbcUtil;
import salary.model.Salary;
import salary.model.SalaryPay;

public class SalaryDao {
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from "
					+ "(select e.*, s.wage_date "
					+ "from emp e "
					+ "join salary s "
					+ "on e.emp_no = s.emp_no "
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
	
	public List<SalaryPay> selectPay(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from salary_item where emp_no='1000'");
			List<SalaryPay> result = new ArrayList<>();
			
			while(rs.next()) {
				result.add(convertSalaryPay(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	private SalaryPay convertSalaryPay(ResultSet rs) throws SQLException {
		return new SalaryPay(rs.getString("emp_no"), 
				rs.getInt("base_pay"), 
				rs.getInt("food"), 
				rs.getInt("duty_charge"), 
				rs.getInt("transport"), 
				rs.getInt("bonus"));
	}
	
	public List<Salary> select(Connection conn, int page) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from( "
					+ "select rownum rnum, n.*  "
					+ "from (select e.*, s.wage_date "
					+ "from emp e "
					+ "join salary s "
					+ "on e.emp_no = s.emp_no "
					+ "order by e.emp_no desc) n) "
					+ "where rnum between ? and ?");

			pstmt.setInt(1, 1 + (page - 1) * 10 );
			pstmt.setInt(2, page * 10);
			
			rs = pstmt.executeQuery();
			
			List<Salary> result = new ArrayList<>();
			
			while(rs.next()) {
				result.add(convertSalaryDetail(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Salary convertSalaryDetail(ResultSet rs) throws SQLException {
		return new Salary(rs.getString("emp_no"), 
				toDate(rs.getDate("wage_date")), 
				new Employee(rs.getString("emp_no"), rs.getString("classify"), rs.getString("emp_name"), rs.getString("dept"), rs.getString("position")));
	}

	
	private Date toDate(Date date) {
		if (date!=null)
			return new Date(date.getTime());
		return null;
	}
}
