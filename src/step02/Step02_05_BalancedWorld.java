package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step02_05_BalancedWorld {

    /**
     * 문제 설명
     * 세계는 균형이 잘 잡혀 있어야 합니다. 양괄호 "()"와 대괄호 "[]"가 포함된 문자열이 주어질 때, 모든 괄호들이 짝이 잘 맞는지 판단하는 프로그램을 작성하세요.
     * *********************************************************
     * 균형잡힌 문자열이 되기 위한 조건은 다음과 같습니다:
     * 1. 모든 왼쪽 소괄호 "("는 오른쪽 소괄호 ")"와 짝을 이뤄야 한다.
     * 2. 모든 왼쪽 대괄호 "["는 오른쪽 대괄호 "]"와 짝을 이뤄야 한다.
     * 3. 모든 오른쪽 괄호들은 자신과 짝을 이루는 왼쪽 괄호 뒤에 나와야 한다.
     * 4. 모든 괄호 짝은 1:1 매칭이며, 중간에 다른 괄호가 끼어 있어도 균형이 잡혀 있어야 한다. (예: "([ ])" 는 가능, "([ )]" 는 불가능)
     * *********************************************************
     * 제약 사항
     * 1. Java에서 제공하는 java.util.Stack 클래스를 사용하지 마세요.
     * 2. 직접 구현한 스택(배열과 top 활용)을 사용하여 문제를 해결하세요.
     * 3. 각 문자열의 길이는 100글자 이내입니다.
     * 4. 입력의 종료 조건은 맨 마지막에 마침표 하나(".")가 들어오는 경우입니다.
     * *********************************************************
     * 입력
     * 각 줄마다 문자열이 주어집니다. 문자열의 끝은 항상 마침표(".")로 끝납니다.
     * *********************************************************
     * 출력
     * 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes", 아니면 "no"를 출력합니다.
     * *********************************************************
     * 예시 입력
     * So when I die (the [first] I will see in (heaven) is a score list).
     * [ first in ] ( second ) [ ( third ) ]
     * [ ( ] )
     * .
     * *********************************************************
     * 예시 출력
     * yes
     * yes
     * no
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            char[] strArr = str.toCharArray();
            char[] stack = new char[strArr.length];
            boolean result = true;
            int top = 0;

            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] == '[' || strArr[i] == '(') {
                    stack[top++] = strArr[i];
                }

                if (strArr[i] == ']') {
                    if (!(top > 0 && stack[top - 1] == '[')) {
                        result = false;
                        break;
                    }

                    top--;
                } else if (strArr[i] == ')') {
                    if (!(top > 0 && stack[top - 1] == '(')) {
                        result = false;
                        break;
                    }

                    top--;
                }

            }
            if (top != 0) {
                result = false;
            }

            System.out.println(result ? "yes" : "no");
        }
    }
}
