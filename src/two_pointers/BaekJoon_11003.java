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

        @Override
        public String toString() {
            return data + " ";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            Node node = new Node(i, input);

            // 덱에 아무것도 없다면 그냥 집어넣기
            if (deque.isEmpty()) {
                deque.offer(node);
                sb.append(node);
            } else { // 덱에 노드가 있다면 비교 시작
                while (!deque.isEmpty()) { // 덱이 비워지기 전까지 현재 노드와 들어있는 노드들을 비교한다. 만약 현재 노드가 더 크다면 그 자리에서 바로 브레이크.
//                    System.out.println(deque);
                    // 가장 최근에 들어간 노드 꺼내기
                    Node last = deque.getLast();
                    // 현재 노드랑 비교 후 현재노드가 더 작다면 최근 노드 삭제
                    if (input < last.data) {
                        deque.pollLast();
                    } else {
                        // 큐에 지정된 슬라이딩 윈도우 크기 범위에 벗어난 현재 노드라면 가장 오래된 노드를
                        // 제거
                        if (node.index - deque.getFirst().index >= L) {
                            deque.pollFirst();
                        }
                        // 현재 노드가 더 크다면 아무런 반응 없이 그냥 현재노드만 덱에 삽입 후 반복문 탈출
                        deque.offer(node);
                        sb.append(deque.getFirst());
                        break;
                    }

                    // 현재노드와 비교 후 덱에 아무것도 없어지게된다면 현재 노드만 삽입 후 반복문 탈출
                    if (deque.isEmpty()) {
                        deque.offer(node);
                        sb.append(node);
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
