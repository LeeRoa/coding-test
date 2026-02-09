import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_9375 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        // 테스트 케이스 [2]
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < testcase; test++) {
            // 가진 의상 수 [3]
            // hat headgear
            // sunglasses eyewear
            // turban headgear
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }

            // 곱셈을 해야하기때문에 1
            int count = 1;
            for (String key : map.keySet()) {
                // 안쓴다는 경우의수도 모든 옷 종류에 하나씩 추가해서 모든 밸류 값을 곱해서 더함 == 경우의 수 생성
                count = count * (map.get(key) + 1);
            }
            sb.append(count - 1).append("\n"); // 그 중에 모든 것을 안 입는 경우는 제외해야하기에 -1
        }

        System.out.println(sb);
    }
}
