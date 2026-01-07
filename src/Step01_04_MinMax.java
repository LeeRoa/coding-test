import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step01_04_MinMax {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];

        sort(N, numArr, st);
    }

    /**
     * 내가 직접 짠 정렬 코드
     */
    private static void sort(int N, int[] numArr, StringTokenizer st) throws Exception {
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < i; j++) {
                int temp = 0;
                if (numArr[i] < numArr[j]) {
                    temp = numArr[j];
                    numArr[j] = numArr[i];
                    numArr[i] = temp;
                } else {
                    break;
                }
            }
        }

        System.out.println(numArr[0] + " " + numArr[numArr.length - 1]);
    }

    /**
     * 제미나이가 직접 짠 시간복잡도 고려한 정렬 코드
     * 데이터가 많이 들어오는 것을 고려해서 사용할 수 있는 효율적인 코드임.
     */
    private static void sort_answer(int N, int[] numArr, StringTokenizer st) throws Exception {
        int min = 1000001;
        int max = -1000001;

        for (int i = 0; i < N; i++) {
            if (numArr[i] < min) {
                min = numArr[i];
            }

            if (numArr[i] > max) {
                max = numArr[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
