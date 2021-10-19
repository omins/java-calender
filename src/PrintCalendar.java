import java.util.Scanner;

public class PrintCalendar {
	private static int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printSampleCalendar() {
		System.out.println("일  월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {

		// 숫자를 입력받아, 해당하는 달의 최대 일수 출력

		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		PrintCalendar cal = new PrintCalendar();

		int month = 1;

		while (true) {
			System.out.println("달(Month)을 입력하세요. ('-1' 입력 시 종료)");
			System.out.print(PROMPT);
			month = scanner.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12) {
				continue;
			}
			System.out.printf("2021년 기준, %d월은 %d까지 있습니다.\n\n", month, cal.maxDaysOfMonth(month));
		}

		System.out.println("End.");

		scanner.close();
	}
}
