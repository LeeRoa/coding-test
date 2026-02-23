package stack;

import java.io.*;
import java.util.*;

class Node {
    int index;
    int data;

    public Node(int index, int data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

public class BaekJoon_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Node> stack = new ArrayDeque<>();
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            Node input = new Node(i, A);
            if (stack.isEmpty()) stack.push(input);
            else {
                while (!stack.isEmpty()) {
//                    System.out.println(stack);
                    Node node = stack.peek();
                    if (A > node.data) {
                        result[node.index] = A;
                        stack.pop();
                    } else {
                        stack.push(input);
                        break;
                    }

                    if (stack.isEmpty()) {
                        stack.push(input);
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num == 0 ? -1 : num).append(" ");
        }

        System.out.println(sb);
    }
}
