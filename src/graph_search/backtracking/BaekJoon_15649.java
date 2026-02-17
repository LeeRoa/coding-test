package graph_search.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_15649 {
    static int N, M;
    static int[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = i;
        }
//        System.out.println(Arrays.toString(graph));

        // 탐색 시작
        visited = new boolean[N];
        back(0);
    }


    static void back(int depth) {
        if (depth == M) {

            for (int i = 0; i < M; i++) {
                System.out.print(graph[i] + 1 + " ");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                graph[i] = i;
                back(depth + 1);
                visited[i] = false;
            }
        }
    }
}
