package greedy;

import java.io.*;
import java.util.*;

public class BaekJoon_1541 {
    // 55-50+40
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Queue<Integer> numQueue = new ArrayDeque<>();
        boolean isMinus = false;
        int num = 0;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];

            if (ch == '-') {
                if (isMinus) {
                    num = num * -1;
                }
                numQueue.offer(num);
                num = 0;
                isMinus = true;
            } else if (ch == '+') {
                if (isMinus) {
                    num = num * -1;
                }
                numQueue.offer(num);
                num = 0;
            } else {
                if (num == 0) num = ch - '0';
                else num = num * 10 + (ch - '0');
            }
        }

        if (isMinus) {
            num = num * -1;
        }
        numQueue.offer(num);
//        System.out.println(numQueue);
        for (int i : numQueue) {
            sum += i;
        }

        System.out.println(sum);
    }
}
