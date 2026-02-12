package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1012 {
    static boolean[][] maps;
    static boolean[][] visited;
    static int count = 0;

    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            maps = new boolean[N][M];
            visited = new boolean[N][M];

            // 배추 위치 탐색
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                maps[x][y] = true; // 지도에 심은 배추 위치 세팅
            }
            count = 0;
//            System.out.println("");

            // 세로
            for (int x = 0; x < N; x++) {
                // 가로
                for (int y = 0; y < M; y++) {
                    if (maps[x][y] && !visited[x][y]) {
                        count++;
                        dfs(x, y);
//                        System.out.println("-------------------------------");
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
//        System.out.println("현재 탐색 위치 : " + x + " , " + y);
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];

            int newY = y + dy[i];

//            System.out.println("다음? " + newX + ", " + newY);
            if (newX >= 0 && newX < N) {

                if (maps[newX][y] && !visited[newX][y]) {
                    dfs(newX, y);
                }
            }

            if (newY >= 0 && newY < M) {
                if (maps[x][newY] && !visited[x][newY]) {
                    dfs(x, newY);
                }
            }
        }
    }
}
