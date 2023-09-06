package salary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import salary.dao.SalaryDao;
import salary.model.Salary;
import salary.model.SalaryDetail;
import salary.model.SalaryPay;

public class ListSalaryService {
	private SalaryDao salaryDao = new SalaryDao();
	private int size = 10;
	
	public SalaryPage getSalaryPage(int pageNum) throws SQLException {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = salaryDao.selectCount(conn);
			List<Salary> content_salary = salaryDao.select(conn, pageNum);
			List<SalaryPay> content_paylist = salaryDao.selectPay(conn);

			List<SalaryDetail> content = new ArrayList<SalaryDetail>() ;
			CalcSalary calc = new CalcSalary();
			for(int i = 0; i < content_paylist.size(); i++ ) {
				double total_1 = calc.calc_total(content_paylist.get(i));
				double deduct = calc.calc_deduct(total_1);
				double real = calc.calc_real(content_paylist.get(i));
				
				SalaryDetail detail = new SalaryDetail(content_salary.get(i), total_1, deduct, real);
				content.add(detail);
			}
			
			return new SalaryPage(total, pageNum, size, content);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
