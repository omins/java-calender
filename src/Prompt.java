import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {

		System.out.printf("    << 달력 프로그램>>    \n");
		System.out.println("+--------------------+");
		System.out.println("| 1. 일정 등록 ");
		System.out.println("| 2. 일정 검색 ");
		System.out.println("| 3. 달력 보기 ");
		System.out.println("| h. 도움말 보기 q. 종료 ");
		System.out.println("+--------------------+");
		System.out.printf("\n\n");

	}

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scanner = new Scanner(System.in);
		PrintCalendar cal = new PrintCalendar();

		while (true) {
			System.out.println("명령 : 1, 2, 3, h, q");
			String cmd = scanner.next();

			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
			case "q":
				break;
			}

			if (cmd.equals("q")) {
				break;
			}
		}

		System.out.println("End.");
		scanner.close();

	}

	private void cmdCal(Scanner s, PrintCalendar c) { // scanner와 calendar는 참조호출하여 사용

		int month = 1;
		int year = 2021;
		int day = 1;

		System.out.println("출력하고자 하는 달력의 연도(Year)를 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.println("달(Month)을 입력하세요. ");
		System.out.print("MONTH> ");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		System.out.printf("\n %4d년 %d월의 달력은 아래와 같습니다.\n\n", year, month);
		c.printEachCalendar(year, month, day);
	}

	private void cmdSearch(Scanner s, PrintCalendar c) throws ParseException {
		System.out.printf("\n[일정 검색]\n");
		System.out.println("날짜를 입력해주세요. ('yyyy-MM-dd')");
		String date = s.next();
		PlanItem plan;
		plan = c.searchPlan(date);

		if (plan != null && plan.detail.length() != 0) {
			System.out.printf("\n%s의 일정: %s\n\n", date, plan.detail);
		} else {
			System.out.printf("등록된 일정이 없습니다.\n\n");
		}
	}

	private void cmdRegister(Scanner s, PrintCalendar c) throws ParseException {
		System.out.printf("\n[새 일정 등록]\n");
		System.out.printf("날짜를 입력해주세요. ('yyyy-MM-dd')\n");
		String date = s.next();
		String text = "";

		s.nextLine();
		System.out.printf("\n일정을 입력해 주세요.\n");
		text = s.nextLine();

		c.registerPlan(date, text);

	}

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();

		p.runPrompt();
	}
}
