package two_pointers;

import java.io.*;
import java.util.*;

public class BaekJoon_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] SA = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            SA[i] = num + SA[i - 1];
        }
//        System.out.println(Arrays.toString(SA));

        int min = 100001;
        int start = 1;
        int end = 1;

        while (end <= N) {
            int sum = SA[end] - SA[start - 1];
            if (sum >= S) {
                min = Math.min(min, end - start + 1);
                if (start == end) end++;
                start++;
            } else {
                end++;
            }
        }

        System.out.println(min == 100001 ? 0 : min);
    }
}
