package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step02_01_Zero {
    /**
     * <문제 설명>
     * 나재민은 재무제표를 작성하다가 숫자를 잘못 부르는 실수를 저질렀습니다.
     * 재민이가 숫자를 부를 때마다 그 수를 기록하며, 만약 0을 부르면 가장 최근에 기록했던 수를 지웁니다.
     * 모든 숫자를 다 불렀을 때 최종적으로 남은 수들의 합을 구하는 프로그램을 작성하세요.
     * <제약 사항>
     * 1. Java에서 제공하는 java.util.Stack 클래스를 사용하지 마세요.
     * 2. 배열을 이용하여 스택의 원리(LIFO - Last In First Out)를 직접 구현해야 합니다.
     * 3. 정수의 개수 K는 최대 100,000개입니다.
     * <입력>
     * 첫째 줄에 정수 K가 주어집니다. (1 <= K <= 100,000)
     * 이후 K개의 줄에 정수가 한 줄에 하나씩 주어집니다. (0일 경우 최근 수를 지우고, 0이 아닐 경우 기록)
     * 주의: 0을 불렀을 때 지울 수 있는 수가 있음을 보장합니다.
     * <출력>
     * 최종적으로 기록에 남은 수들의 합을 출력합니다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] numArr = new int[K];
        int top = 0;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                numArr[top] = num;
                top++;
            } else {
                top--;
            }
        }

        int total = 0;
        for (int i = 0; i < top; i++) {
            total += numArr[i];
        }

        System.out.println(total);
    }
}
