package hand_coding;

import java.util.Arrays;

public class VersionComparator {

    public int compareVersion(String v1, String v2) {
        String[] v1s = v1.split("\\.");
        String[] v2s = v2.split("\\.");

        System.out.println(Arrays.toString(v1s));
        System.out.println(Arrays.toString(v2s));
        int N = 0; int select = 0;
        if (v1s.length > v2s.length) {
            select = 2; N = v2s.length;
        } else if (v1s.length < v2s.length) {
            select = 1; N = v1s.length;
        } else {
            N = v1s.length;
        }

        for (int i = 0; i < N; i++) {
            int cv1 = Integer.parseInt(v1s[i]);
            int cv2 = Integer.parseInt(v2s[i]);
            if (cv1 > cv2) return 1;
            else if (cv1 < cv2) return -1;
            else continue;
        }

        if (select == 1 && Integer.parseInt(v2s[v1s.length]) > 0) return -1;
        else if (select == 2 && Integer.parseInt(v1s[v2s.length]) > 0) return 1;

        return 0;
    }

    public static void main(String[] args) {
        VersionComparator vc = new VersionComparator();

        // 테스트 케이스
        System.out.println(vc.compareVersion("1.0.1", "1"));      // 예상: 1
        System.out.println(vc.compareVersion("7.5.24", "7.5.3"));  // 예상: 1
        System.out.println(vc.compareVersion("1.01", "1.001"));   // 예상: 0 (둘 다 1)
        System.out.println(vc.compareVersion("1.0", "1.0.0"));    // 예상: 0
        System.out.println(vc.compareVersion("0.1", "1.1"));      // 예상: -1
    }
}