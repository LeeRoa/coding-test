package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // s1 = 10
        // s2 = 20
        // =======
        // s1 = 20
        // s2 = 40
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;

        // 힙세팅
        // 힙 [10, 20, 40, 50] 이라면
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        // 낮은 경우의 수 부터 계산
        while (pq.size() > 1) {
            int A = pq.poll();
            int B = pq.poll();

            int newDeq = A + B;

            pq.offer(newDeq);

            total = total + newDeq;
        }
        System.out.println(total);
    }
}
