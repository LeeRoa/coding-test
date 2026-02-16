package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2231 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result  = 0;
        for (int i = 0 ; i < N; i++) {
            char[] num = String.valueOf(i).toCharArray();
            int total = i;

            for (int j = 0; j < num.length; j++) {
                total += Integer.parseInt(String.valueOf(num[j]));
            }

            if (total == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
