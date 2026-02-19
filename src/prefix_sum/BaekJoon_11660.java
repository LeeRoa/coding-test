package prefix_sum;

import java.io.*;
import java.util.*;

public class BaekJoon_11660 {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1];
        int[][] S = new int[N + 1][N + 1];
        /*
         * 1 2 3 4
         * 2 3 4 5
         * 3 4 5 6
         * 4 5 6 7
         * ================
         * 1
         */
        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                int num = Integer.parseInt(st.nextToken());
                A[row][col] = num;
                S[row][col] = S[row][col - 1] + A[row][col] + S[row - 1][col] - S[row - 1][col - 1];
            }
        }

//        System.out.println("------------------------");
//        check(A);
//        System.out.println("------------------------");
//        check(S);

        Point start;
        Point end;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int num = S[end.row][end.col] - S[start.row - 1][end.col] - S[end.row][start.col - 1] + S[start.row - 1][start.col - 1];
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static void check(int[][] table) {
        for (int[] ints : table) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
