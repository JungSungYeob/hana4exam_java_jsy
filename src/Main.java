//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <= 100; i += 10) {
			System.out.print("\rLoading: " + i + "%"); // \r을 사용하여 같은 줄에 덮어쓰기
			Thread.sleep(500); // 0.5초 대기
		}
		System.out.println("\n완료!"); // 작업 완료 후 새 줄로 이동
	}
}
