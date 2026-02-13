package graph_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon_7569 {
    static int COL, ROW, H;
    static Box[] boxs;

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
        int status;

        Tomato(int row, int col, int status) {
            this.row = row;
            this.col = col;
            this.status = status;
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

            for (int row = 0; row < ROW; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < COL; col++) {
                    int status = Integer.parseInt(st.nextToken());
                    box.tomatos[row][col] = new Tomato(row, col, status);
                }
            }


        }
    }
}
