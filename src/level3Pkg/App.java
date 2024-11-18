package level3Pkg;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        mainCal(calculator, sc);// 수와 연산자 입력받고 계산하여 큐에 저장.

        while (true) { // 결과 출력 및 삭제 반복문
            System.out.print("메뉴를 선택하세요\n" +
                    "1. 계산된 결과 확인\n" +
                    "2. 맨 앞의 계산 결과 삭제\n" +
                    "3. 다시 계산하기\n" +
                    "4. 저장된 계산결과 초기화\n" +
                    "5. 필터링하여 결과 조회\n" +
                    "6. 종료\n입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            if (menu == 1) {
                calculator.getResult(); // System.out.println(result);
            } else if (menu == 2) {
                calculator.removeFirst(); //result.poll();
            } else if (menu == 3) {
                mainCal(calculator, sc);
            } else if (menu == 4) { // result.clear();
                calculator.removeAll();
            } else if (menu == 5) {
                Number min = inputNum(sc, "최솟값을 지정해주세요: ");
                calculator.getFilter(min);
            } else if (menu == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못 입력하였습니다 프로그램을 종료합니다.");
                break;
            }
        }


    }

    public static void mainCal(Calculator calculator, Scanner sc) {
        while (true) { // 계산기 프로그램 입력 반복문
            System.out.println();
            Number firnum = inputNum(sc, "수입력1: ");
            char oper = inputOper(sc, "계산기호입력: ");
            Number secnum = inputNum(sc, "수입력2: ");

            if (secnum.doubleValue() == 0.0 && oper == '/') { // 나눗셈 연산에서 분모가0보다 작을 때 다시 처음부터 입력
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } else {
                calculator.setResult(calculator.calculate(oper, firnum, secnum));//계산과 동시에 큐에 저장
            }
            System.out.print("더 계산 하시겠습니까?(Enter입력 시 재시작) (exit 입력 시 종료) :");
            String q = sc.nextLine();
            if (q.equals("exit")) { // exit입력시 계산 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

    }

    public static Number inputNum(Scanner sc, String message) {
        while (true) {

            System.out.print(message);
            String input = sc.nextLine();
            Parser parser = new Parser();
            if (parser.parseNum(input) == null) {
                System.out.println("잘못된 입력입니다. 문자가 아닌 올바른 수를 입력하세요.");
            } else {
                return parser.parseNum(input);  // 정수인지 실수인지에 따라 맞는 타입을 리턴.
            }
        }
    }

    public static char inputOper(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                char oper = sc.nextLine().charAt(0);
                if (oper == '+' || oper == '-' || oper == '*' || oper == '/') { // 연산자가 맞게 입력된 경우
                    return oper;
                } else {
                    System.out.println("잘못된 입력입니다. +,-,*,/ 중 하나를  입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자가아닌 올바른 연산자 입력하세요.");
                sc.nextLine(); // 잘못된 입력 제거
            }
        }
    }


}
