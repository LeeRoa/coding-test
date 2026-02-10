package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon_1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 연산의 정보
            int x = Integer.parseInt(br.readLine());

            // 가장 작은 값을 출력하고 제거
            if (x == 0) {
                // 큐가 비어있다면 0
                if (pq.isEmpty()) {
                    sb.append(x).append("\n");
                } else {
                    // 비어있지 않다면 가장 작은 값을 출력
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                // offer
                pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}
