import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step01_07_Remainder {

    /**
     * 나머지 (나만의 체크리스트 구현)
     * 문제: 숫자 10개를 입력받은 뒤, 이를 각각 42로 나눈 나머지를 구합니다. 그중 서로 다른 값이 몇 개 있는지 출력하세요.
     * 입력: 10개의 자연수 (한 줄에 하나씩 혹은 공백 구분)
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[10];
        int[] namergeArr = new int[42];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
            int now = numArr[i] % 42;
            namergeArr[now]++;
        }

        int result = 0;
        for (int i = 0; i < namergeArr.length; i++) {
            if (namergeArr[i] != 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
