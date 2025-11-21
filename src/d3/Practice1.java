package d3;

import java.util.Scanner;
import java.util.Stack;

public class Practice1 {
    /*
     * 문제 : 괄호 문자열이 주어졌을 때, 올바른 괄호인지 판별하는 프로그램을 작성하세요.
     *
     * <조건>
     * - 괄호 문자열은 ( 와 ) 로만 이루어져 있습니다.
     * - 올바른 괄호란, 여는 괄호와 닫는 괄호의 짝이 맞아야 합니다.
     *
     * <요구사항>
     * - 문자열을 입력받아 스택을 이용해 괄호 짝을 검사합니다.
     * - 올바르면 "YES", 올바르지 않으면 "NO"를 출력합니다.
     *
     * 입력 예시 : (())
     * 출력 예시 : YES
     * 입력 예시 : (()))
     * 출력 예시 : NO
     */
    public static void main(String[] args) {
        practice();
    }

    /*
        Stack<T> stack = new Stack<>();
        스택 T 타입의 객체를 생성하여 push(), pop()을 기억하자.
     */
    public static void practice() {
        Scanner sc = new Scanner(System.in);

        String in = sc.next();

        Stack<Character> stack = new Stack<>();
        boolean isValid = true;

        for (char c : in.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                stack.pop();
            }
        }

        // 마지막에 스택이 비어 있는지 확인
        if (!stack.isEmpty()) {
            isValid = false;
        }

        System.out.println(isValid ? "YES" : "NO");
    }

    public static void answer() {
        Scanner sc = new Scanner(System.in);

    }
}
