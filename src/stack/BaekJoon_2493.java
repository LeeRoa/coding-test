package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon_2493 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 탑의 개수
        int N = Integer.parseInt(br.readLine());

        // 탑의 정렬 [6, 9, 5, 7, 4]
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> seq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            // input =  7
            // seq =    [2, 4]
            // stack =  [9, 7]
            // sb =     [0 0 ]
            int input = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                // 맨위의 값과 들어온 input의 값을 비교한다. 6 < 9 [6, 9]
                if (stack.peek() < input) {
                    // input이 더크다면 스택에 있는 맨 위의 값을 지운다.
                    stack.pop(); // 6 pop []
                    seq.pop();
                } else {
                    // 만약 input이 peek한 것보다 더 작다면 그대로 값을 push 한다.
                    //  9 > 7
                    stack.push(input);
                    sb.append(seq.peek()).append(" "); // high = 2 그 값을 append한다.
                    seq.push(i);
                    break;
                }
            }

            // 스택에 아무것도 없다면 원소를 집어넣는다.
            if (stack.isEmpty()) {
                sb.append("0").append(" ");
                seq.push(i);
                stack.push(input);
            }
        }

        System.out.println(sb);
    }
}
