public class MaxSubArray {

    public int maxSubArray (int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int maxElem = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            maxElem = Math.max(maxElem, nums[i]);
        }

        if (maxSoFar == 0) {
            maxSoFar = maxElem;
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        System.out.println(msa.maxSubArray(new int[] {-10, -4, -5, -3, -5, -6, -4}));
    }
}
