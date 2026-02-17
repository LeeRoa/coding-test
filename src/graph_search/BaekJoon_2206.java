package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_2206 {
    static class Map {
        int[][] world;
        int result;

        Map(int row, int col) {
            world = new int[row][col];
            result = 0;
        }
    }

    static class Location {
        int row;
        int col;

        Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int ROW, COL;
    static boolean[][] visited;
    static int[] dCol = {-1, 1, 0, 0};
    static int[] dRow = {0, 0, -1, 1};
    static ArrayList<Location> walls = new ArrayList<>();
    static ArrayList<Map> maps = new ArrayList<>();
    static Location startPoint = new Location(0,0);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        Map map = new Map(ROW, COL);
        for (int row = 0 ; row < ROW; row++) {
            char[] rows = br.readLine().toCharArray();
            for (int col = 0; col < COL; col++) {
                int num = rows[col] == '1' ? 1 : 0;
                map.world[row][col] = num;

                if (num == 1)
                    walls.add(new Location(row, col));
            }
        }

        for (int i = 0; i < walls.size(); i++) {
            Location wall = walls.get(i);
            map.world[wall.row][wall.col] = 0;
            maps.add(map);
            map.world[wall.row][wall.col] = 1;
        }

        for (int i = 0; i < walls.size(); i++) {
            visited = new boolean[ROW][COL];
            Map map1 = maps.get(i);
            bfs(map1);
            map1.result = map1.world[ROW - 1][COL - 1];
        }

        Collections.sort(maps, (s1, s2) -> s1.result - s2.result);


        boolean ok = false;
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).result > ROW + COL) {
                ok = true;
                break;
            }
        }
    }

    static void bfs(Map map) {
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(startPoint);
        visited[startPoint.col][startPoint.row] = true;

        while (!queue.isEmpty()) {
            Location here = queue.poll();

            for (int i = 0; i < dCol.length; i++) {
                int targetRow = here.row + dRow[i];
                int targetCol = here.col + dCol[i];

                if (targetRow >= 0 && targetRow < ROW
                        && targetCol >= 0 && targetCol < COL
                        && map.world[targetRow][targetCol] == '0'
                        && !visited[targetRow][targetCol]) {
                    queue.offer(new Location(targetRow, targetCol));
                    visited[targetRow][targetCol] = true;
                    map.world[targetRow][targetCol] = map.world[here.row][here.col] + 1;
                }
            }
        }
    }
}
