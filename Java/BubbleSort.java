/**
 * BubbleSort
 * 
 * @author wyy998
 * @version 0.0.1
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        boolean isOrder = false;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            isOrder = true;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    isOrder = false;
                }
            }
            if (isOrder) {
                break;
            }
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