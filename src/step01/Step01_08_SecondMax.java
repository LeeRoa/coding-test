package step01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step01_08_SecondMax {

    /**
     * 두 번째 최댓값 찾기
     * 문제: N개의 자연수가 주어집니다. 이 중 두 번째로 큰 값을 찾아 출력하세요.
     * 제약 사항:
     *  정렬(Sort) 메서드를 사용하지 않고 순회와 비교만으로 구현하세요.
     *  모든 수는 서로 다르다고 가정합니다.
     *  N은 3 이상 100 이하입니다.
     * 입력:
     *  첫째 줄에 정수의 개수 N
     *  둘째 줄에 N개의 자연수가 공백으로 구분되어 주어짐
     * 출력: 두 번째로 큰 값을 출력
     * 입력 예시:
     *  =================================================
     *  5
     *  10 40 20 35 30
     *  =================================================
     *  출력 예시:
     *  35
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                int temp;
                if (numArr[i] > numArr[j]) {
                    temp = numArr[j];
                    numArr[j] = numArr[i];
                    numArr[i] = temp;
                }
            }
        }

        System.out.println(numArr[1]);
    }
}
