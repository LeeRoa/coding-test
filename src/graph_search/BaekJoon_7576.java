package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7576 {
    static int COL, ROW;
    static int[][] box;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken()); // 가로
        ROW = Integer.parseInt(st.nextToken()); // 세로

        box = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        // 박스에 토마토 세팅
        // 1 : 익은 토마토
        // 0 : 익지 않은 토마토
        // -1 : 토마토가 없음
        for (int row = 0; row < ROW; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < COL; col++) {
                box[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
    }

    static void bfs(int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.offer(new Integer[]{row, col});

        while (!queue.isEmpty()) {

        }
    }
}
