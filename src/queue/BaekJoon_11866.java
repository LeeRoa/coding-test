package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 [문제: 요세푸스 문제 0 (백준 11866번)]
 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 이제 순서대로 K번째 사람을 제거한다.
 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.

 예를 들어 (7, 3)-요세푸스 순열을 구해보자.
 1, 2, 3, 4, 5, 6, 7번 사람이 있다.
 - 1, 2번을 건너뛰고 3번을 제거한다.
 - 4, 5번을 건너뛰고 6번을 제거한다.
 - 7, 1번을 건너뛰고 2번을 제거한다.
 ...
 이 과정을 반복하여 제거되는 순서대로 출력하면 된다.

 [입력]
 첫째 줄에 N과 K가 빈 칸을 사이에 두고 주어진다. (1 ≤ K ≤ N ≤ 1,000)

 [출력]
 예제와 같이 요세푸스 순열을 출력한다. (형식: <3, 6, 2, 7, 5, 1, 4>)

 [예제 입력]
 7 3

 [예제 출력]
 <3, 6, 2, 7, 5, 1, 4>
 */
public class BaekJoon_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> killLog = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        int i = 1;
        while (queue.size() != 0) {
            // K번째 사람을 제거한다.
            if (i % K == 0) {
                killLog.add(queue.poll());
            } else {
                queue.offer(queue.poll());
            }
            i++;
        }
        String str = killLog.toString();
        str = str.substring(1, str.length() - 1);
        System.out.print("<" + str + ">");
    }
}
