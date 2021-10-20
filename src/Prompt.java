import java.util.Scanner;

public class Prompt {

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		PrintCalendar cal = new PrintCalendar();

		int month = 1;
		int year = 2021;
		int day = 1;

		while (true) {

			System.out.println("출력하고자 하는 달력의 연도(Year)를 입력하세요. ('-1' 입력 시 종료)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if (year == -1)
				break;

			System.out.println("달(Month)을 입력하세요. ");
			System.out.print("MONTH> ");
			month = scanner.nextInt();


			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			System.out.printf("\n %4d년 %d월의 달력은 아래와 같습니다.\n\n", year, month);
			cal.printEachCalendar(year, month, day);
		}

		System.out.println("End.");

		scanner.close();

	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
