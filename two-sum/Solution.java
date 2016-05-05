import java.util.*;

public class Solution
{
    public int[] twoSum(int[] numbers, int target) {
	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	for (int i = 0; i < numbers.length; i++) {
	    m.put(numbers[i], i);
	}

	for (int i = 0; i < numbers.length; i++) {
	    Integer j = m.get((target-numbers[i]));
	    if (j != null && j != i) {
		return (new int[] {i, j});
	    }
	}
	
	throw new RuntimeException();
    }

    public static void main(String[] args) {
	int[] numbers = {1, 2, 5, 7};
	int target = 12;
	int[] result = new Solution().twoSum(numbers, target);
	for(int i: result) {
	    System.out.println(i);
	}
    }
}
