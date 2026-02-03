package step03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon_1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 큐의 개수
        int N = Integer.parseInt(st.nextToken());

        // 양방향 순환 큐
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.offer(i + 1);
        }

        System.out.println(deque);
        // 뽑아내려는 개수
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        StringTokenizer peekSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int peekNum = Integer.parseInt(peekSt.nextToken());

            boolean isPoll = false;
            while(!isPoll) {
                System.out.println("타겟 : " + peekNum);
                // 같다면 1번 첫 번째 원소 뽑아내기
                if (peekNum == deque.peek()) {
                    deque.poll();
                    isPoll = true;
                    System.out.println("1. " + deque);
                } else { // 같지 않다면 찾자.
                    // 타겟 넘버의 위치가 큐의 전체 사이즈의 절반보다 크다면 뒤에서 앞으로 가져 오기 3번
                    // [1, 2, 3, 4, 5, 6]
                    // peekNum = 4 | size / 2 = 3
                    if (peekNum > (deque.size() / 2)) {
                        deque.offerFirst(deque.pollLast());
                        count++;

                        System.out.println("3. " + deque);
                    } else { // 작거나 같다면 앞에서 뒤로 밀어서 2번
                        deque.offer(deque.poll());
                        count++;

                        System.out.println("2. " + deque);
                    }
                }
            }

        }

        System.out.println(count);
    }
}
