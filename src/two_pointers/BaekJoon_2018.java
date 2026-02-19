package two_pointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;
        while (end != N) {
//            System.out.println(start + ", " + end + "합계: " + sum);
            if (sum < N) {
                end++;
                sum = sum + end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
//                System.out.println("hit:" + start + ", " + end);
                count++;
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
