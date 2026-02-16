package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2206 {
    static class Status {
        int row;
        int col;
        int count;
        int broken;

        Status (int row, int col, int count, int broken) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.broken = broken;
        }
    }
    static int ROW, COL;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};
    static ArrayList<Integer[]> walls = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];
        visited = new boolean[ROW][COL][2];

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

        System.out.println(bfs(0, 0));
    }

    // 1은 벽
    // 0이 통로
    // 한 번 부수는것이 가능
    static int bfs(int row, int col) {
        Queue<Status> queue = new ArrayDeque<>();
        queue.offer(new Status(row, col, 1, 0));
        visited[row][col][0] = true;

        while (!queue.isEmpty()) {
            Status here = queue.poll();
            int hereRow = here.row;
            int hereCol = here.col;

            if (hereRow == ROW - 1 && hereCol == COL - 1) {
                return here.count;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = hereRow + dRow[i];
                int nCol = hereCol + dCol[i];

                if (nRow >= 0 && nRow < ROW && nCol >= 0 && nCol < COL) {

                    // 벽인 경우
                    if (map[nRow][nCol] == 1) {
                        if (here.broken == 0 && !visited[nRow][nCol][1]) {
                            visited[nRow][nCol][1] = true;
                            queue.offer(new Status(nRow, nCol, here.count + 1, 1));
                        }
                    } else if (map[nRow][nCol] == 0 && !visited[nRow][nCol][here.broken]) {
                        // 길인 경우
                        visited[nRow][nCol][here.broken] = true;
                        queue.offer(new Status(nRow, nCol, here.count + 1, here.broken));
                    }
                }
            }
        }

        return -1;
    }
}
