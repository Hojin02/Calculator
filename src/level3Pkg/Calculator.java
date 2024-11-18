package level3Pkg;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator<T extends Number>{

    private T firstNum;
    private T secondNum;
    private Queue<Number> result = new LinkedList<>(); // Queue 객체 생성


    public void getResult() { // 연산결과 출력
        System.out.println(result);
    } // 저장된 결과값 Queue를 출력

    public void setResult(T result) { //연산결과 저장
        this.result.add(result);
    } // 연산결과 Queue에 저장

    public void removeFirst() { // 연산결과 맨 앞부분 삭제
        if (!result.isEmpty()) {
            result.poll(); // 큐가 비어있지 않다면 맨 앞 삭제
            System.out.println(result);
        } else {
            System.out.println("저장된 계산 결과가 없어 삭제할 수 없습니다.");
        }
    }

    public void removeAll() {
        result.clear(); // 큐에 요소 모두 삭제
    }

    public void getFilter(Number input) { // 입력한 수 보다 큰 수를 조회
        double min=input.doubleValue();
        Number maxValue = result.stream()
                .max(Comparator.comparingDouble(Number::doubleValue))
                .get();// 저장된 계산 결과중 최대값을 가져옴
        if (!result.isEmpty()) {
            List<Number> filterList = result.stream()
                    .filter(number -> number.doubleValue() >= min)
                    .collect(Collectors.toList());// 입력한 수보다 큰 수들을 List에 넣음
            if (filterList.isEmpty()) {
                System.out.println("입력한 수가 저장된 최댓값보다 큽니다. 최대값: " + maxValue);
            } else {
                System.out.println(filterList);
            }
        } else {
            System.out.println("저장된 계산 결과가 없습니다.");
        }
    }

    public T calculate(char oper, Number firNum, Number secNum) { // 연결결과 리턴
        if (oper == Operator.PLUS.getSymbol()) {
            return (T) Operator.PLUS.calOper(firNum, secNum);
        } else if (oper == Operator.MINUS.getSymbol()) {
            return (T) Operator.MINUS.calOper(firNum, secNum);
        } else if (oper == Operator.MULTIPLY.getSymbol()) {
            return (T) Operator.MULTIPLY.calOper(firNum, secNum);
        } else if (oper == Operator.DIVIDE.getSymbol()) {
            return (T) Operator.DIVIDE.calOper(firNum, secNum);
        }
        return null;
    }

}
