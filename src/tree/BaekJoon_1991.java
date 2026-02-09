package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1991 {

    static class Node {
        char data;
        Node left; // 자식1
        Node right; // 자식2

        public Node(char data) {
            this.data = data;
        }

        // 전위 순회
        public static void preOrder(Node node) {
            if(node == null) return;
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        // 중위
        public static void inOrder(Node node) {
            if(node == null) return;
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        // 후위
        public static void postOrder(Node node) {
            if(node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }

        @Override
        public String toString() {
            return this.data + "";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] node = new Node[26];

        char start = 'A';

        // N개의 노드 세팅
        for (int i = 0; i < 26; i++) {
           node[i] = new Node(start++);
        }

        // 노드 연결
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            int rootIndex = root.charAt(0) - 65;
            int leftIndex = left.charAt(0) - 65;
            int rightIndex = right.charAt(0) - 65;
            if (rootIndex >= 0) {
                node[rootIndex].left = leftIndex >= 0 ? node[leftIndex] : null;
                node[rootIndex].right = rightIndex >= 0 ? node[rightIndex] : null;
            }

        }

        Node.preOrder(node[0]);
        System.out.println(" ");
        Node.inOrder(node[0]);
        System.out.println(" ");
        Node.postOrder(node[0]);
    }
}
