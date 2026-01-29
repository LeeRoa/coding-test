package step01;

class Node {
    int data;
    Node next;

    public Node(int data) { this.data = data; }
}

public class MyLinkedListTest {
    public static void main(String[] args) {
        Node A = new Node(10);
        Node B = new Node(20);
        A.next = B; // 현재 상태: A -> B
        
        Node newNode = new Node(99); 

        // TODO: A -> newNode -> B 가 되도록 연결 로직 작성
        newNode.next = A.next;
        A.next = newNode;

        
        // 결과 확인
        Node current = A;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }
}