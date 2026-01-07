import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step01_06_Count {
    /**
     * 문제: 총 N개의 정수가 주어졌을 때, 정수 V가 몇 개 포함되어 있는지 구하세요.
     * 입력:첫째 줄에 정수의 개수
     * N (1 <= N <= 100)둘째 줄에 정수들이 공백으로 구분되어 주어짐
     * 셋째 줄에 찾으려는 정수 V가 주어짐
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int count = 0;
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            if (numArr[i] == V) {
                count++;
            }
        }

        System.out.println(count);

    }
}
