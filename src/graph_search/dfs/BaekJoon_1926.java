package graph_search.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1926 {
    static int COL, ROW;
    static int[][] paper;
    static boolean[][] visited;
    static int allCount = 0;

    static int[] dCol = {0, 0, -1, 1};
    static int[] dRow = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken()); // 세로
        ROW = Integer.parseInt(st.nextToken()); // 가로

        visited = new boolean[COL][ROW];
        paper = new int[COL][ROW];

        for (int col = 0; col < COL; col++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            for (int row = 0; row < ROW; row++) {
                paper[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> counts = new ArrayList<>();

        for (int col = 0; col < COL; col++) {
            for (int row = 0; row < ROW; row++) {
                allCount = 0;
                if (paper[col][row] == 1 && !visited[col][row]) {
                    dfs(col, row);
                }

                if (allCount != 0) {
                    counts.add(allCount);
                }
            }
        }

        Collections.sort(counts, (s1, s2) -> s2 - s1);

//        System.out.println(counts);
        System.out.println(counts.size());
        if (!counts.isEmpty()) {
            System.out.println(counts.get(0));
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int col, int row) {
        allCount++;
        visited[col][row] = true;

        for (int i = 0; i < 4; i++) {
            int newCol = col + dCol[i];
            int newRow = row + dRow[i];

            if (newCol >= 0 && newCol < COL && newRow >= 0 && newRow < ROW && paper[newCol][newRow] == 1 && !visited[newCol][newRow]) {
                dfs(newCol, newRow);
            }
        }
    }
}
