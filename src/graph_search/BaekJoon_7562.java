package graph_search;

import java.io.*;
import java.util.*;

public class BaekJoon_7562 {

    static int I;
    static int nowCol, nowRow;
    static int endCol, endRow;
    static int[][] maps;
    static boolean[][] visited;

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

    static void bfs(int col, int row) {

    }
}
