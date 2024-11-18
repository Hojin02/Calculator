package level3Pkg;

import java.util.regex.Pattern;

public class Parser{
    private static final String NUMBER_REG = "^-?[0-9]+(\\.[0-9]+)?$"; // 음수,실수,정수인지 판별하는 정규 표현식

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

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
