package two_pointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        int[] S = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = i + 1;
            S[i] = S[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(nums));

        int start = 0;
        int end = 0;
        int count = 0;
        while (start != nums.length - 1) {
            System.out.println("start: " + nums[start] + ", end: " + nums[end] + " = " + (nums[start] + nums[end] == 15));
            int sum = nums[start] + nums[end];
            if (sum == N) {
                count++;
                start = start + 1 > nums.length - 1 ? start : start + 1;
            } else if (sum > N) {
                start = start + 1 > nums.length - 1 ? start : start + 1;
            } else {
                end = end + 1 > nums.length - 1 ? end : end + 1;
            }
        }
        System.out.println(count);
    }
}
