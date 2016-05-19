public class Solution {
    public int lengthOfLongestSubstring(String s) {
	Set<Character> charSet = new HashSet<>();
	int length = s.length();
	
	int result = 0;
	int i = 0;
	int j = 0;
	while(i < length && j < length) {
	    if (!charSet.contains(s.charAt(j))) {
		charSet.add(s.charAt(j));
		j++;
		result = Math.max(result, j - i);
	    }
	    else {
		charSet.remove(s.charAt(i));
		i++;
	    }
	}

	return result;
    }
}
