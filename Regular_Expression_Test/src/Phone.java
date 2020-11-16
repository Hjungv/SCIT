import java.util.Scanner;
import java.util.regex.*;

public class Phone {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Person person = new Person();

        String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"; // 숫자만
//                                  ^01(?:0|1|[6-9])-(\d{3,4})-(\d{4})$
        System.out.print("이름 입력 : ");
        String name = input.nextLine();
        System.out.print("나이 입력 : ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("전화번호 입력 : ");
        String phone = input.nextLine();

//        if (phone.matches(pattern)) {
        if (Pattern.matches(pattern, phone)) { // Pattern.matches(pattern, id)
            System.out.println("폰번호를 정확히 입력했습니다.");
            System.out.println("저장되었습니다.");

            person.setName(name);
            person.setAge(age);
            person.setPhone(phone);

            System.out.println("결과 : " + person.toString());
        } else {
            System.out.println("틀렸습니다.");
        }

    }

}