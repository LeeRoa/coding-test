package prefix_sum;

import java.util.*;
import java.io.*;

public class BaekJoon_10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int len = N + 1;
        int[] A = new int[len];
        int[] S = new int[len];
        int[] G = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i - 1] + A[i];
            G[S[i] % M]++;
        }
        int count = G[0];
        for (int i = 0; i < M; i++) {
            count = count + G[i] * (G[i] - 1) / 2;
        }
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(S));
//        System.out.println(Arrays.toString(G));
        System.out.println(count);
    }
}
