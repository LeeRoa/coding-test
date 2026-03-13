package 복습;

import java.util.*;
import java.io.*;


public class BaekJoon_1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, N, M, K;
        int[][] map;
        boolean[][] visited;
        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int[] dRow = new int[]{-1, 1, 0, 0};
            int[] dCol = new int[]{0, 0, -1, 1};

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (map[row][col] == 1 && !visited[row][col]) {
                        count++;
                        Queue<Integer[]> queue = new ArrayDeque<>();
                        queue.offer(new Integer[]{row, col});

                        while (!queue.isEmpty()) {
                            Integer[] node = queue.poll();
                            int nodeRow = node[0];
                            int nodeCol = node[1];
                            visited[nodeRow][nodeCol] = true;
                            for (int i = 0; i < dRow.length; i++) {
                                int nRow = nodeRow + dRow[i];
                                int nCol = nodeCol + dCol[i];

                                if (nRow >= 0 && nRow < N
                                        && nCol >= 0 && nCol < M
                                        && !visited[nRow][nCol]
                                        && map[nRow][nCol] == 1) {
                                    visited[nRow][nCol] = true;
                                    queue.offer(new Integer[]{nRow, nCol});
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
