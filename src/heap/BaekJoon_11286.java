package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon_11286 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2) -> {
            if (Math.abs(s1) == Math.abs(s2)) {
                if (s1 > s2) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                 if (Math.abs(s1) < Math.abs(s2)) {
                     // 더 작은것을 내보낸다
                     return -1;
                 }
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append(x).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
