package step02;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int high = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (high)
            stack.push(input);

        }

        System.out.println(sb);
    }
}
