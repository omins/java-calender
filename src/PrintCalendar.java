import java.util.Scanner;

public class PrintCalendar {
	public static void main(String[] args) {
		System.out.println("일  월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");

		// 숫자를 입력받아, 해당하는 달의 최대 일수 출력
		System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();

		System.out.printf("2021년 기준, %d월은 ", month);

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("31일 까지 있습니다.");
		} else if (month == 2) {
			System.out.println("28일 까지 있습니다.");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("30일 까지 있습니다.");
		}
		scanner.close();
	}
}
