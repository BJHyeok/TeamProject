package salary.model;

public class SalaryDetail {
	private Salary salary;
	private double total;
	private double deduct;
	private double real;

	public SalaryDetail(Salary salary, double total, double deduct, double real) {
		super();
		this.salary = salary;
		this.total = total;
		this.deduct = deduct;
		this.real = real;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDeduct() {
		return deduct;
	}

	public void setDeduct(double deduct) {
		this.deduct = deduct;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

}
