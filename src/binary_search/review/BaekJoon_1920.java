package binary_search.review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(nums);
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean ok = false;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (target < nums[mid]) {
                    end = mid + 1;
                }

                if (target > nums[mid]) {
                    start = mid + 1;
                }

                if (target == nums[mid]) {
                    ok = true;
                    break;
                }
            }

            if (ok) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
