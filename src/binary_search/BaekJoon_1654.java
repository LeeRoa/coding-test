package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon_1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Integer[] list = new Integer[K];

        for (int i = 0; i < K; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

//        System.out.println(Arrays.toString(list));

        long min = 1;
        long max = list[list.length - 1];
        ArrayList<Long> answers = new ArrayList<>();
        while (min <= max) {
            long count = 0;
            long mid = (min + max) / 2;

            for (int i = 0; i < list.length; i++) {
                count = count + list[i] / mid;
            }

//            System.out.println("count : " + count);

            if (count >= N) {
                answers.add(mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answers.get(answers.size() - 1));
    }
}
