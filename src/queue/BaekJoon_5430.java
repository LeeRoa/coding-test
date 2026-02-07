package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BaekJoon_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte T = Byte.parseByte(br.readLine());

        // 테스트 개수만큼 4
        for (byte testcase = 0; testcase < T; testcase++) {
            // 수행할 함수 = RDD (R : 배열 뒤집기 / D : 첫번째 수 버리기)
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());
            String inputStr = br.readLine();
            String[] inputArr = inputStr.substring(1, inputStr.length() - 1).split(",");
            Deque<Integer> deque = new ArrayDeque<>();
//            byte[] arr = new byte[n];
            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(inputArr[i]));
//                arr[i] = Byte.parseByte(inputArr[i]);
            }

            // 결과를 출력할 스트링 빌더
            StringBuilder sb = new StringBuilder();
            boolean isSuccess = true;
            // 함수 개수 만큼 실행 (RDD면 뒤집기 -> 버리기 -> 버리기)
            int reverseCount = 0;
            for (int i = 0; i < p.length(); i++) {
                char func = p.charAt(i);
                // 뒤집기
                if (func == 'R') {
                    reverseCount++;
                } else if (!isEmpty(deque) && func == 'D') {
                    if (reverseCount % 2 == 1) {
                        deque.pollLast();
                    } else {
                        deque.poll();
                    }
                } else {
                    isSuccess = false;
                }
            }

            if (isSuccess) {
                sb.append("[");
                int len = deque.size();
                for (int i = 0; i < len; i++) {
                    int num;
                    if (reverseCount % 2 == 1) {
                        num = deque.pollLast();
                    } else {
                        num = deque.poll();
                    }

                    if (len - 1 != i) {
                        sb.append(num).append(",");
                    } else {
                        sb.append(num);
                    }
                }
                sb.append("]");
            } else {
                sb.append("error");
            }

            System.out.println(sb);
        }
    }

    static boolean isEmpty(Deque<Integer> deque) {
        if (deque.size() != 0) {
            return false;
        }
        return true;
    }
}
