package step03;

public class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int maxBufferSize;

    public MyCircularQueue(int size) {
        this.maxBufferSize = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = 0; // 원형 큐의 구현 편의상 0에서 시작하는 것이 일반적입니다.
    }

    // 1. 데이터 넣기 (Enqueue)
    public boolean enqueue(int value) {
        queue[rear] = value;
        rear = (rear + 1) % maxBufferSize;

        return true;
    }

    // 2. 데이터 꺼내기 (Dequeue)
    public int dequeue() {
        int value = queue[front];
        front = (front + 1) % maxBufferSize;

        return value; // 임시 반환값
    }

    // --- 테스트용 출력 메서드 ---
    public void printStatus() {
        System.out.printf("Front: %d, Rear: %d, 배열상태: ", front, rear);
        for(int n : queue) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // 크기가 4인 큐 생성 (공간을 하나 비워두는 방식이라 실제 데이터는 3개까지 저장됨)
        MyCircularQueue q = new MyCircularQueue(4);

        System.out.println("--- 1. 데이터 채우기 ---");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printStatus(); // 10, 20, 30 잘 들어갔는지 확인

        System.out.println("\n--- 2. 데이터 2개 꺼내기 (앞쪽 공간 비우기) ---");
        System.out.println("꺼낸 값: " + q.dequeue());
        System.out.println("꺼낸 값: " + q.dequeue());
        q.printStatus();

        System.out.println("\n--- 3. 원형 회전 테스트 (비어있는 앞쪽으로 다시 들어가나?) ---");
        q.enqueue(40); // 여기서 선형 큐라면 에러가 났을 겁니다.
        q.enqueue(50);
        q.printStatus(); // Rear가 0번 인덱스로 돌아왔는지 확인하세요.
    }
}