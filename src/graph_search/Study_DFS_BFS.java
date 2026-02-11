package graph_search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Study_DFS_BFS {

    static class Graph { // 그래프
        class Node {
            int data; // node의 데이터
            LinkedList<Node> adjacent; // 인접한 노드들의 리스트
            boolean marked; // 해당 노드를 방문했는지에 대한 정보

            // 노드 생성 시
            Node (int data) {
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<Node>();
            }
        }

        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];

            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        // 두 노드의 연결선
        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];

            // n1 노드에 n2 노드가 있는지 확인하고 없다면 추가
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }

            // 반대로 n2 노드에 n1 노드가 있는지 확인하고 없다면 추가
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Node root = nodes[index];
//            Stack<Node> stack = new Stack<Node>(); // stack 클래스는 매우 비효율적임
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            root.marked = true;

            while(!stack.isEmpty()) {
                // 먼저 스택에 들어있는 가장 맨위의 노드를 꺼낸다.
                Node r = stack.pop();

                // Stack에 추가되지 않은 인접한 노드들만 추가하는 작업
                for (Node n : r.adjacent) {
                    if (!n.marked) { // 아직 Stack에 들어오지 않았다면
                        n.marked = true; // 해당 인접 노드 마커 변경
                        stack.push(n); // 스택에 추가
                    }
                }

                // 꺼낸 노드를 출력한다.
                visit(r);
            }
        }

        // 재귀함수를 이용한 dfs
        void dfsR(Node r) {
            if (r == null) return;
            r.marked = true;
            visit(r);
            for (Node n : r.adjacent) {
                // 아직 호출되지 않은 인접노드라면 재귀함수를 이용해서 호출한다.
                if (!n.marked) {
                    dfsR(n);
                }
            }
        }

        void dfsR(int index) {
            dfsR(nodes[index]);
        }

        void dfsR() {
            dfsR(nodes[0]);
        }

        void bfs() {
            bfs(0);
        }

        void bfs(int index) {
            Node root = nodes[index];
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            root.marked = true;

            while (!queue.isEmpty()) {
                Node r = queue.poll();
                // 출력한 노드의 인접 노드를 큐에 추가한다.
                for (Node n : r.adjacent) {
                    if (!n.marked) {
                        n.marked = true;
                        queue.offer(n);
                    }
                }

                visit(r);
            }
        }

        // 방문
        void visit(Node n) {
            System.out.print(n.data + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

//        g.dfs(3);
//        g.dfsR(3);
//        g.bfs();
    }
}
