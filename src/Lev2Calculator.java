import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lev2Calculator {
    private Queue<Integer> result = new LinkedList<>(); // Queue 객체 생성


    public void getResult() { // 연산결과 출력
        System.out.println(result);
    } // 저장된 결과값 Queue를 출력

    public void setResult(int result) { //연산결과 저장
        this.result.add(result);
    } // 연산결과 Queue에 저장

    public void removeFirst() { // 연산결과 맨 앞부분 삭제
        if (!result.isEmpty()) {
            result.poll(); // 큐가 비어있지 않다면 맨 앞 삭제
        } else {
            System.out.println("저장된 계산 결과가 없어 삭제할 수 없습니다.");
        }
    }

    public int calculate(char oper, int firNum, int secNum) { // 연결결과 리턴
        if (oper == '+') {
            System.out.println(firNum + " " + oper + " " + secNum + " = " + (firNum + secNum));
            return firNum + secNum;
        } else if (oper == '-') {
            System.out.println(firNum + " " + oper + " " + secNum + " = " + (firNum - secNum));
            return firNum - secNum;
        } else if (oper == '*') {
            System.out.println(firNum + " " + oper + " " + secNum + " = " + (firNum * secNum));
            return firNum * secNum;
        } else if (oper == '/') {
            System.out.println(firNum + " " + oper + " " + secNum + " = " + (firNum / secNum));
            return firNum / secNum;
        }
        return 0;
    }

}
