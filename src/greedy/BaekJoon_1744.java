package greedy;

import java.util.*;
import java.io.*;

public class BaekJoon_1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                plusQueue.offer(num);
            } else if (num < 0) {
                minusQueue.offer(num);
            } else if (num == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        int sum = 0;
        while (plusQueue.size() > 1) {
            int A = plusQueue.poll();
            int B = plusQueue.poll();
            sum += A * B;
        }

        if (!plusQueue.isEmpty()) {
            sum += plusQueue.poll();
        }

        while (minusQueue.size() > 1) {
            int A = minusQueue.poll();
            int B = minusQueue.poll();
            sum += A * B;
        }

        if (!minusQueue.isEmpty()) {
            int num = minusQueue.poll();

            if (zeroCount == 0) sum += num;
        }

        sum += oneCount;
        System.out.println(sum);
    }
}
