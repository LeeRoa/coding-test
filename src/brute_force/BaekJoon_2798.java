package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_2798 {
    static int N, M;
    static int[] cards;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                for (int k = 0; k < cards.length; k++) {
                    if (i != j && j != k && i != k) {
                        if (cards[i] + cards[j] + cards[k] <= M) {
                            results.add(cards[i] + cards[j] + cards[k]);
                        }
                    }
                }
            }
        }


        if (!results.isEmpty()) {
            Collections.sort(results, (s1, s2) -> s2 - s1);

            System.out.println(results.get(0));
        }
    }
}
