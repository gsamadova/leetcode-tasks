import java.util.*;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;

        for (int i = citations.length - 1; i >= 0; i--) {
            if (h < citations[i]) {
                h++;
            } else {
                break;
            }
        }

        return h;
    }
}