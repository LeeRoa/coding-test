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

        Arrays.sort(list, (s1, s2) -> s2 - s1);

//        System.out.println(Arrays.toString(list));

        int count = 0;
        int nanugi = 1;
        while (count <= N) {
            count = 0;
            for (int i = 0; i < list.length; i++) {
                count = 0;
                int num = list[i];
                for (int k = 0; k < nanugi; k++) {
                    num = num / 2; // 401
                }
//                System.out.println("타겟 랜선 길이 : " + num);
                for (int j = 0; j < list.length; j++) {
                    count = count + list[j] / num; // 0 + 802/401 (2) -> 2 + 743/401 (1) -> ...
//                    System.out.println(list[j] + " / " + num + " = " + (list[j] / num));
//                    System.out.println("현재까지의 count: " + count);
//                    System.out.println("적용 개수: " + count);
                    if (count >= N) {
                        System.out.println(num);
                        break;
                    }
                }

                if (count >= N) {
//                    System.out.println("도달: " + num);
                    break;
                }
            }

            if (count >= N) {
                break;
            }

            nanugi++;
        }
    }
}
