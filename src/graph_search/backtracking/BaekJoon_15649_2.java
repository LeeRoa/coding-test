package graph_search.backtracking;

import java.io.*;
import java.util.*;

public class BaekJoon_15649_2 {
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

        backtracking(0);

    }

    static void backtracking(int depth) {
        if (depth == M) {
            for (int num : nums) {
                System.out.print(num + 1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!V[i]) {
                V[i] = true;
                nums[depth] = i;
                backtracking(depth + 1);
                V[i] = false;
            }
        }
    }
}
