package salary.service;

import salary.model.SalaryPay;

public class CalcSalary {
	
	
	public int calc_total(SalaryPay salary) {
		return salary.getBase_pay() +
				salary.getBonus() +
				salary.getDuty_charge() +
				salary.getFood() +
				salary.getTransport();
	}
	
	public double calc_deduct(double total) {
		double national;
		double health;
		double hire;
		double income;
		
		national = total * 0.045;
		health = total * 0.03545;
		hire = total * 0.00045;
		income = total * 0.06;
		
		return national + health + hire + income;
	}
	
	public double calc_real(SalaryPay salary) {
		double total = calc_total(salary);
		double deduct = calc_deduct(total);
		return total - deduct;
	}
}
