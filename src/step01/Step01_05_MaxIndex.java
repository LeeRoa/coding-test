package step01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step01_05_MaxIndex {

    /**
     * 문제: 서로 다른 9개의 자연수가 주어집니다. 이들 중 최댓값을 찾고, 그 최댓값이 몇 번째 수인지(1번째부터 시작)를 구하세요.
     * 입력: 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나씩 자연수가 주어짐 (100 미만의 자연수)
     * 출력: * 첫째 줄에 최댓값 출력
     * 둘째 줄에 그 값이 몇 번째 숫자인지 출력
     * ========================================================
     * 예시 입력:
     * 3, 29, 38, 12, 57, 74, 40, 85, 61 (한 줄에 하나씩 입력됨)
     * ========================================================
     * 예시 출력:
     * 85
     * 8
     * ========================================================
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[9];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(br.readLine());

            if (numArr[i] > max) {
                max = numArr[i];
                maxIndex = i;
            }
        }

        System.out.println(max);
        // 내가 작성한 코드의 오답
//        System.out.println(maxIndex);

        // 인덱스는 0부터 시작하니까 방심 x
        System.out.println(maxIndex + 1);
    }
}
