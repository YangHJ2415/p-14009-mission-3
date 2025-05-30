package com.back;

public class Calc {
    // 띄어쓰기로 구분한다.
    // 수식은 (숫자) (연산자) (숫자) 형식으로 입력된다. (형식을 유지한다고 가정한다.)
    // 연산자 종류에 따라 구분하여 계산한다.

    public static int run(String cmd) {
        int result = 0; // 결과값
        String[] bits = cmd.split(" "); // 수식을 공백으로 분리

        // 비어있는 수식에 대한 예외 처리
        if (bits.length == 0) {
            throw new IllegalArgumentException("수식이 비어 있습니다.");
        } else {
            result += Integer.parseInt(bits[0]); // result에 최초 숫자 값을 더한다.
        }

        for(int i=1; i<bits.length; i+=2) {
            String op = bits[i]; // 연산자
            int nextNum = Integer.parseInt(bits[i + 1]); // 다음 숫자

            switch (op) {
                case "+" -> result += nextNum; // 덧셈
                case "-" -> result -= nextNum; // 뺄셈
                case "*" -> result *= nextNum; // 곱셈
                case "/" -> result /= nextNum; // 나눗셈
                default -> throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + op);
            }
        }
        return result;
    }
}
