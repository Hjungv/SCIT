import java.util.Scanner;
import java.util.regex.*;

public class Phone {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Person person = new Person();

        String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"; // ���ڸ�
//                                  ^01(?:0|1|[6-9])-(\d{3,4})-(\d{4})$
        System.out.print("�̸� �Է� : ");
        String name = input.nextLine();
        System.out.print("���� �Է� : ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("��ȭ��ȣ �Է� : ");
        String phone = input.nextLine();

//        if (phone.matches(pattern)) {
        if (Pattern.matches(pattern, phone)) { // Pattern.matches(pattern, id)
            System.out.println("����ȣ�� ��Ȯ�� �Է��߽��ϴ�.");
            System.out.println("����Ǿ����ϴ�.");

            person.setName(name);
            person.setAge(age);
            person.setPhone(phone);

            System.out.println("��� : " + person.toString());
        } else {
            System.out.println("Ʋ�Ƚ��ϴ�.");
        }

    }

}