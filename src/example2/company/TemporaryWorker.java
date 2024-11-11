package example2.company;

import java.text.DecimalFormat;

public class TemporaryWorker extends Worker {
	private int payPerHour;
	private int workTime;

	public TemporaryWorker(String name, int payPerHour, int workTime) {
		super(name);
		this.payPerHour = payPerHour;
		this.workTime = workTime;
	}

	@Override
	public int getPay() {
		return this.payPerHour * this.workTime;
	}

	@Override
	public void showSalaryInfo() {
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.printf("사원 %s의 근무시간은 %d시간, 시간 수당은 %s원, 급여는 %s원\n", super.name, this.workTime,
			df.format(this.payPerHour),
			df.format(this.getPay()));
	}
}
