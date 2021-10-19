import java.util.Scanner;

//두 수의 합을 구하는 프로그램 
public class Sum {
	public static void main(String[] args) {
		
		System.out.println("더하고 싶은 두 수를 입력하세요(띄어쓰기로 구분): ");
		
		//사용자 입력 값 문자열로 받기 
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		
		//공백으로 문자열 분리 
		String[] splitedValue = inputValue.split(" ");
		
		//분리한 문자열을 int형으로 변환, 각각 first, second으로 초기화 
		int first = Integer.parseInt(splitedValue[0]);
		int second = Integer.parseInt(splitedValue[1]);
		
		//두 수의 합을 출력
		System.out.printf("%d와 %d의 합은 %d입니다.", first, second, first + second);
		scanner.close();
	}
}
