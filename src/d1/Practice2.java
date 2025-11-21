package d1;

import java.util.Scanner;

public class Practice2 {
    /**
     * 문제: 정수 하나를 입력받아, 그 수가 짝수인지 홀수인지 출력하세요.
     * 입력 예시
     * 코드
     * 7
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        if (in % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }
    }
}
