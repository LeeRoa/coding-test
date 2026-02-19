package two_pointers;

import java.util.*;
import java.io.*;

public class BaekJoon_1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int l = 0;
        int r = N - 1;
        int count = 0;
        while (l < r) {
            int sum = A[l] + A[r];

            System.out.println(A[l] + ", " + A[r] + "의 합계 : " + sum);
            if (sum < M) {
                l++;
            } else if (sum > M) {
                r--;
            } else {
                count++;
                l++;
                r--;
            }
        }

        System.out.println(count);
    }
}
