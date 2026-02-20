package two_pointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        System.out.println(Arrays.toString(nums));

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;
        while (end != N - 1) {
            if (sum == N) {
                count++;
                end++;
            } else if (sum > N) {
                start++;
            } else {
                end++;
            }
        }
        System.out.println(count);
    }
}
