


/*
// 53. Maximum Subarray - using kadane's algorithm - O(n) t.c

public class Ques3 {
    public static int maxSubArray(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            ans = Math.max(ans, sum);
            if(sum <= ans && sum <= 0) sum = 0;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSum = maxSubArray(nums);

        System.out.println("maxSum: " + maxSum);
    }
}
*/

// using divide and conquer

public class Ques3 {
    public static int findAns(int[] nums, int start, int end) {
        // System.out.println("start: " + start + " end: " + end);
        if(start >= end) return nums[start];

        int mid = start + ((end-start) >> 1);
        int prevMax = Integer.MIN_VALUE;
        prevMax = Math.max(findAns(nums, start, mid), findAns(nums, mid+1, end));
        int midLeftMax = Integer.MIN_VALUE, sum = 0;
        for(int i = mid; i >= 0; i--) {
            sum += nums[i];
            midLeftMax = Math.max(midLeftMax, sum);
        }
        int midRightMax = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1; i <= end; i++) {
            sum += nums[i];
            midRightMax = Math.max(midRightMax, sum);
        }

        int wholeValue = midLeftMax + midRightMax;
        // System.out.println("prevMax: " + prevMax + " wholeValue: " + wholeValue);

        return Math.max(prevMax, wholeValue);
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSum = findAns(nums, 0, nums.length-1);

        System.out.println("maxSum: " + maxSum);
    }
}