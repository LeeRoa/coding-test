package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1697 {
    static int N, K, X;
    static int[] load = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수연
        K = Integer.parseInt(st.nextToken()); // 동생

        // K를 찾기 위해서 K보다 + N이 더 큰 숫자가 나온다면 그 이상은 탐색하지 않는 것이 좋다고 판단이되어 K + N으로 여유를 둠
        bfs(N);
    }

    static void bfs(int root) {
        visited[root] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
//            System.out.println(queue);
            X = queue.poll();
//            System.out.println("X: " + X);

            if (X == K) {
                System.out.println(load[X]);
                break;
            }

            if (X + 1 < load.length && !visited[X + 1]) {
                visited[X + 1] = true;
                queue.offer(X + 1);
                load[X + 1] = load[X] + 1;
            }

            if (X - 1 >= 0 && !visited[X - 1]) {
                visited[X - 1] = true;
                queue.offer(X - 1);
                load[X - 1] = load[X] + 1;
            }

            if (X * 2 < load.length && !visited[X * 2]) {
                visited[X * 2] = true;
                queue.offer(X * 2);
                load[X * 2] = load[X] + 1;
            }
        }
    }
}
