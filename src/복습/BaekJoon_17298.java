package 복습;

import java.util.*;
import java.io.*;

public class BaekJoon_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer[]> stack = new ArrayDeque<>();
        int[] nges = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                Integer[] A = stack.peek();
                int index = A[0];
                int data = A[1];
                if (data < num) {
                    nges[index] = num;
                    stack.pop();
                } else break;
            }
            stack.push(new Integer[]{i, num});
        }
        for (int nge : nges) {
            sb.append(nge == 0 ? -1 : nge).append(" ");
        }

        System.out.println(sb);
    }
}
