/**
 * InsertSort
 * 
 * @author wyy998
 * @version 0.0.1
 */
public class InsertSort {
    public static void sort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] test = { 5, 4, 6, 3, 7, 1, 2 };
        for (int i : test) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(test);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }
}