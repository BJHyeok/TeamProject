package employee.model;

import java.util.Date;

public class EmployeeInfo {
	private String emp_no;
	private Employee employee;
	private Date join_date;
	private Date resign_date;
	private String resident_no;
	private String phone;
	private String email;

	public EmployeeInfo(String emp_no, Employee employee, Date join_date, Date resign_date, String resident_no,
			String phone, String email) {
		super();
		this.emp_no = emp_no;
		this.employee = employee;
		this.join_date = join_date;
		this.resign_date = resign_date;
		this.resident_no = resident_no;
		this.phone = phone;
		this.email = email;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Date getResign_date() {
		return resign_date;
	}

	public void setResign_date(Date resign_date) {
		this.resign_date = resign_date;
	}

	public String getResident_no() {
		return resident_no;
	}

	public void setResident_no(String resident_no) {
		this.resident_no = resident_no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
