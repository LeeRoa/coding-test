package prefix_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // [5, 4, 3, 2, 1]
        int[] nums = new int[N + 1];
        // [5, 9, 12, 14, 15]
        int[] sums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N + 1; i++) {
            if (i == 0) continue;
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if (i == 1) {
                sums[i] = num;
            } else {
                sums[i] = num + sums[i - 1];
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sums));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sums[end] - sums[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
