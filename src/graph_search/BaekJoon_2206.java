package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2206 {
    static int ROW, COL;
    static int[][] map;
    static boolean[][] visited;
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};
    static ArrayList<Integer[]> walls = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];

        for (int row = 0; row < ROW; row++) {
            char[] cols = br.readLine().toCharArray();
            for (int col = 0; col < COL; col++) {
                if (cols[col] == '1') {
                    walls.add(new Integer[] {row, col});
                    map[row][col] = 1;
                } else {
                    map[row][col] = 0;
                }
            }
        }

        // 벽을 하나씩 없애는 순회
        int[] counts = new int[walls.size()];
        for (int i = 0; i < walls.size(); i++) {
            visited = new boolean[ROW][COL];
            bfs(0, 0);
        }
    }

    // 1은 벽
    // 0이 통로
    // 한 번 부수는것이 가능
    static void bfs(int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Integer[] hereRowCol = queue.poll();
            int hereRow = hereRowCol[0];
            int hereCol = hereRowCol[1];
            int here = map[hereRow][hereCol];

            if (hereRow == ROW && hereCol == COL) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int targetRow = hereRow + dRow[i];
                int targetCol = hereCol + dCol[i];

                if (targetRow >= 0 && targetRow < ROW && targetCol >= 0 && targetCol < COL
                        && map[targetRow][targetCol] == 0) {
                    queue.offer(new Integer[] {targetRow, targetCol});
                    visited[targetRow][targetCol] = true;
                    map[targetRow][targetCol] = here + 1;
                }
            }
        }
    }
}
