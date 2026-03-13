package hand_coding;

import java.util.*;

public class FileRename {
    public String getUniqueName(String[] existingFiles, String newFile) {
        Queue<String> queue = new LinkedList<>();
        queue.add(newFile);

        int count = 1;
        // 파일명과 확장자를 분리하는 로직이 필요할 수 있습니다 (예: test .pdf)
        String nameOnly = newFile.substring(0, newFile.lastIndexOf("."));
        String ext = newFile.substring(newFile.lastIndexOf("."));

        while (!queue.isEmpty()) {
            String current = queue.poll();
            boolean isDuplicate = false;

            for (String file : existingFiles) {
                if (file.equals(current)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                queue.offer(nameOnly + "(" + count++ + ")" + ext);
            } else {
                return current;
            }
        }
        return "";
    }
}