package prefix_sum;

import java.io.*;
import java.util.*;

public class BaekJoon_16139 {
    // 문자, 문자열 구간 l, r
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // [h, e, l, l, o]
        char[] A = br.readLine().toCharArray();
        int[][] counts = new int[A.length][27];
//        System.out.println(Arrays.toString(A));

        for (int i = 0; i < A.length; i++) {
            int charIndex = A[i] - 97;

            // 알파벳에 대한 카운트 진행
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    // 첫번째에는 이전 데이터가 없기때문에
                    counts[i][charIndex] = (j == counts[i][charIndex]) ? 1 : 0;
                } else {
                    counts[i][j] = counts[i - 1][j];
                }
            }

            counts[i][charIndex]++;
        }

//        check(counts);

        // 질문 횟수
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // 시작 점이 0이면 뺄값이 없기때문에
            if (l == 0) {
                sb.append(counts[r][ch - 97]).append("\n");
            } else {
                sb.append(counts[r][ch - 97] - counts[l - 1][ch - 97]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void check(int[][] arr) {
        System.out.println("==============================");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
