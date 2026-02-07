package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer stTarget = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N개의 정수 세팅 [4, 1, 5, 2, 3]
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // [1, 2, 3, 4, 5]
        Arrays.sort(list);

        // 타겟마다 조회 [1, 3, 7, 9, 5]
        for (int i = 0; i < M; i++) {
            // [1]
            boolean ok = false;
            int target = Integer.parseInt(stTarget.nextToken());
            int start = 0;
            int end = list.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                // 정확히 중간에 찾았다면
                if (target == list[mid]) {
                    ok = true;
                    break;
                } else if (target > list[mid]) {
                // 타겟이 더 크다면
                    start = mid + 1;
                } else {
                    // 타겟이 더 작다면
                    end = mid - 1;
                }
            }

            if (ok) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}
