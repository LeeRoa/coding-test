package queue;

public class MyLinearQueue {
    private int[] queue;
    private int front; // 출구: 나갈 차례인 녀석의 위치
    private int rear;  // 입구: 가장 마지막에 들어온 녀석의 위치
    private int maxBufferSize;

    public MyLinearQueue(int size) {
        this.maxBufferSize = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1; // 아무것도 없는 상태
    }

    // 1. 데이터 넣기 (줄 서기)
    public void enqueue(int value) {
        queue[++rear] = value;
    }

    // 2. 데이터 꺼내기 (입장 시키기)
    public int dequeue() {
        int value = queue[front];
        front++;
        return value;
    }

    // 테스트용
    public void printStatus() {
        System.out.printf("Front: %d, Rear: %d\n", front, rear);
    }

    public static void main(String[] args) {
        MyLinearQueue q = new MyLinearQueue(5);

        System.out.println("--- 데이터 3개 입력 ---");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printStatus(); // Front: 0, Rear: 2 예상

        System.out.println("--- 데이터 1개 삭제 ---");
        System.out.println("나간 값: " + q.dequeue()); // 10 예상
        q.printStatus(); // Front: 1, Rear: 2 예상 (Front가 따라감!)
    }
}
