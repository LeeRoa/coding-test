package two_pointers;

import java.io.*;
import java.util.*;

public class BaekJoon_11003 {

    static class Node {
        int index;
        int data;

        Node(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (queue.isEmpty()) queue.offer(new Node(i, input));

            while (!queue.isEmpty()) {
                Node root = queue.peek(); // 1

                if (i - root.index > L) { // 1 - 0 > 3 ?
                    queue.poll(); // 1 제거
                } else { // 범위 안이라면
                    if (root.data > input) { // 1 > 5 ?
                        queue.poll(); // 들어온값보다 크면 기존 데이터 제거
                    } else if (root.data < input) { // 1 < 5 ?
                        sb.append(root.data).append(" "); // 기존 데이터 출력
                        break;
                    }
                    queue.offer(new Node(i, input));
                }
            }
        }

        System.out.println(sb);
    }
}
