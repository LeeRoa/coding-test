package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step02_04_StackSequence {
    /**
     * 문제 설명
     * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있습니다.
     * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 가정합시다.
     * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지 알아내는 프로그램을 작성하세요.
     * *********************************************************
     * 제약 사항
     * 1. Java에서 제공하는 java.util.Stack 클래스를 사용하지 마세요.
     * 2. 배열과 top 변수를 활용하여 스택을 직접 구현해 사용하세요.
     * 3. n (1 <= n <= 100,000)
     * *********************************************************
     * 입력
     * 첫째 줄에 n이 주어집니다.
     * 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어집니다.
     * 똑같은 정수가 두 번 나오는 경우는 없습니다.
     * *********************************************************
     * 출력
     * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력합니다.
     * push 연산은 +로, pop 연산은 -로 출력합니다.
     * 불가능한 경우 "NO"를 출력합니다.
     * *********************************************************
     * 예시 입력 1
     * 8
     * 4
     * 3
     * 6
     * 8
     * 7
     * 5
     * 2
     * 1
     * *********************************************************
     * 예시 출력 1
     * +
     * +
     * +
     * +
     * -
     * -
     * +
     * +
     * -
     * +
     * +
     * -
     * -
     * -
     * -
     * -
     * *********************************************************
     * 예시 입력 2
     * 5
     * 1
     * 2
     * 5
     * 3
     * 4
     * *********************************************************
     * 예시 출력 2
     * NO
     */
    static String push = "+";
    static String pop = "-";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] targetArr = new int[n]; // 타겟배열
        int[] stack = new int[n]; // 스택배열
        for (int i = 0; i < n; i++) {
            targetArr[i] = Integer.parseInt(br.readLine());
        }

        int top = 0; // 스택의 포인터
        int startNum = 1; // 대기줄 숫자
        List<String> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           int target = targetArr[i];

           // 타겟에 맞출 대기 숫자를 계속 증가시켜 타겟숫자와 맞을때까지 스택배열에 계속 쌓는다.
           while (startNum <= target) {
               stack[top++] = startNum++;
               results.add(push);
           }

           // 스택 가장 위 포인터의 값과 타겟의 값이 맞다면 pop을 한다.
           if (stack[top - 1] == target) {
               top--;
               results.add(pop);
           } else {
               System.out.println("NO");
               return;
           }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
