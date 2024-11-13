package level2Pkg;

import java.util.Scanner;

public class Lev2App {
    public static void main(String[] args) {
        Lev2Calculator calculator = new Lev2Calculator();

        Scanner sc = new Scanner(System.in);
        while (true){ // 계산기 프로그램 입력 반복문
            System.out.println();
            System.out.print("정수입력1 : ");
            int firnum = sc.nextInt();
            sc.nextLine(); //엔터입력 방지
            System.out.print("계산기호입력: ");
            char oper = sc.nextLine().charAt(0);

            System.out.print("정수입력2 : ");
            int secnum = sc.nextInt();
            sc.nextLine(); //엔터입력 방지
            if(secnum<=0){ // 나눗셈 연산에서 분모가0보다 작을 때 다시 처음부터 입력
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }else if(oper=='+' || oper=='-' || oper=='*' || oper=='/') { // 연산자가 맞게 입력된 경우
                calculator.setResult(calculator.calculate(oper,firnum,secnum)); // calculator.calculate()로 연산 후
            }else{                                                              //결과 값을 calculator.setResult() 이용하여 컬렉션 저장
                System.out.println("잘못된 기호를 입력하였습니다!");
            }
            System.out.print("더 계산 하시겠습니까?(Enter입력 시 재시작) (exit 입력 시 종료) :");
            String q = sc.nextLine();
            if(q.equals("exit")){ // exit입력시 계산 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        while (true){ // 결과 출력 및 삭제 반복문
            System.out.print("메뉴를 선택하세요\n" +
                    "1. 계산된 결과 확인\n" +
                    "2. 맨 앞의 계산 결과 삭제\n" +
                    "3. 종료\n입력 : ");
            int menu = sc.nextInt();
            if(menu==1){
                calculator.getResult(); // System.out.println(result);
            }else if(menu==2){
                calculator.removeFirst(); //result.poll();
            }else if(menu==3){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("잘못 입력하였습니다 프로그램을 종료합니다.");
                break;
            }
        }


    }
}
