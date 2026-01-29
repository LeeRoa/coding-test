package step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 스택 활용: 제로 (백준 10773번)
 [문제: 제로]
 나코더 기장 재민이는 동아리 회식을 준비하기 위해서 장부를 관리하고 있다.
 재민이는 돈을 실수로 잘못 부르는 사고를 치기 때문에,
 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
 재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다. 재민이를 도와주자.

 [입력]
 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 이후 K개의 줄에 정수가 1개씩 주어진다.
 정수는 0에서 1,000,000 사이의 값을 가지며,
 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 (단, 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장한다.)

 [출력]
 재민이가 최종적으로 적어 낸 수의 합을 출력한다.

 [예제 입력]
 10
 1
 3
 5
 4
 0
 0
 7
 0
 0
 6

 [예제 출력]
 7
 */
public class Quiz1_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int total = 0;

        for (Integer num : stack) {
            total += num;
        }
        System.out.println(total);
    }
}