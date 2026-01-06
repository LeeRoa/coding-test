import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step01_02_SumN {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();
        int N = Integer.parseInt(line1);
        char[] charset = line2.toCharArray();
        int total = 0;
        for (int i = 0; i < charset.length; i++) {
            // 내가 작성한 코드
//            total += Integer.parseInt(String.valueOf(charset[i]));

            /*
                제미나이가 제안한 코드 (더 효율적임) 아스키코드를 이용해서
                '1' = 49
                '0' = 48 이므로 '0'을 이용해서 덧셈 뺄셈을 진행하는것이 속도가 더 빠름
             */
            total += charset[i] + '0';
        }

        System.out.println(total);
    }
}
