package prefix_sum;

import java.io.*;
import java.util.*;

public class BaekJoon_11659_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int[] S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
            S[i] = S[i - 1] + A[i];
        }

//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(S));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(S[end] - S[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
