package graph_search.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dCol = {0, 0, -1, 1};
    static int[] dRow = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;


        // 영역 세팅
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                int num = Integer.parseInt(st.nextToken());
                map[row][col] = num;
            }
        }

        visited = new boolean[N][N];
        dfs(0, 0);
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if (!visited[nextRow][nextCol] && map[nextRow][nextCol] > 0) {
                dfs(nextRow, nextCol);
            }
        }
    }
}
