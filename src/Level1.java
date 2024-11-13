import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("정수입력1 : ");
            int firnum = sc.nextInt();
            sc.nextLine();// 정수1 입력후 엔터 입력 시 char에 엔터 들어감 방지
            System.out.print("계산기호입력: ");
            char oper = sc.nextLine().charAt(0);

            System.out.print("정수입력2 : ");
            int secnum = sc.nextInt();

            if(secnum<=0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }else if(oper=='+'){
                System.out.println(firnum+" "+oper+" "+secnum +"e= "+(firnum+secnum));
            }else if(oper=='-'){
                System.out.println(firnum+" "+oper+" "+secnum +"= "+(firnum-secnum));
            }else if(oper=='*'){
                System.out.println(firnum+" "+oper+" "+secnum +"= "+(firnum*secnum));
            }else if(oper=='/'){
                System.out.println(firnum+" "+oper+" "+secnum +"= "+(firnum/secnum));
            }else {
                System.out.println("잘못된 계산 기호를 입력하였습니다.");
            }
            System.out.println("더 계산 하시겠습니까? (exit 입력 시 종료)");
            String q = sc.nextLine();
            if(q.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}