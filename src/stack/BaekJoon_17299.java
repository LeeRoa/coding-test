package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_17299 {
    static class Node {
        int index;
        int data;

        public Node (int index, int data) {
            this.index = index;
            this.data = data;
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            counts.put(A[i], counts.get(A[i]) == null ? 1 : counts.get(A[i]) + 1);
        }

        System.out.println(counts);

        int[] R = new int[N];
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = A[i];
            Node node = new Node(i, num);
            if (stack.isEmpty()) stack.push(node);
            else {
                while (!stack.isEmpty()) {
//                    System.out.println(stack);
                    Node peek = stack.peek();

                    if (counts.get(peek.data) < counts.get(node.data)) {
                        R[peek.index] = node.data;
                        stack.pop();
                    } else {
                        stack.push(node);
                        break;
                    }

                    if (stack.isEmpty()) {
                        stack.push(node);
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int result : R) {
            sb.append(result == 0 ? -1 : result).append(" ");
        }

        System.out.println(sb);
    }
}
