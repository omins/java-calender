import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		PrintCalendar cal = new PrintCalendar();

		int month = 1;
		int year = 2021;

		while (true) {

			System.out.println("연도(Year)를 입력하세요.");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			System.out.println("달(Month)을 입력하세요. ('-1' 입력 시 종료)");
			System.out.print("MONTH> ");
			month = scanner.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12 || month == 0) {
				continue;
			}
			System.out.printf("\n%d월의 달력은 아래와 같습니다.\n\n", month);
			cal.printEachCalendar(year, month);
		}

		System.out.println("End.");

		scanner.close();

	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
