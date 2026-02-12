package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaekJoon_2667 {

    static boolean[][] maps; // 그래프 역할
    static boolean[][] visited; // 방문기록
    static int count = 0;
    static int N;

    // 꼭 외우자 상하 좌우를 이동하기 위한 요소 두개
    static int[] dx = {-1, 1, 0, 0}; // 행
    static int[] dy = {0, 0, -1, 1}; // 열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        // 지도 생성
        maps = new boolean[N][N];
        visited = new boolean[N][N];

        // 단지 탐색
        for (int x = 0; x < N; x++) {
            char[] row = br.readLine().toCharArray();

            // 지도 한줄씩 탐색 후 값 세팅
            for (int y = 0; y < N; y++) {
                maps[x][y] = row[y] == '1'; // row의 값을 하나씩 지도에 세팅한다 0, 1 판별
            }
        }
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 지도에 집이 있다면 dfs
                if (maps[i][j] && !visited[i][j] ) {
                    count = 0;
                    dfs(i, j);
                    sizes.add(count);
                }
            }
        }

        Collections.sort(sizes);
        sb.append(sizes.size()).append("\n");

        for (int size : sizes) {
            sb.append(size).append("\n");
        }
        System.out.println(sb);
    }

    // 탐색
    static void dfs(int x, int y) {
        count++;
//        System.out.println("현재 위치: " + x + ", " + y);
        // 해당 집 방문 체크
        visited[x][y] = true;

        // 상하좌우 이동 체크
        for (int i = 0; i < 4; i++) {
//            System.out.println("새로운 탐색 정보:x + dx[i] :  " + x + " + " + dx[i]);
//            System.out.println("새로운 탐색 정보:y + dy[i] :  " + y + " + " + dy[i]);
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < N) {
                if (maps[newX][y] && !visited[newX][y]) {
//                    System.out.println("다음 갈 위치: " + newX + ", " + y);
                    dfs(newX, y);
                }
            }

            if (newY >= 0 && newY < N) {
                if (maps[x][newY] && !visited[x][newY]) {
//                    System.out.println("다음 갈 위치: " + x + ", " + newY);
                    dfs(x, newY);
                }
            }
        }
    }
}
