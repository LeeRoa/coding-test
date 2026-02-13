package graph_search;

import java.io.*;
import java.util.*;

public class BaekJoon_7562 {

    static int I;
    static int nowCol, nowRow;
    static int endCol, endRow;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dCol = {-2, 2, -2, 2, -1, 1, -1, 1};
    static int[] dRow = {-1, 1, 1, -1, -2, 2, 2, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testcase = 0 ; testcase < T; testcase++) {
            I = Integer.parseInt(br.readLine());

            // 체스판 생성
            maps = new int[I][I];
            visited = new boolean[I][I];

            // 현재 위치
            st = new StringTokenizer(br.readLine());
            nowCol = Integer.parseInt(st.nextToken());
            nowRow = Integer.parseInt(st.nextToken());

            // 엔드 포인트
            st = new StringTokenizer(br.readLine());
            endCol = Integer.parseInt(st.nextToken());
            endRow = Integer.parseInt(st.nextToken());

            bfs(nowCol, nowRow);
        }
    }

    // 나이트의 이동
    static void bfs(int col, int row) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[col][row] = true;
        queue.offer(new Integer[]{col, row});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            nowCol = now[0];
            nowRow = now[1];

            if (nowCol == endCol && nowRow == endCol) {
                System.out.println(maps[nowCol][endCol]);
                break;
            }

            // 나이트 이동
            int newCol, newRow;
            for (int i = 0; i < dCol.length; i++) {
                newCol = nowCol + dCol[i];
                newRow = nowRow + dRow[i];

                if (newCol >= 0 && newCol < I
                        && newRow >= 0 && newRow < I && !visited[newCol][newRow]) {
                    maps[newCol][newRow] = maps[nowCol][nowRow] + 1;
                    visited[newCol][newRow] = true;
                    queue.offer(new Integer[]{newCol, newRow});
                }
            }
        }
    }
}
