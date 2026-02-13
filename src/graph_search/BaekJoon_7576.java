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
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};

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
            Integer[] here = queue.poll();
            int hereRow = here[0];
            int hereCol = here[1];
            // 토마토 상태 확인
            int status = box[hereRow][hereCol];

            if (status == 1) {
                // 익음
                for (int i = 0; i < 4; i++) {
                    int newRow = hereRow + dRow[i];
                    int newCol = hereCol + dCol[i];
                }
            } else if (status == 0) {
                // 안익음
            } else {
                // 없음
            }
        }
    }
}
