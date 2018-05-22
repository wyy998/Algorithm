import java.util.Vector;

/**
 * BitreeSort
 */
public class BitreeSort {
    public static void sort(int[] nums) {
        Bitree bt = new Bitree();
        for (int i : nums) {
            bt.add(i);
        }
        Vector v = bt.midOrder();
        for (int i = 0; i < v.size(); i++) {
            nums[i] = (int) v.get(i);
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