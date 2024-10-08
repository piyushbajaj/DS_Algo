package TakeUForward.CompleteCourse_456.S3_Arrays.S3_3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 28/02/23
 * Time: 10:43 pm
 */
public class P3_Three_Sum {

    public static void main(String[] args) {
        P3_Three_Sum p3_three_sum = new P3_Three_Sum();
        System.out.println(p3_three_sum.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(p3_three_sum.threeSum(new int[] {0, 1, 1}));
        System.out.println(p3_three_sum.threeSum(new int[] {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }

    /**
     * Using two pointer approach
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if (nums[0] > 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = n - 1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum < 0) {
                        low++;
                    } else if (sum > 0) {
                        high--;
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    }
                }
            }
        }

        return result;
    }
}
