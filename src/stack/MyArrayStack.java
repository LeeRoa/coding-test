package stack;

public class MyArrayStack {
    private int[] stack;
    private int top; // 스택의 가장 위(마지막 데이터)를 가리키는 인덱스

    public MyArrayStack(int size) {
        this.stack = new int[size];
        this.top = -1; // 초기엔 비어있음
    }

    // 1. push: 데이터를 넣는다.
    public void push(int value) {
        stack[++top] = value;
    }

    // 2. pop: 데이터를 뺀다.
    public int pop() {
        int value = stack[top];
        top--;

        return value; // 임시 반환값
    }

    // 테스트용 메인 함수
    public static void main(String[] args) {
        MyArrayStack s = new MyArrayStack(5);
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop()); // 30 출력 되어야 함
        System.out.println(s.pop()); // 20 출력 되어야 함
        System.out.println(s.pop()); // 10 출력 되어야 함
    }
}
