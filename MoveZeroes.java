import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * LeetCode 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {


    /**
     * Given an integer array nums, move all 0's to the end of it 
     * while maintaining the relative order` of the non-zero elements.
     * 
     * 74 / 74 test cases passed.
     * Status: Accepted
     * Runtime: 32 ms
     * Memory Usage: 40 MB
     * 
     * Runtime: O(n) - Space: O(1)
     */
    public static void moveZeroes0(int[] nums) {

        // **** sanity check(s) ****
        // if (nums.length == 1) return;

        // **** initialization ****
        int z   = 0;
        int n   = 0;

        // **** loop until last entry - O(n) ****
        while (n <= nums.length || z <= nums.length) {

            // **** look for the next zero - O(n) ****
            while (z < nums.length && nums[z] != 0) z++;

            // **** check if we are out of zeroes ****
            if (z >= nums.length) return;

            // ???? ????
            System.out.println("<<< z: " + z + " nums[" + z + "]: " + nums[z]);

            // **** look for the next non-zero - O(n) ****
            for (n = z + 1; n < nums.length && nums[n] == 0; ) n++;

            // **** check if we are out of non-zeroes ****
            if (n >= nums.length) return;

            // ???? ????
            System.out.println("<<< n: " + n + " nums[" + n + "]: " + nums[n]);

            // **** swap zero and non-zero values ****
            // int tmp = nums[z];
            // nums[z] = nums[n];
            // nums[n] = tmp;
            swap(nums, z, n);

            // ???? ????
            System.out.println("<<< n: " + n + " z: " + z + " nums: " + Arrays.toString(nums));
        }  
    }


    /**
     * Given an integer array nums, move all 0's to the end of it 
     * while maintaining the relative order` of the non-zero elements.
     * 
     * Runtime: O(n) - Space: O(n)
     * 
     * 74 / 74 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 40.6 MB
     */
    public static void moveZeroes1(int[] nums) {

        // **** initialization ****
        int len         = nums.length;
        int zeroCount   = 0;
        int[] arr       = new int[len];

        // **** count zero values ****
        for (int i = 0; i < len; i++)
            if (nums[i] == 0) zeroCount++;

        // ???? ????
        System.out.println("<<< zeroCount: " + zeroCount);

        // **** copy non-zero values - O(n) ****
        for (int i = 0, j = 0; i < len; i++) {
            if (nums[i] != 0) {
                arr[j++] = nums[i];
            }
        }

        // ???? ????
        System.out.println("<<< arr: " + Arrays.toString(arr));

        // **** copy values in order - O(n) ****
        for (int i = 0; i < len; i++)
            nums[i] = arr[i];
    }


    /**
     * Given an integer array nums, move all 0's to the end of it 
     * while maintaining the relative order` of the non-zero elements.
     * 
     * Runtime: O(n) - Space: O(1)
     * 
     * 74 / 74 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 40 MB
     */
    public static void moveZeroes2(int[] nums) {

        // **** initialization ****
        int lastNonZeroNdx  = 0;
        int len             = nums.length;

        // **** move non-zero values left - O(n) ****
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0)
                nums[lastNonZeroNdx++] = nums[i];
        }

        // ???? ????
        System.out.println("<<< nums: " + Arrays.toString(nums));

        // **** set to zero values to right of last non-zero entry - O(n) ****
        for (int i = lastNonZeroNdx; i < len; i++)
            nums[i] = 0;
    }


    /**
     * Given an integer array nums, move all 0's to the end of it 
     * while maintaining the relative order` of the non-zero elements.
     * 
     * 74 / 74 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 40.4 MB
     * 
     * Runtime: O(n) - Space: O(1)
     */
    public static void moveZeroes3(int[] nums) {

        // **** traverse nums array - O(n) ****
        for (int lastNonZeroNdx = 0, i = 0; i < nums.length; i++) {

            // **** swap non-zero element with zero ****
            if (nums[i] != 0) {
                swap(nums, i, lastNonZeroNdx++);

                // ???? ????
                System.out.println("<<< nums: " + Arrays.toString(nums));
            }
        }
    }


    /**
     * Auxiliary function.
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * Given an integer array nums, move all 0's to the end of it 
     * while maintaining the relative order` of the non-zero elements.
     * 
     * 74 / 74 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 40.6 MB
     * 
     * Runtime: O(n) - Space: O(1)
     */
    public static void moveZeroes(int[] nums) {

        // **** initialization ****
        int f   = 0;
        int s   = 0;
        int len = nums.length;

        // **** traverse the array - O(n) ****
        while (f < len) {

            // **** skip zero value ****
            if (nums[f] == 0) {
                f++;
            } 
            
            // **** swap non-zero values ****
            else {
                swap(nums, s++, f++);

                // ???? ????
                System.out.println("<<< nums: " + Arrays.toString(nums)); 
            }          
        }
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read nums int[] ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));

        // **** call function of interest ****
        // moveZeroes0(nums);
        // moveZeroes1(nums);
        // moveZeroes2(nums);
        // moveZeroes3(nums);
        moveZeroes(nums);

        // **** display output ****
        System.out.println("main <<< output: " + Arrays.toString(nums));
    }
     
}