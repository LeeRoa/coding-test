package two_pointers;

import java.util.*;
import java.io.*;

public class BaekJoon_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

//        System.out.println(Arrays.toString(A));

        int count = 0;

        for (int i = 0; i < N; i++) {
            int T = A[i];
            int left = 0;
            int right = A.length - 1;
            while (left != right) {
                if (i == left) {
                    left++;
                }

                if (i == right) {
                    right--;
                }

                if (left == right) {
                    break;
                }

                int sum = A[left] + A[right];
//                System.out.println(left + ", " + right + "= " + sum);
                if (sum == T) {
//                    System.out.println(A[left] + ", " + A[right] + "= " + sum);
//                    System.out.println("A[" + left + "]" + ", " + "A[" + right + "]" + "= " + sum);
                    count++;
                    break;
                } else if (sum > T) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(count);
    }
}
