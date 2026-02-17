package graph_search.bfs;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_11724 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    static int start = 1;
    static boolean isNoCheck;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];

        isNoCheck = true;

        while (isNoCheck) {
            bfs(start++);
        }

        System.out.print(count);
    }

    static void check() {
        count++;
//        System.out.println(Arrays.toString(visited));
        int ok = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                ok++;
            }
        }

        if (ok == visited.length - 1) {
            isNoCheck = false;
        } else {
            isNoCheck = true;
        }
    }

    static void bfs(int start) {
        if (visited[start]) return;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        check();
    }
}
