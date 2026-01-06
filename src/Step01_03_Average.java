import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step01_03_Average {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String scoreStr = br.readLine();

        int[] scoreArr = new int[N];
        StringTokenizer st = new StringTokenizer(scoreStr);
        int total = 0;

        for (int i = 0; i < N; i++) {
            scoreArr[i] = Integer.parseInt(st.nextToken());
            total += scoreArr[i];
        }

        double ave = (double) total / N;
        int highScoreCnt = 0;

        for (int i = 0; i < scoreArr.length; i++) {
            if (ave < scoreArr[i]) {
                highScoreCnt++;
            }
        }


        double result = highScoreCnt / (double)N * 100;

        // 내가 작성한 소스
//        System.out.printf("%.3f", result);

        // %문자열도 같이 들어가려면 이스케이프 처리를 해야함 '%%'
        System.out.printf("%.3f%%", result);
    }
}
