import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        int[][] answer = kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2);
        System.out.println(answer[0][0] + ", " + answer[0][1]);
        System.out.println(answer[1][0] + ", " + answer[1][1]);
    }

    public static int[][] kClosest(int[][] points, int k) {
        // 0th - squared distance, 1st - index in points
        // so we need an elements with smaller 0th value
        Queue<int[]> maxPQ = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < points.length; i++) {
            int squaredDistance = sqrdDist(points[i]);
            int[] entry = { squaredDistance, i };
            if (maxPQ.size() < k) {
                maxPQ.offer(entry);
            } else if (squaredDistance < maxPQ.peek()[0]) {
                // if the currently calculated distance is smaller
                // than the head of the queue, i.e. the smallest distance in the queue
                // then we need to add this distance instead
                maxPQ.poll();
                maxPQ.offer(entry);
            }
        }

        int[][] output = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = maxPQ.poll()[1];
            output[i] = points[index];
        }

        return output;
    }

    private static int sqrdDist(int[] point) {
        if (point.length != 2) {
            return 0;
        }
        return point[0] * point[0] + point[1] * point[1];
    }
}
