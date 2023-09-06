package employee.model;

public class Employee {
	private String emp_no;
	private String classify;
	private String emp_name;
	private String dept;
	private String position;

	public Employee(String emp_no, String classify, String emp_name, String dept, String position) {
		super();
		this.emp_no = emp_no;
		this.classify = classify;
		this.emp_name = emp_name;
		this.dept = dept;
		this.position = position;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
