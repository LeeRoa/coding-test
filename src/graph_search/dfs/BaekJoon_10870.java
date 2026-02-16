package graph_search.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_10870 {

    static int N;
    static int[] nums;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = i;
        }

        System.out.println(dfs(N));
    }

    static int dfs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return dfs(n - 1) + dfs(n - 2);
    }
}
