# Java첫번째 과제 계산기 프로그램

## level1Pkg
메인클래스에서 모든 계산 동작

## level2Pkg
메인클래스(app)와 계산기능과 결과를 저장하는 (Calculator)

## level3Pkg
### 메인클래스(app)
- 사용자에게 값을 입력받아 기능을 동작하게 함.
```
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
        :
        :
```
### 입력값을 파싱하는 클래스(Parser)
- 입력값이 정수인지 실수인지 판별 후 String에서 각 타입에 맞게 형변환
```
   public Number parseNum(String input) {
        if (Pattern.matches(NUMBER_REG, input)) {// 숫자가 맞는지 판별
            if (isInteger(input)) { // 입력값이 정수형이면 정수형으로 리턴
                return Integer.parseInt(input);
            }else if (isDouble(input)) { // 입력값이 실수형이면 실수형으로 리턴
                return Double.parseDouble(input);
            }
        }
        return null;
    }
        :
        :
```

### 연산을 담당하는 클래스(Operator)
- 파싱된 문자열(정수or실수)를 받아 열거형을 사용해 연산
```
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
        :
        :
```

### 계산 결과를 저장, 수정하는 클래스(Calculator)
- 연산결과를 정수,실수 상관없이 모두 저장 및 수정
```
private Queue<Number> result = new LinkedList<>(); // Queue 객체 생성
 public void setResult(T result) { //연산결과 저장
        this.result.add(result);
    } // 연산결과 Queue에 저장
   public void removeAll() {
        result.clear(); // 큐에 요소 모두 삭제
    }
        :
        :
```

