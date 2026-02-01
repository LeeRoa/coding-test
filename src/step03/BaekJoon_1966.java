package step03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 문서의 총 개수
            int N = Integer.parseInt(st.nextToken());
            // 몇 번째로 인쇄되었는지 궁금한 타겟 문서
            int M = Integer.parseInt(st.nextToken());

            // 프린터 큐 생성
            Queue<Integer> printQueue = new ArrayDeque<>();
            Queue<Integer> docQueue = new ArrayDeque<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            // 큐에 문서 삽입
            for (int i = 0; i < N; i++) {
                // [1, 1, 9, 1, 1, 1]
                docQueue.offer(i);
                printQueue.offer(Integer.parseInt(st2.nextToken()));
            }

            // 프린터 작동 (모든 문서가 출력 될때 까지)
            while (!printQueue.isEmpty()) {
                // 프린터 큐 순회
                for (int print : printQueue) {
                    boolean isPrint = true;

                    // 다른 문서들과 비교
                    for (int after : printQueue) {
                        if (print < after) {
                            isPrint = false;
                            break;
                        }
                    }

                    // 현재 프린터 출력하기
                    if (isPrint) {
                        count++;
                        int value = docQueue.poll();
                        printQueue.poll();

                        if (value == M) {
                            System.out.println(count);
                        }
                    } else {
                        // 뒤로 밀기
                        docQueue.offer(docQueue.poll());
                        printQueue.offer(printQueue.poll());
                    }
                }
            }
        }
    }
}
