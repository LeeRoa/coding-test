package graph_search.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

        List<Integer> counts = new ArrayList<>();
        // 점점높이를 증가
        for (int i = 0; i < 100; i++) {
            visited = new boolean[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    map[row][col] = map[row][col] - 1 < 0 ? 0 : map[row][col] - i;
                }
            }

//            System.out.println("비왔다. 강수량 : " + i);
//            for (int[] nums : map) {
//                System.out.println(Arrays.toString(nums));
//            }
//            System.out.println("====================================");
            int count = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (!visited[row][col] && map[row][col] > 0) {
                        dfs(row, col);
                        count++;
                    }
                }

            }
//            System.out.println("영역개수 : "  + count);
//            System.out.println("====================================");
            counts.add(count);

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    map[row][col] = map[row][col] - 1 < 0 ? 0 : map[row][col] + i;
                }
            }
        }

//        System.out.println(counts);
        Collections.sort(counts);

        System.out.println(counts.get(counts.size() - 1));
    }

    static void dfs(int row, int col) {
//        System.out.println("탐색 영역 : " + row + ", " + col);
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if (nextRow >= N || nextRow < 0 || nextCol >= N || nextCol < 0) continue;

            if (!visited[nextRow][nextCol] && map[nextRow][nextCol] > 0) {
                dfs(nextRow, nextCol);
            }
        }
    }
}
