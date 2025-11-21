package d2;

import java.util.Scanner;

public class Practice1 {
    /**
     * 정수 N을 입력받아, N개의 정수를 배열에 저장한 뒤 최댓값과 최솟값을 출력하세요.
     * 입력 예시
     * 코드
     * 5
     * 20 10 35 30 7
     */
    public static void main(String[] args) {
        answer();
    }

    public static void practice() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inArr = new int[N];

        for (int i = 0; i < N; i++) {
            inArr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp;
                if (inArr[i] > inArr[j]) {
                    temp = inArr[j];
                    inArr[j] = inArr[i];
                    inArr[i] = temp;
                }
            }
        }

        System.out.println("최솟값: " + inArr[0]);
        System.out.println("최댓값: " + inArr[inArr.length - 1]);
    }

    public static void answer() {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x < min) min = x;
                if (x > max) max = x;
            }

            System.out.println("최솟값: " + min);
            System.out.println("최댓값: " + max);

            sc.close();
    }
}
