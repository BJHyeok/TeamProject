package salary.model;

import java.util.Date;

import employee.model.Employee;

public class Salary {
	private String emp_no;
	private Date wage_date;
	private Employee employee;

	public Salary(String emp_no, Date wage_date, Employee employee) {
		super();
		this.emp_no = emp_no;
		this.wage_date = wage_date;
		this.employee = employee;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public Date getWage_date() {
		return wage_date;
	}

	public void setWage_date(Date wage_date) {
		this.wage_date = wage_date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
