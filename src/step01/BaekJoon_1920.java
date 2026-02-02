package step01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer stTarget = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] checkArr = new int[100000];
        for (int i = 0; i < N; i++) {
            checkArr[Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        for (int i = 0; i < M; i++) {
            sb.append(checkArr[Integer.parseInt(stTarget.nextToken()) - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
