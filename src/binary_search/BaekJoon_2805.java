package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // 20 15 10 17
        Arrays.sort(trees);

        long start = 0;
        long end = trees[trees.length - 1]; // 20
        long result = 0;
        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < trees.length; i++) {
                count = count + (trees[i] - mid < 0 ? 0 : trees[i] - mid);
            }

            if (count >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
