package prefix_sum;

import java.util.*;
import java.io.*;

public class BaekJoon_2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
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

        // N번 구간합
        int start = 1;
        int end = K;
        int max = -100 * 100000;
        for (int i = 0; i < S.length - K; i++) {
//            System.out.println(start + "~" + end);
//            System.out.println("S[end++] - S[start++ - 1] : " + (S[end] - S[start - 1]));
            max = Math.max(max, S[end] - S[start - 1]);
            start++;
            end++;
        }


        System.out.println(max);
    }
}
