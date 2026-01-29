public class MyArrayTest {

    /** 최적화 방식: 오른쪽에서 왼쪽으로 밀기 (임시 배열 없음, O(1) 추가 공간) */
    public static int insertOptimized(int[] arr, int count, int targetIndex, int newValue) {
        for (int i = count - 1; i >= targetIndex; i--) {
            arr[i + 1] = arr[i];
        }
        arr[targetIndex] = newValue;
        return count + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        // 초기 데이터: [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
        for (int i = 0; i < 5; i++) arr[i] = i + 1;
        
        int count = 5;       // 현재 데이터 개수
        int targetIndex = 2; // 삽입할 위치
        int newValue = 99;   // 삽입할 값

        // 2와 3사이에 99
        int[] temp = new int[count - targetIndex]; // {3, 4, 5}
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[targetIndex + i];
        }

        for (int i = targetIndex; i < count; i++) {
            arr[i + 1] = temp[i - targetIndex];
        }
        
        // 데이터 삽입
        arr[targetIndex] = newValue;
        count++;

        // 결과 확인
        for (int i : arr) System.out.print(i + " ");
    }
}