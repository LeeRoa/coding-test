package two_pointers;

import java.util.*;
import java.io.*;

public class BaekJoon_12891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        // [A, C, G, A]
        int[][] A = new int[dna.length()][4];
        for (int i = 0; i < S; i++) {
            char ch = dna.charAt(i);
            if (i != 0) {
                A[i][0] = A[i - 1][0];
                A[i][1] = A[i - 1][1];
                A[i][2] = A[i - 1][2];
                A[i][3] = A[i - 1][3];
                if (ch == 'A') {
                    A[i][0]++;
                } else if (ch == 'C') {
                    A[i][1]++;
                } else if (ch == 'G') {
                    A[i][2]++;
                } else {
                    A[i][3]++;
                }
            } else {
                if (ch == 'A') {
                    A[i][0]++;
                } else if (ch == 'C') {
                    A[i][1]++;
                } else if (ch == 'G') {
                    A[i][2]++;
                } else {
                    A[i][3]++;
                }
            }
        }
//        check(A);

        int count = 0;
        int start = 0;
        int end = P - 1;

        while (end != S) {
            int[] r;

            if (start == 0) {
                r = A[end];
            } else {
            }
        }
    }

    static void check(int[][] arr) {
        System.out.println("================================");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
