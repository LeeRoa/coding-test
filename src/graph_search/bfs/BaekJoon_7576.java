package graph_search.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_7576 {
    static int COL, ROW;
    static int[][] box;
    static boolean[][] visited;
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};

    static int startRow, startCol;
    static ArrayList<Tomato> start = new ArrayList<>();

    static class Tomato {
        int row;
        int col;

        Tomato(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

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
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    Tomato tomato = new Tomato(row, col);
                    start.add(tomato);
                }
                box[row][col] = num;
            }
        }

        if (start.isEmpty()) {
            System.out.println(-1);
        } else {
            Tomato tomato = start.get(0);
            bfs(tomato.row, tomato.col);

            boolean ok = true;
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    if (box[row][col] == 0) {
                        ok = false;
                        break;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box[i].length; j++) {
                    max = Math.max(box[i][j], max);
                }
            }

            if (!ok) {
                System.out.println(-1);
            } else {
                System.out.println(max - 1);
            }
        }
    }

    static void bfs(int row, int col) {
        Queue<Tomato> queue = new ArrayDeque<>();
        for (Tomato tomato : start) {
            visited[row][col] = true;
            queue.offer(tomato);
        }

        while (!queue.isEmpty()) {
//            check();
            Tomato here = queue.poll();
            int hereRow = here.row;
            int hereCol = here.col;

            // 주변 토마토 탐색
            for (int i = 0; i < 4; i++) {
                int newRow = hereRow + dRow[i];
                int newCol = hereCol + dCol[i];

                if (newRow >= 0 && newRow < ROW
                        && newCol >= 0 && newCol < COL
                        && box[newRow][newCol] == 0
                        && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    box[newRow][newCol] = box[hereRow][hereCol] + 1;
                    queue.offer(new Tomato(newRow, newCol));
                }
            }
        }
    }

    static void check() {
        System.out.println("=========================================");
        for (int i = 0; i < ROW; i++) {
            System.out.println(Arrays.toString(box[i]));
        }
        System.out.println("=========================================");
    }
}
