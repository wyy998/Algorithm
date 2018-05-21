public class MergeSort {
    private static void merge(int[] nums, int left, int right, int[] temp) {
        int mid = (left+right)/2;
        int posT = 0;
        int i = left, j = mid+1;
        while(i<=mid && j<=right) {
            if(nums[i] <= nums[j]) {
                temp[posT++] = nums[i++];
            } else {
                temp[posT++] = nums[j++];
            }
        }
        while(i<=mid) {
            temp[posT++] = nums[i++];
        }
        while(j<=right) {
            temp[posT++] = nums[j++];
        }
        for(int t=0; t<posT; t++) {
            nums[left+t] = temp[t];
        }
    }

    private static void divide(int[] nums, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left+right)/2;
            divide(nums, left, mid, temp);
            divide(nums, mid+1, right, temp);
            merge(nums, left, right, temp);
        }
    }

    public static void sort(int[] nums) {
        int[] temp = new int[nums.length];
        divide(nums, 0, nums.length-1, temp);
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
