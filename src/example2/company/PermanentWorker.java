package example2.company;

import java.text.DecimalFormat;

public class PermanentWorker extends Worker {
	private int salary;

	public PermanentWorker(String name, int salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	public int getPay() {
		return this.salary;
	}

	@Override
	public void showSalaryInfo() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.printf("사원 %s의 급여는 %s원\n", super.name, df.format(this.salary));
	}
}
