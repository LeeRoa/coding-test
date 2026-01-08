package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step02_03_WordReverse {
    /**
     * 문제 설명
     * 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하세요.
     * 단, 단어의 순서는 바꿀 수 없으며 단어는 공백으로 구분합니다.
     * *********************************************************
     * 예를 들어, "I am happy"라는 문장이 주어지면 "I ma yppah"라고 출력해야 합니다.
     * *********************************************************
     * 제약 사항
     * 1. Java에서 제공하는 java.util.Stack 클래스를 사용하지 마세요.
     * 2. 배열과 top 변수를 활용하여 스택을 직접 구현해 사용하세요.
     * 3. 문장의 길이는 최대 1,000자이며, 단어의 길이는 최대 20자입니다.
     * *********************************************************
     * 입력
     * 첫째 줄에 테스트 케이스의 개수 T가 주어집니다.
     * 각 테스트 케이스는 한 줄에 하나의 문장이 주어집니다.
     * *********************************************************
     * 출력
     * 각 테스트 케이스에 대해 단어를 뒤집은 결과를 한 줄에 출력합니다.
     * *********************************************************
     * 예시 입력
     * 2
     * I am happy
     * We will win
     * *********************************************************
     * 예시 출력
     * I ma yppah
     * eW lliw niw
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int tokenCnt = st.countTokens();
            for (int j = 0; j < tokenCnt; j++) {
                char[] strArr = st.nextToken().toCharArray();
                char[] reverseArr = new char[strArr.length];
                int top = strArr.length - 1;

                for (int k = 0; k < strArr.length; k++) {
                    reverseArr[k] = strArr[top];
                    top--;
                }
                sb.append(reverseArr);
                sb.append(" ");
            }

            System.out.println(sb.toString());
        }
    }
}
