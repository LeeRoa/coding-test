package greedy;

import java.io.*;
import java.util.*;

public class BaekJoon_1541 {
    // 55-50+40
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Queue<Integer> numQueue = new ArrayDeque<>();
        Queue<Character> operQueue = new ArrayDeque<>();
        int sum = 0;
        int minusCount = 0;
        int jarisu = 0;
        int num = 0;
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];

//            System.out.println("ch : " + ch);
            if (ch == '-' || ch == '+') {
                operQueue.offer(ch);
                jarisu = 0;
                numQueue.offer(num);

                if (ch == '-') {
                    minusCount++;
                }
            } else {
                jarisu++;
//                System.out.println("자릿수: " + jarisu);
//                System.out.println("num: " + num);
                if (jarisu == 1) {
                    num = ch - '0';
                } else {
                    // 들어온 값이 숫자라면
                    for (int j = 1; j < jarisu; j++) {
                        num = num * 10 + (ch - '0');
                    }
                }
            }
        }

        numQueue.offer(num);


//        System.out.println(numQueue);
//        System.out.println(operQueue);

        while (!operQueue.isEmpty()) {
            int A = numQueue.poll();

            char oper = operQueue.poll();

            System.out.println("A: " + A);
            System.out.println("oper: " + oper);
            System.out.println("operQueue: " + operQueue);
            System.out.println("numQueue: " + numQueue);
            if (oper == '-') {
                numQueue.offer(A);
            } else if (oper == '+') {
                int B = numQueue.poll();
                sum += A + B;
            }
        }

        if (minusCount != 0) {
            System.out.println(minusCount);
            System.out.println(numQueue);
            for (int num2 : numQueue) {
                sum = sum * -1 + num2;
                System.out.println("sum : " + sum);
            }
        }

        System.out.println(sum);
    }
}
