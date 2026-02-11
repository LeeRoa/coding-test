package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1260 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수 (노드의 개수)
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수 (연결선의 개수)
        int V = Integer.parseInt(st.nextToken()); // 시작 번호

        Graph g = new Graph(N);
        Graph g2 = new Graph(N);

        for (int i = 0; i < M; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stg.nextToken()) - 1;
            int b = Integer.parseInt(stg.nextToken()) - 1;
            g.edge(a, b);
            g2.edge(a, b);
        }

        g.dfs(V);
        System.out.println("");
//        g2.bfs(V);
    }

    static class Graph {
        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];

            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        class Node {
            int data;
            LinkedList<Node> adjacent; // 인접 노드들의 리스트
            boolean marked; // 방문 체크 표시 여부

            // 노드 생성자
            Node(int data) {
                this.data = data;
                marked = false;
                adjacent = new LinkedList<>();
            }

            @Override
            public String toString() {
                return "" + data;
            }
        }

        // 노드와 노드를 연결하는 기능
        void edge(int n1, int n2) {
            if (!nodes[n1].adjacent.contains(nodes[n2])) {
                nodes[n1].adjacent.add(nodes[n2]);
            }
            if (!nodes[n2].adjacent.contains(nodes[n1])) {
                nodes[n2].adjacent.add(nodes[n1]);
            }
        }

        void dfs(int V) {
            Node root = nodes[V - 1];
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            root.marked = true;

            while (!stack.isEmpty()) {
                Node r = stack.pop();

                for (Node n : r.adjacent) {
//                    System.out.println(n);
                    if (!n.marked) {
                        n.marked = true;
                        stack.push(n);
                    }
                }

                System.out.print(r.data + 1 + " ");
            }
        }

        void bfs(int V) {
            Node root = nodes[V - 1];
            Queue<Node> queue = new ArrayDeque<>();
            root.marked = true;
            queue.offer(root);

            while(!queue.isEmpty()) {
                Node r = queue.poll();

                for (Node n : r.adjacent) {
                    if (!n.marked) {
                        n.marked = true;
                        queue.offer(n);
                    }
                }

                System.out.print(r.data + 1 + " ");
            }
        }
    }
}
