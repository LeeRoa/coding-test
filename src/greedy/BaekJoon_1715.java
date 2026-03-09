package greedy;

import java.util.*;
import java.io.*;

public class BaekJoon_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (queue.size() > 1) {
            int A = queue.poll();
            int B = queue.poll();
            count += A + B;
            queue.offer(A + B);
        }


        System.out.println(count);

    }
}
