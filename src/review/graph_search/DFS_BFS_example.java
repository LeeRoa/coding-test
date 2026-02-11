package review.graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_example {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V; // 정점 개수, 간선 개수, 시작 지점

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 1번 부터 N번까지 쓰기 위해 N + 1 생성을 해야한다.
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // 각 노드를 생성한다.
        }

        // 간선 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 1
            int b = Integer.parseInt(st.nextToken()); // 2

            graph[a].add(b); // 1번 노드 안에 인접노드 관리 포인트에 2번 노드를 추가한다.
            graph[b].add(a); // 이하 동일
        }

        // 선택적이나 오름차순으로 정렬하고 싶다면 그래프에 있는 노드들을 모두 순회하여 오름차순으로 정렬한다.
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 방문 기록을 초기화 한다.
        visited = new boolean[N + 1]; // 그래프에 존재하는 노드들의 크기만큼 방문기록도 생성하여 같은 인덱스를 접근해서 관리한다.
        dfs(V);
        visited = new boolean[N + 1];
        System.out.println("");
        bfs(V);
    }

    static void dfs(int node) {
        // 해당 노드를 방문하니 방문 체크
        visited[node] = true;

        // 먼저 출력한 뒤에 인접 노드를 탐색하는게 중요하다. 그렇지 않으면 재귀니까 탐색이 다끝난뒤에 root 노드가 출력된다.
        System.out.print(node + " ");

        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>(); // 너비우선 탐색을 위해 큐를 생성한다.
        queue.offer(start); // 큐에 현재 위치 노드를 집어 넣는다.
        visited[start] = true; // 노드에 넣었으니 방문 체크

        while (!queue.isEmpty()) {
            int node = queue.poll();

            System.out.print(node + " ");

            // 지금 꺼낸 시작점 노드의 인접 노드가 무엇인지 순회한다.
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true; // 큐에 넣기전에 방문 체크부터 하고
                    queue.offer(next); // 큐에 대기점에 집어 넣는다.
                }
            }
        }
    }
}
