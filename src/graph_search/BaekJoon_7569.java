package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7569 {
    static int COL, ROW, H;
    static Box[] boxs;
    static ArrayList<Tomato> startPoint = new ArrayList<>();

    static int[] dCol = {0, 0, -1, 1, 0, 0};
    static int[] dRow = {0, 0, 0, 0, -1, 1};
    static int[] dH = {0, 1, -1};

    static int max = 0;
    static class Box {
        int height;
        Tomato[][] tomatos;

        Box(int height) {
            this.height = height;
            tomatos = new Tomato[ROW][COL];
        }
    }

    static class Tomato {
        int row;
        int col;
        int height;
        int status;
        boolean visited;

        Tomato(int row, int col, int height, int status) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.status = status;
            visited = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        COL = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boxs = new Box[H];

        for (int i = 0; i < H; i++) {
            Box box = new Box(i);

            // 박스에 토마토 세팅
            for (int row = 0; row < ROW; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < COL; col++) {
                    int status = Integer.parseInt(st.nextToken());
                    Tomato tomato = new Tomato(row, col, i, status);

                    if (status == 1) {
                        startPoint.add(tomato);
                    }
                    box.tomatos[row][col] = tomato;
                }
            }

            boxs[i] = box;
        }

        // 스타트 지점이 있다면
        if (!startPoint.isEmpty()) {
            check();
            bfs();

//            if (!check()) {
//                System.out.println(-1);
//            } else {
//                System.out.println(max - 1);
//            }
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue<Tomato> queue = new ArrayDeque<>();
        for (Tomato tomato : startPoint) {
            queue.offer(tomato);
            tomato.visited = true;
        }

        while (!queue.isEmpty()) {
            check();
            Tomato tomato = queue.poll();

            for (int i = 0; i < dH.length; i++) {
                int h = tomato.height + dH[i];

                for (int j = 0; j < dCol.length; j++) {
                    int row = tomato.row + dRow[j];
                    int col = tomato.col + dCol[j];

                    if (row >= 0 && row < ROW && col >= 0 && col < COL && h >= 0 && h < H
                            && boxs[h].tomatos[row][col].status == 0) {
                        Tomato targetTomato = boxs[h].tomatos[row][col];
                        targetTomato.status = tomato.status + 1;
                        targetTomato.visited = true;
                        queue.offer(targetTomato);
                    }
                }
            }
        }
    }

    static boolean check() {
        int floor = 0;
        for (Box box : boxs) {
            floor++;
            System.out.println();
            System.out.println(floor + "층==================================================");
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
//                    if (box.tomatos[i][j].status == 0) {
//                        return false;
//                    }
//                    max = Math.max(box.tomatos[i][j].status, max);

                    System.out.print(box.tomatos[i][j].status);
                    System.out.print(", ");
                }
                System.out.println();
            }
        }

        return true;
    }
}
