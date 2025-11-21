package d2;

import java.util.Scanner;

public class Practice2 {
    /**
     * 문자열 S와 정수 N을 입력받아, 문자열을 N번 반복해서 출력하세요.
     * 입력 예시 : abc 3
     * 출력 예시 : abcabcabc
     */
    public static void main(String[] args) {
        practice();
    }

    public static void practice() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sb.append(s);
        }

        System.out.println(sb);
    }

    public static void answer() {
        Scanner sc = new Scanner(System.in);

    }
}
