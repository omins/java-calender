
public class PrintCalendar {
	
	/** 최대 일수 반환*/
	//각 월의 최대 일수 
	private static int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; //윤년 

	//윤년 구분
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	//MAX_DAYS, LEAP_MAX_DAYS를 참조하여, 각 월의 최대 일수 반환 
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}
	
	/** Zeller's congruence 공식 적용을 위한 메소드 
	 * 1) makeMonthForFomula
	 * 2) makeYearOfCentury
	 * 3) makeZeroBasedCentury
	 * 공식 구현 메소드 -> weekDay
	 */
	public int makeMonthForFomula(int month) {
		if (month == 1) {
			return 13;
		}
		if (month == 2) {
			return 14;
		}
		
		else {
			return month;
		}
		
	}
	
	public int makeYearOfCentury(int year, int month) {
			if (makeMonthForFomula(month) == 13 && (year % 100) == 0 || makeMonthForFomula(month) == 14 && (year % 100) == 0) {
				return 99;
			}
			if (makeMonthForFomula(month) == 13 || makeMonthForFomula(month) == 14) {
				return (year % 100) - 1;
			}
			else {
				return year % 100;
			}
		
	}
	public int makeZeroBasedCentury(int year, int month) {
		
		if (makeMonthForFomula(month) == 13 || makeMonthForFomula(month) == 14) {
			return (year / 100) - 1;
		}
		else {
			return year / 100;
		}
		
	}

	/** Zeller's congruence 공식 적용*/
	public int weekDay(int year, int month, int day) {
				
				int m = makeMonthForFomula(month);
				int K = makeYearOfCentury(year, month);
				int J = makeZeroBasedCentury(year, month);
				
				
			return (day + ((13*(m+1))/5) + K + (K/4) + (J/4) + (J*5)) % 7;

				
			}
	
	/**캘린더 출력*/ 
	public void printEachCalendar(int year, int month, int day) {

		// Default space
		System.out.printf("   <<%4d년 %3d월>>\n", year, month);
		System.out.println(" SA SU MO TU WE TH FR");
		System.out.println("---------------------");

		
		int weekday = weekDay(year, month, day); 
		
		
		// 시작 요일을 받아, 그에 상응하는 첫 줄 공백 출력  
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month); //연도, 월을 받아 최대 일수 반환 
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;

		// 첫 줄 일수 출력 
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		// 둘째 줄부터 마지막 줄까지 출력 
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.printf("\n\n");
	}

}
