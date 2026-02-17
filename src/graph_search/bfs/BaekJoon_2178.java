package graph_search.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2178 {
    static int COL, ROW; // 가로, 세로
    static boolean[][] visited;
    static int[][] maze; // 미로

    static int[] dCol = {0, 0, -1, 1};
    static int[] dRow = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken()); // 4 - 세로
        ROW = Integer.parseInt(st.nextToken()); // 6 - 가로

        maze = new int[COL][ROW];
        visited = new boolean[COL][ROW]; // 발자국

        for (int col = 0; col < COL; col++) {
            char[] rows = br.readLine().toCharArray();
            for (int row = 0; row < ROW; row++) {
                maze[col][row] = rows[row] == '1' ? 1 : 0; // 미로 길을 생성한다.
            }
        }

        bfs(0, 0);

        System.out.println(maze[COL - 1][ROW - 1]);
    }

    static void bfs(int col, int row) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[col][row] = true;
        queue.offer(new Integer[] {col, row, maze[col][row]});

        while (!queue.isEmpty()) {
            Integer[] here = queue.poll();
            // 인접노드가 있는지 탐색한다. 상하좌우
            for (int i = 0; i < 4; i++) {
                int newCol = here[0] + dCol[i];
                int newRow = here[1] + dRow[i];
                if (newCol >= 0 && newCol < COL && newRow >= 0 && newRow < ROW && maze[newCol][newRow] == 1 && !visited[newCol][newRow]) {
                    visited[newCol][newRow] = true;
                    maze[newCol][newRow] = here[2] + maze[newCol][newRow];
                    queue.offer(new Integer[] {newCol, newRow, maze[newCol][newRow]});
                }
            }
        }
    }
}
