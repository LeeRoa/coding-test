package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(Arrays.toString(A));
        for (int i = A.length - 1; i >= 0; i--) {
            System.out.println("A[i]: " + A[i] + " , K : " + K);
            if (K < A[i]) continue;
            count = count + K / A[i];
            K = K % A[i];
            System.out.println("K / A[i]: " + K / A[i]);
            System.out.println("count: " + count);

            if (K == 0) break;
        }

        System.out.println(count);
    }
}
