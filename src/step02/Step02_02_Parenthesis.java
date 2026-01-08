package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step02_02_Parenthesis {
    /**
     * 문제 설명
     * 괄호 문자열(Valid Parenthesis String, VPS)인지 판단하는 프로그램을 작성하세요.
     * 괄호의 모양이 바르게 구성된 문자열을 VPS라고 부릅니다.
     * 한 쌍의 괄호 기호로 된 "()" 문자열은 기본 VPS입니다.
     * 만약 x가 VPS라면, 이것을 괄호로 감싼 (x)도 VPS가 됩니다.
     * 그리고 x와 y가 모두 VPS라면, 이들을 이어 붙인 xy도 VPS가 됩니다.
     * ========================================================================
     * 예를 들어, "(())()"와 "((()))"은 VPS이지만, "(()"나 "(()))", 그리고 ")("는 VPS가 아닙니다.
     * ========================================================================
     * 제약 사항
     * 1. Java에서 제공하는 java.util.Stack 클래스를 사용하지 마세요.
     * 2. 이전 문제에서 구현했던 배열과 top 변수를 활용한 스택 원리를 이용하세요.
     * 3. 입력 문자열의 길이는 2 이상 50 이하입니다.
     * ========================================================================
     * 입력
     * 첫째 줄에 테스트 케이스의 개수 T가 주어집니다.
     * 각 테스트 케이스는 한 줄에 하나씩 괄호 문자열이 주어집니다.
     * ========================================================================
     * 출력
     * 각 테스트 케이스에 대해 그 문자열이 VPS라면 "YES", 아니면 "NO"를 한 줄에 하나씩 출력합니다.
     * ========================================================================
     * 예시 입력
     * 3
     * (())()
     * ((())
     * )(
     * ========================================================================
     * 예시 출력
     * YES
     * NO
     * NO
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        boolean isOK = false;
        for (int i = 0; i < T; i++) {
            int top = 0;
            char[] charArr = br.readLine().toCharArray();

            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == '(') {
                    top++;
                } else if (charArr[j] == ')') {
                    top--;
                }

                if (top < 0) {
                    isOK = false;
                    break;
                }

                if (top == 0) {
                    isOK = true;
                } else {
                    isOK = false;
                }
            }

            if (isOK) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
