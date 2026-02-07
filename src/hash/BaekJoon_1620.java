package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekJoon_1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도감에 수록된 포켓몬 개수
        int N = Integer.parseInt(st.nextToken());
        // 내가 맞춰야하는 문제의 개수
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> dogamKey = new HashMap<>();
        Map<String, String> dogamValue = new HashMap<>();
        // 포켓몬 도감 생성
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            dogamKey.put(String.valueOf(i), str);
            dogamValue.put(str, String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        // 미션
        for (int i = 0; i < M; i++) {
            String find = br.readLine();


            // 만약 도감에 find 값이 Key로 들어있다면?
            if (dogamKey.containsKey(find)) {
                // value 값을 꺼낸다.
                sb.append(dogamKey.get(find));
            } else {
               // 만약 find가 이름이라면 키 값을 반환해야 한다.
                sb.append(dogamValue.get(find));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
