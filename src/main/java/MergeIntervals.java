import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{11, 14}, {1,3},{2,6},{8,10},{15,18}};
        int[][] merged = MergeIntervals.merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        // sort the interval by their left value
        sort(intervals, 0, intervals.length - 1);
        // merge overlapping intervals
        int idx = mergeSorted(intervals);
        if (idx > 0) {
            intervals = Arrays.copyOfRange(intervals, idx - 1, intervals.length);
        }
        return intervals;
    }

    private static void sort(int[][] intervals, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(intervals, left, mid);
            sort(intervals, mid + 1, right);
            merge(intervals, left, mid, right);
        }
    }

    private static void merge(int[][] intervals, int left, int mid, int right) {
        int[][] L = new int[mid - left + 1][];
        int[][] R = new int[right - mid][];

        for (int i = 0; i < L.length; i++) {
            L[i] = new int[2];
            L[i][0] = intervals[left + i][0];
            L[i][1] = intervals[left + i][1];
        }

        for (int j = 0; j < R.length; j++) {
            R[j] = new int[2];
            R[j][0] = intervals[mid + j + 1][0];
            R[j][1] = intervals[mid + j + 1][1];
        }

        int i = 0, j = 0, k = left;
        while (i < mid - left + 1 && j < right - mid) {
            if (L[i][0] < R[j][0]) {
                intervals[k][0] = L[i][0];
                intervals[k++][1] = L[i++][1];
            } else if (L[i][0] > R[j][0]) {
                intervals[k][0] = R[j][0];
                intervals[k++][0] = R[j++][0];
            } else { // if the same start - merge them
                if (L[i][1] < R[j][1]) {
                    intervals[k][0] = R[j][0];
                    intervals[k++][1] = R[j++][1];
                    i++;
                } else {
                    intervals[k][0] = L[i][0];
                    intervals[k++][1] = L[i++][1];
                    j++;
                }
            }
        }

        while (i < mid - left + 1) {
            intervals[k][0] = L[i][0];
            intervals[k++][1] = L[i++][1];
        }

        while (j < right - mid) {
            intervals[k][0] = R[j][0];
            intervals[k++][0] = R[j++][0];
        }
    }

    private static int mergeSorted(int[][] intervals) {
            int i = 0, j = 1;
            while (i < intervals.length && j < intervals.length) {
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = intervals[i][0];
                    //intervals[j][1] = intervals[j][1];
                    //intervals[i] = null;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        return i;
    }
}
