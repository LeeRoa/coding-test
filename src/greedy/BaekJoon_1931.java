package greedy;

import java.io.*;
import java.util.*;

public class BaekJoon_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

//        check(A);

        Arrays.sort(A, (time1, time2) -> {
           if (time1[1] > time2[1]) {
               return 1;
           } else if (time1[1] == time2[1]) {
               return time1[0] - time2[0];
           } else {
               return -1;
           }
        });

//        check(A);

        int count = 0;
        int end = -1;

        for (int i = 0; i < N; i++) {
            int s = A[i][0];
            int e = A[i][1];

            if (end <= s) {
                end = e;
                count++;
            }
        }

        System.out.println(count);
    }

    private static void check(int[][] A) {
        System.out.println("-----------------------");
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }
    }
}
