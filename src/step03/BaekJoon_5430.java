package step03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트 개수만큼
        for (int testcase = 0; testcase < T; testcase++) {
            // 수행할 함수 (R : 뒤집기 / D : 버리기)
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            // 수행할 배열
            byte[] nums = new byte[n];
            // 출력할 스트링 빌더
            StringBuilder sb = new StringBuilder();

            // 함수 개수 만큼 실행
            for (int i = 0; i < p.length(); i++) {

            }
        }
    }
}
