package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon_1018 {
    static int N, M;
    static char[][] board;
    static char[][] newBoard = new char[8][8];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < N - 7 && j < M - 7) {
//                    System.out.println("시작좌표 : " + i + " , " + j);
                    list.add(check(j, i));
                }
            }
        }

        Collections.sort(list);
//        System.out.println(list);

        System.out.println(list.get(0));
    }

    // 보드판 색상 체크 (시작 x, y가 흰색인 경우, 검은색인 경우 두가지 모두 체크 후 더 낮은 값을 반환한다.
    static int check(int x, int y) {
        int bStart = 0; // 시작좌표가 검은색이어야함
        int wStart = 0; // 시작좌표가 흰색이어야함
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
//                System.out.println("[" + i + ", " + j + "]");
                if (i % 2 == 1 && j % 2 == 1) {
                    // 둘다 홀수라면 -> 흰색
                    if (board[i][j] != 'W') {
                        wStart++;
                    } else {
                        bStart++;
                    }
                } else if (i % 2 == 0 && j % 2 == 0) {
                    // 둘다 짝수라면 -> 흰색
                    if (board[i][j] != 'W') {
                        wStart++;
                    } else {
                        bStart++;
                    }
                } else {
//                    System.out.println("너 여기니? : " + board[i][j]);
                    // 둘중 하나라도 홀수라면 -> 검정색
                    if (board[i][j] == 'W') {
                        wStart++;
                    } else {
                        bStart++;
                    }
                }
//                System.out.println("bStart : " +  bStart);
//                System.out.println("wStart : " +  wStart);
//                System.out.println("----------------------------------------------------------");
            }
        }

//        System.out.println("bStart : " +  bStart);
//        System.out.println("wStart : " +  wStart);

        if (bStart > wStart) {
            return wStart;
        }

        return bStart;
    }
}
