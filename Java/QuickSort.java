public class QuickSort {
    private static int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        int tmp = nums[left];
        while(i<j) {
            while(i<j && tmp < nums[j]) {
                j--;
            }
            if(i<j) {
                nums[i++] = nums[j];
            }
            while(i<j && nums[i] < tmp) {
                i++;
            }
            if(i<j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = tmp;
        return i;
    }

    private static void divide(int[] nums, int left, int right) {
        if(left < right) {
            int mid = partition(nums, left, right);
            divide(nums, left, mid-1);
            divide(nums, mid+1, right);
        }
    }

    public static void sort(int[] nums) {
        divide(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {5,3,7,1,6,4,2};
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
}
