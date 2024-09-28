import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> result = new ArrayList<>();

        // no overlaps before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // overlap of the new interval - merging
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // no overlaps after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = ii.insert(new int[][] {{3, 4}, {6, 7}}, new int[] {2, 8});
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(Arrays.stream(intervals[i]).toArray()));
        }
    }
}
