package step03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step03_01_Card2 {

    /**
     * 문제 설명
     * N장의 카드가 있습니다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 
     * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 쌓여 있습니다.
     * 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 됩니다:
     * 
     * 1. 제일 위에 있는 카드를 바닥에 버린다.
     * 2. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
     * ================================================================
     * N이 주어졌을 때, 제일 마지막에 남게 되는 카드의 번호를 구하는 프로그램을 작성하세요.
     * ================================================================
     * 제약 사항
     * 1. Java에서 제공하는 java.util.Queue 나 LinkedList 클래스를 사용하지 마세요.
     * 2. 배열을 활용하여 큐를 직접 구현해 사용하세요.
     * 3. N (1 <= N <= 500,000)
     * ================================================================
     * 입력
     * 첫째 줄에 정수 N이 주어집니다.
     * ================================================================
     * 출력
     * 첫째 줄에 마지막에 남게 되는 카드의 번호를 출력합니다.
     * ================================================================
     * 예시 입력
     * 6
     * ================================================================
     * 예시 출력
     * 4
     * ================================================================
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] queue = new int[N * 2];
        int front = 0;
        int rear = N;

        for (int i = 0; i < N; i++) {
            queue[i] = i + 1;
        }

        while (true) {
            // 첫번째 큐 빼기
            front++;
            
            // 두번째 큐 맨뒤에 넣기
            int value2 = queue[front++];
            queue[rear++] = value2;
            
            if (rear - front == 1) {
                System.out.println(queue[front]);
                break;
            }
        }
    }
}
