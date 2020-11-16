import java.util.Scanner;
import java.util.regex.Pattern;

public class ReMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = sc.nextLine();

		String pattern = "^[a-zA-Z]*$";

		boolean result = Pattern.matches(pattern, id);

		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("영문만 입력해주세요");
		}
	}

}
