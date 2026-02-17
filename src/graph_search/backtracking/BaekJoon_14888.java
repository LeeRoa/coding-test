package graph_search.backtracking;

import java.io.*;
import java.util.*;

public class BaekJoon_14888 {
    static int N;
    static boolean[] V;
    static int[] nums;
    static int[] opers = new int[4]; // +, -, *, /
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        V = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(st.nextToken());
        }
    }

    /*
       작성순서:
       1. 재귀함수를 이용하여 매개변수로 끝까지 들어가서 연산을 진행하기 위해 depth와 연산을 진행할 연산자 및 숫자를 받는다.
       2. 먼저 깊이를 체크한다. 만약 N과 같다면 현재 매개변수로 받은 숫자와 연산자를 조합해서 더하고 리턴한다.
       3. for문으로 먼저 nums에 들어있는 값들을 체크한다.
            3.1. nums에서 이미 방문한 숫자 값인지 확인한다.
            3.2. for문으로 사용할 연산자를 체크한다. 연산자가 0인 경우는 사용할 수 없으니 1이 나오면 -1 사용하고 나서는
                재귀 탈출 후 다시 +1을 해준다.
            3.3. 연산자를 골랐다면 재귀를 호출한다. (현재 숫자와 선택된 연산자를 함께 집어넣는다.)
            3.4. 깊이가 N일때까지 재귀를 반복한 뒤에 하나씩 위로 빠져나온다
                (빠져나올때 사용했던 연산자는 되돌려지며, 연산을 수행 후 값을 리턴받는다.)
            3.5. 리턴받은 값을 이후에 더한다. (맨위 depth 0에서 최종적으로 더한 값을 리턴 받을 수 있다.)
       4. 리턴된 값들이 최소값인지 최대값인지 구하기 위해서는 숫자에 모든 경우의 수(연산자)를 다 대입해보아야 한다.

     */

    static void backtraking(int depth) {
        if (depth == N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!V[i]) {
            }
        }
    }
}
