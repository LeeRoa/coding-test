package 복습;

import java.io.*;
import java.util.*;

public class BaekJoon_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[i] = new int[] {start, end};
        }

        Arrays.sort(A, (a1, a2)-> {
           if (a1[1] == a2[1]) return a1[0] - a2[0];
           else return a1[1] - a2[1];
        });

        int end = 0;
        int count = 0;
        for (int[] time : A) {
            int s = time[0];
            int e = time[1];

//            System.out.println("s: " + s + ", e:" + e);
            if (end <= s) {
                end = e;
                count++;
            }
        }

        System.out.println(count);
    }
}
