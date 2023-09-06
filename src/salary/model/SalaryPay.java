package salary.model;

public class SalaryPay {
	private String emp_no;
	private int base_pay;
	private int food;
	private int duty_charge;
	private int transport;
	private int bonus;

	public SalaryPay(String emp_no, int base_pay, int food, int duty_charge, int transport, int bonus) {
		super();
		this.emp_no = emp_no;
		this.base_pay = base_pay;
		this.food = food;
		this.duty_charge = duty_charge;
		this.transport = transport;
		this.bonus = bonus;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public int getBase_pay() {
		return base_pay;
	}

	public void setBase_pay(int base_pay) {
		this.base_pay = base_pay;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getDuty_charge() {
		return duty_charge;
	}

	public void setDuty_charge(int duty_charge) {
		this.duty_charge = duty_charge;
	}

	public int getTransport() {
		return transport;
	}

	public void setTransport(int transport) {
		this.transport = transport;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
