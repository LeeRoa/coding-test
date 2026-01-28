package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step02_06_MinStack {
    /**
     * 문제 설명
     * 정수를 저장하는 스택을 구현하되, 다음 네 가지 명령을 처리할 수 있어야 합니다:
     * 1. push X: 정수 X를 스택에 넣는다.
     * 2. pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우 -1을 출력한다.
     * 3. top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우 -1을 출력한다.
     * 4. min: 스택에 들어있는 정수 중 최솟값을 출력한다. 만약 스택에 들어있는 정수가 없는 경우 -1을 출력한다.
     * ================================================================
     * 제약 사항
     * 1. Java에서 제공하는 java.util.Stack 클래스를 사용하지 마세요.
     * 2. 배열을 이용하여 스택을 직접 구현해야 합니다.
     * 3. 각 명령어는 O(1) 시간복잡도로 동작해야 합니다. (min 명령도 O(1)!)
     * 4. 명령의 수 N (1 <= N <= 100,000)
     * 5. 스택에 들어가는 정수는 1 이상 100,000 이하입니다.
     * ================================================================
     * 입력
     * 첫째 줄에 명령의 수 N이 주어집니다.
     * 둘째 줄부터 N개의 줄에 명령이 하나씩 주어집니다.
     * ================================================================
     * 출력
     * 출력해야 하는 명령이 주어질 때마다, 한 줄에 하나씩 출력합니다.
     * ================================================================
     * 예시 입력
     * 10
     * push 5
     * push 3
     * min
     * push 7
     * min
     * top
     * pop
     * top
     * pop
     * min
     * ================================================================
     * 예시 출력
     * 3
     * 3
     * 7
     * 7
     * 3
     * 3
     * 5
     */
    public static void main(String[] args) throws Exception {
        final String PUSH = "push";
        final String MIN = "min";
        final String TOP = "top";
        final String POP = "pop";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int top = 0;
        int[] numArr = new int[N];
        int[] minArr = new int[N];
        int minNum = 100000;
        int minTop = 0;
        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();
            StringTokenizer st = new StringTokenizer(inputStr);
            String commend = st.nextToken();
            
            if (PUSH.equals(commend)) {
                int num = Integer.parseInt(st.nextToken());
                    numArr[top++] = num;
                    if (minNum >= num) {
                        minNum = num;
                        minArr[minTop++] = minNum;
                    }
            } else {
                if (top != 0) {
                    if (POP.equals(commend)) {
                        System.out.println(numArr[top-1]);
                        if (minNum == numArr[top-1]) {
                            minArr[minTop-1] = 0;
                            if (minTop > 0) {
                                minTop--;
                            }
                            
                            if (minTop == 0) {
                                minNum = 100000;   
                            } else {
                                minNum = minArr[minTop-1];
                            }
                        }
                        top--;
                    } else if (TOP.equals(commend)) {
                        System.out.println(numArr[top-1]);
                    } else if (MIN.equals(commend)) {
                        System.out.println(minArr[minTop-1]);
                    }
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
    
    /**
     * ================================================================
     * 개선된 코드 (더 간단하고 효율적인 방법)
     * ================================================================
     * 핵심 아이디어:
     * - 두 개의 스택(stack, minStack)을 동일한 크기로 유지
     * - push할 때마다 무조건 minStack에 "현재까지의 최솟값"을 저장
     * - top 포인터 하나로 두 스택 모두 관리
     * - pop할 때는 별도 처리 필요 없음 (자동으로 이전 최솟값 복구)
     * ================================================================
     */
    public static void solution_improved(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int top = 0;
        int[] stack = new int[N];      // 실제 값을 저장하는 스택
        int[] minStack = new int[N];   // 각 시점의 최솟값을 저장하는 스택
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack[top] = num;
                
                // 핵심: push할 때마다 무조건 현재까지의 최솟값을 minStack에 저장
                if (top == 0) {
                    minStack[top] = num;  // 첫 번째 요소
                } else {
                    minStack[top] = Math.min(minStack[top - 1], num);  // 이전 최솟값과 비교
                }
                
                top++;
            } else if (command.equals("pop")) {
                if (top > 0) {
                    System.out.println(stack[--top]);
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("top")) {
                if (top > 0) {
                    System.out.println(stack[top - 1]);
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("min")) {
                if (top > 0) {
                    System.out.println(minStack[top - 1]);  // 현재 top의 최솟값 출력
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
