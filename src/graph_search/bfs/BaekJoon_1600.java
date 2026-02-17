package graph_search.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1600 {
    static class Point {
        int w;
        int h;
        int count;
        int k;

        Point (int w, int h, int count, int k) {
            this.w = w;
            this.h = h;
            this.count = count;
            this.k = k;
        }
    }

    static int K, W, H;
    static boolean[][][] visited;
    static int[][] map;

    static int[] dW = {-1, 1, 0, 0};
    static int[] dH = {0, 0, -1, 1};

    static int[] horseW = {-2, 2, -1, 1, -2, 2, 1, -1};
    static int[] horseH = {-1, 1, -2, 2, 1, -1, -2, 2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                map[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.w == W - 1 && point.h == H - 1) {
                return point.count;
            }

            // 인접 이동
            for (int i = 0; i < dW.length; i++) {
                int nextW = point.w + dW[i];
                int nextH = point.h + dH[i];

                if (nextW < 0 || nextW >= W || nextH < 0 || nextH >= H) continue;

                // 장애물 x -> 걷기
                if (map[nextH][nextW] == 0 && !visited[nextH][nextW][point.k]) {
                    queue.offer(new Point(nextW, nextH, point.count + 1, point.k));
                    visited[nextH][nextW][point.k] = true;
                }
            }

            if (point.k < K) {
                for (int i = 0; i < horseW.length; i++) {
                    int nextW = point.w + horseW[i];
                    int nextH = point.h + horseH[i];

                    if (nextW < 0 || nextW >= W || nextH < 0 || nextH >= H) continue;

                    if (map[nextH][nextW] == 0 && !visited[nextH][nextW][point.k + 1]) {
                        queue.offer(new Point(nextW, nextH, point.count + 1, point.k + 1));
                        visited[nextH][nextW][point.k + 1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
