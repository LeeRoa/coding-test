package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> noEar = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            noEar.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            // 중복이라면 듣보잡임
            if (noEar.contains(name)) {
                list.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        // 사전순 정렬
        Collections.sort(list);

        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
