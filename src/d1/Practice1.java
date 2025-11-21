package d1;

import java.util.Scanner;

public class Practice1 {
    /**
     * 정수 두 개를 입력받아 합을 출력하는 프로그램을 작성하세요.
     * 입력 예시 3 5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[2];

        inputArr[0] = sc.nextInt();
        inputArr[1] = sc.nextInt();

        System.out.println(inputArr[0] + inputArr[1]);
    }
}
