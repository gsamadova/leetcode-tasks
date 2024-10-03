public class RemoveDuplicates {

    // easy task
    public int removeDup(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        int insertIdx = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIdx++] + nums[i];
            }
        }
        return insertIdx;
    }

    // medium task
    public int removeDup2(int[] nums) {
        int len = nums.length;
        if (len < 3) return len;

        boolean repeated = false;
        int insertIdx = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == nums[i] && !repeated) {
                repeated = true;
                nums[insertIdx++] = nums[i];
            }
            if (nums[i - 1] < nums[i]) {
                repeated = false;
                nums[insertIdx++] = nums[i];
            }
        }

        return insertIdx;
    }
}