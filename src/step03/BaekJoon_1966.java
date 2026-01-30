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
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 문서의 총 개수
        int N = Integer.parseInt(st.nextToken());
        // 몇 번째로 인쇄되었는지 궁금한 타겟 문서
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int testcase = 0; testcase < T; testcase++) {
            // 프린터 큐 생성
            Queue<Integer> queue = new ArrayDeque<>();

            // 문서들의 현 상태 (중요도)
            int[] docArr = new int[N];

            // 큐에 문서 삽입
            for (int i = 0; i < N; i++) {
                // [1, 1, 9, 1, 1, 1]
                docArr[i] = Integer.parseInt(st.nextToken());
            }

            // 프린터 작동 (모든 문서가 출력 될때 까지)
            while (queue.size() != 0) {
                // 현재 문서를 담을 곳
                int now;

                for (int i = 1; i < queue.size(); i++) {
                    // 첫번째 문서 docArr[0]
                    now = docArr[i - 1];

                    // 첫번째 문서가 그 뒤에 올 문서들보다 중요도가 낮다면 뒤로 밀기
                    if (now < docArr[i]) {
                        // 내 타겟을 앞으로 땡김 (원형 큐이기때문에 나머지 연산)
                        M = (M - 1) % N;
                    } else if (now >= queue.peek()) {

                    }
                }
            }
        }
    }
}
