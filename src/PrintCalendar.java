import java.util.Scanner;

public class PrintCalendar {
	private static int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void printEachCalendar(int year, int month) {

		System.out.printf("    <<%4d년 %3d월>>\n", year, month);
		System.out.println(" S  M  T  W  T  F  S");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");

		if ((month - 1) == 0 || (month - 1) == 2 || (month - 1) == 4 || (month - 1) == 6 || (month - 1) == 7
				|| (month - 1) == 9 || (month - 1) == 11) {

			System.out.println("29 30 31");
			System.out.println(" ");

		} else if ((month - 1) == 1) {
			System.out.println(" ");

		} else {
			System.out.println("29 30");
			System.out.println(" ");

		}
	}

}
