package Adventure.Map;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        AdventureGame game = new AdventureGame();
        game.play("road");
//        sortColors(new int[]{7, 7, 66, 56, 65, 87});
    }


    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        System.out.println("Initial array length: " + nums.length);
        System.out.println("Initial array: " + Arrays.toString(nums));

        while (mid <= high) {

            System.out.println("Before step -> low: " + low + ", mid: " + mid + ", high: " + high + ", array: " + Arrays.toString(nums));

            if (nums[mid] == 0) {
                System.out.println("Swapping 0 from mid=" + mid + " to low=" + low);
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                System.out.println("Found 1 at mid= " + mid + ", just moving mid");
                mid++;
            } else {
                System.out.println("Swapping 2 from mid= " + mid + " to high= " + high);
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }

            System.out.println("After step -> low: " + low + ", mid: " + mid + ", high: " + high + ", array: " + Arrays.toString(nums));
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Final sorted array: " + Arrays.toString(nums));
    }

}



