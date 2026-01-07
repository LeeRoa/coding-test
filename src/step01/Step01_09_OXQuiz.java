package step01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Step01_09_OXQuiz {

    /**
     * OX 퀴즈
     * 문제: "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하세요.
     *  문제를 맞히면 그 문제의 점수는 그 문제까지 연속된 'O'의 개수가 됩니다.
     *  예를 들어, "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점입니다.
     * 입력:
     *  첫째 줄에 테스트 케이스의 개수 T가 주어집니다.
     *  각 테스트 케이스는 한 줄로 이루어져 있으며, 'O'와 'X'로만 구성된 문자열이 주어집니다. (문자열 길이는 0보다 크고 80보다 작습니다.)
     * 출력: 각 테스트 케이스마다 점수를 출력하세요.
     * =================================================
     * 2
     * OOXXOXXOOO
     * OXOXOXOXOXOXOX
     * =================================================
     * 10
     * 7
     * =================================================
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<char[]> charsets = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            char[] inputArr = br.readLine().toCharArray();
            charsets.add(inputArr);
        }

        for (int i = 0; i < charsets.size(); i++) {
            char[] inputArr = charsets.get(i);
            int total = 0;
            int score = 0;
            char before = '-';
            for (int j = 0; j < inputArr.length; j++) {
                if (inputArr[j] == 'O' && before == '-') {
                    score = 1;
                } else if (inputArr[j] == 'O' && before == 'O') {
                    score++;
                } else if (inputArr[j] == 'O' && before == 'X') {
                    score = 1;
                } else {
                    score = 0;
                }

                total += score;
                before = inputArr[j];
            }
            System.out.println(total);
        }
    }
}
