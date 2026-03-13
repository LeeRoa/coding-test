package 복습;

import java.util.*;
import java.io.*;

public class BaekJoon_14502 {

    static class Node {
        int row;
        int col;
        int status;
        int sum;

        public Node(int row, int col, int status) {
            this.row = row;
            this.col = col;
            this.status = status;
            this.sum = 0;
        }
    }

    static int N, M;
    static int[][] lab;
    static boolean[][] V;
//    static Node[] lab;
    static int[] dRow = new int[]{-1, 1, 0, 0};
    static int[] dCol = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = new boolean[N][M];
        lab = new int[N][M];
        int sRow = -1;
        int sCol = -1;
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0 && sRow < 0) {
                    sRow = row;
                    sCol = col;
                }
                lab[row][col] = num;
            }
        }

        search(sRow, sCol, 0);
    }

    static void search(int row, int col, int count) {
        V[row][col] = true;

        for (int i = 0; i < dRow.length; i++) {
            int newRow = dRow[i] + row;
            int newCol = dCol[i] + col;

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && !V[newRow][newCol] && lab[newRow][newCol] == 0) {
                search(newRow, newCol, count++);
            }
        }

        V[row][col] = false;
    }
}
