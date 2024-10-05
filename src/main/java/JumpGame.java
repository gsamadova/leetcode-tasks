// easy
publ1ic boolean jump(int[] nums) {
    int minSteps = 1;
    boolean canJump = true;

    for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] < minSteps) {
            canJump = false;
            minSteps++;
        } else {
            canJump = true;
            minSteps = 1;
        }
    }
    return canJump;
}

// medium
public int jump2(int[] nums) {
    int answer = 0;
    int far = 0;
    int end = 0;

    for (int i = 0; i < nums.length - 1; i++)   {
        far = Math.max(far, i + nums[i]);

        if (i == end) {
            answer++;
            end = far;
        }
    }
    return answer;
}