package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BaekJoon_2667 {
    static class Node {
        int x;
        int y;
        ArrayList<Integer> adjacent;
        boolean visited;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
            adjacent = new ArrayList<>();
            visited = false;
        }
    }

    static ArrayList<Node> graph; // 동적 사이즈 그래프 생성
    static boolean[][] maps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 그래프 생성
        graph = new ArrayList<>();

        // 지도 생성
        maps = new boolean[N][N];

        // 단지 탐색
        for (int x = 0; x < N; x++) {
            char[] row = br.readLine().toCharArray();

            // 지도 한줄씩 탐색 후 값 세팅
            for (int y = 0; y < N; y++) {
                maps[x][y] = row[y] == '1' ? true : false; // row의 값을 하나씩 지도에 세팅한다 0, 1 판별
                graph.add(new Node(x, y)); // 집이 있는 만큼 생성
            }
        }

        // 간선 생성
        for (int i = 0; i < graph.size(); i++) {

        }
    }
}
