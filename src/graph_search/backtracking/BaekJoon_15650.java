package graph_search.backtracking;

import java.io.*;
import java.util.*;

public class BaekJoon_15650 {
    static int N, M;
    static boolean[] V;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = new boolean[N];
        nums = new int[M];

        backtracking(0, 0);
    }

    static void backtracking(int depth, int start) {
//        System.out.println("깊이 : " + depth);
//        System.out.println("타겟번호 : " + start);
        if (depth == M) {
            print();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!V[i] && start <= i) {
                V[i] = true;
                nums[depth] = i;
                backtracking(depth + 1, i);
                V[i] = false;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            sb.append(num + 1).append(" ");
        }

        System.out.println(sb);
    }
}
