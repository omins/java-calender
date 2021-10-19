import java.util.Scanner;

public class Prompt {
	/**
	 * week = 요일명 return 0~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("su"))
			return 0;
		else if (week.equals("mo"))
			return 1;
		else if (week.equals("tu"))
			return 2;
		else if (week.equals("we"))
			return 3;
		else if (week.equals("th"))
			return 4;
		else if (week.equals("fr"))
			return 5;
		else if (week.equals("sa"))
			return 6;
		else
			return 0;
	}

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		PrintCalendar cal = new PrintCalendar();

		int month = 1;
		int year = 2021;
		int weekday = 0;
		while (true) {

			System.out.println("연도(Year)를 입력하세요. ('-1' 입력 시 종료)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if (year == -1)
				break;

			System.out.println("달(Month)을 입력하세요. ");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			System.out.println("첫째 날의 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);

			System.out.print("DAY> ");

			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			System.out.printf("\n%d월의 달력은 아래와 같습니다.\n\n", month);
			cal.printEachCalendar(year, month, weekday);
		}

		System.out.println("End.");

		scanner.close();

	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
