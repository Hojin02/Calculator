package level3Pkg;

import java.text.DecimalFormat;

// 아래 열거형은 사용불가
// 열거형 상수는 알파벳, 숫자, 밑줄로 구성되어야 한다.
//    public Enum Oper{
//        +,-,*,/;
//    }
public enum Operator { //Enum을 클래스 처럼 사용가능
    PLUS('+') {
        @Override
        public Number calOper ( Number firNum, Number secNum){
            double result = firNum.doubleValue() + secNum.doubleValue(); // 계산 결과를 먼저 실수형으로 저장.
            if (result % 1 == 0) {// 나머지가 0이면 정수형으로 저장
                int intResult = (int) result;
                System.out.println(firNum + " + " + secNum + " = " + intResult);
                return intResult;
            } else {
                System.out.println(firNum + " + " + secNum + " = " + result);
                return result;
            }
        }
    },
    MINUS('-') {
        @Override
        public Number calOper ( Number firNum, Number secNum){
            double result = firNum.doubleValue() - secNum.doubleValue();
            if (result % 1 == 0) {
                int intResult = (int) result;
                System.out.println(firNum + " - " + secNum + " = " + intResult);
                return intResult;
            } else {
                System.out.println(firNum + " - " + secNum + " = " + result);
                return result;
            }
        }
    },
    MULTIPLY('*') {
        @Override
        public Number calOper ( Number firNum, Number secNum){
            double result = firNum.doubleValue() * secNum.doubleValue();
            if (result % 1 == 0) {
                int intResult = (int) result;
                System.out.println(firNum + " * " + secNum + " = " + intResult);
                return intResult;
            } else {
                System.out.println(firNum + " * " + secNum + " = " + result);
                return result;
            }
        }
    },
    DIVIDE('/') {
        @Override
        public Number calOper ( Number firNum, Number secNum){
            double result = firNum.doubleValue() / secNum.doubleValue();
            DecimalFormat df = new DecimalFormat("#.###"); // 소숫점 2자리까지 표시
            String formattedResult = df.format(result);
            if (result % 1 == 0) {
                int intResult = (int) result;
                System.out.println(firNum + " / " + secNum + " = " + intResult);
                return intResult;
            } else {
                System.out.println(firNum + " / " + secNum + " = " + formattedResult);
                return Double.parseDouble(formattedResult);
            }
        }
    };

    public abstract Number calOper(Number firNum, Number secNum);

    private final char symbol;

    Operator(char symbol) { //생성자
        this.symbol = symbol;
    }

    public char getSymbol() { //겟터
        return symbol;
    }
}
