package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_10026 {
    static int N;
    static int[] dCol = {-1, 1, 0, 1};
    static int[] dRow = {0, 0, -1, 1};
    static char[][] draw;
    static char[][] blindnessDraw;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        draw = new char[N][N];
        blindnessDraw = new char[N][N];
        visited = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            char[] ch = br.readLine().toCharArray();
            draw[row] = ch;
            blindnessDraw[row] = ch;

            for (int col = 0; col < N; col++) {

            }
        }
    }
}
