package graph_search;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_10026 {
    static int N;
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};
    static char[][] draw;
    static char[][] blindnessDraw;
    static boolean[][] visited1;
    static boolean[][] visited2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        draw = new char[N][N];
        blindnessDraw = new char[N][N];

        // 그림 구역 세팅
        for (int row = 0; row < N; row++) {
            // [R, R, R, B, B]
            char[] colors = br.readLine().toCharArray();
            draw[row] = colors;
            blindnessDraw[row] = colors;
        }

        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        int count1 = 0;
        int count2 = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (!visited1[row][col]) {
//                    System.out.println("탐색 시작: " + row + ", " + col);
                    bfs(draw, row, col, visited1, true);
                    count1++;
                }

                if (!visited2[row][col]) {
                    bfs(blindnessDraw, row, col, visited2, false);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    static void bfs(char[][] draw, int row, int col, boolean[][] visited, boolean isOk) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
//            check();
            Integer[] here = queue.poll();
            int hereRow = here[0];
            int hereCol = here[1];
            char color = draw[hereRow][hereCol];

            for (int i = 0; i < dCol.length; i++) {
                int targetRow = hereRow + dRow[i];
                int targetCol = hereCol + dCol[i];

                if (targetRow >= 0 && targetRow < N && targetCol >= 0 && targetCol < N
                            && !visited[targetRow][targetCol]) {
                    char target = draw[targetRow][targetCol];

                    if (isOk) {
                        if (target == color) {
//                            System.out.println("color: [" + row + ", " + col + "] / 컬러: " + color);
//                            System.out.println("color: [" + targetRow + ", " + targetCol + "] / 컬러: " + target);
                            visited[targetRow][targetCol] = true;
                            queue.offer(new Integer[] {targetRow, targetCol});
                        }
                    } else {
                        if (color == target
                                || (color == 'R' && target == 'G')
                                || (color == 'G' && target == 'R')) {
                            visited[targetRow][targetCol] = true;
                            queue.offer(new Integer[] {targetRow, targetCol});
                        }
                    }
                }
            }
        }
    }

    static void check() {
        System.out.println("--------------------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(visited1[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }
}
