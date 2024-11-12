package company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerService {
	private final List<Worker> workers;

	public ManagerService() {
		this.workers = new ArrayList<Worker>();
	}

	public void addWorker(Worker worker) {
		this.workers.add(worker);
	}

	public void showAllSalaryInfo() {
		for (Worker worker : workers) {
			worker.showSalaryInfo();
		}
	}

	public void showSalaryInfo(String name) {
		Collection<Worker> findWorkers = workers.stream()
			.filter(worker -> worker.name.equals(name))
			.collect(Collectors.toCollection(ArrayList::new));
		findWorkers.forEach(Employee::showSalaryInfo);
	}

	public void showTotalSalary() {
		DecimalFormat df = new DecimalFormat("#,###");
		int total = 0;
		for (Worker worker : workers) {
			total += worker.getPay();
		}
		System.out.println("모든 사원들의 급여 총액은: " + df.format(total) + "원");
	}
}
