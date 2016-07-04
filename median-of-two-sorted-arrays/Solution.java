import java.util.*;

public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
	int m = A.length;
	int n = B.length;
	if(m == 0) {
	    return getMedian(B);
	}
	if (n == 0) {
	    return getMedian(A);
	}
	if (m > n) {
	    return findMedianSortedArrays(B, A);
	}

	int i;
	int j;
	int maxLeft;
	int minRight;
	double result;
	int iMin = 0;
	int iMax = m;
	while (iMin <= iMax) {
	    i = (iMin + iMax) / 2;
	    j = (m + n + 1) / 2 - i;

	    if (j > 0 && i < m && B[j-1] > A[i]) {
		iMin = i + 1;
	    }
	    else if (i > 0 && j < n && A[i-1] > B[j]) {
		iMax = i - 1;
	    }
	    
	    else {
		if (i == 0) {
		    maxLeft = B[j-1];
		}
		else if (j == 0) {
		    maxLeft = A[i-1];
		}
		else {
		    maxLeft = Math.max(A[i-1], B[j-1]);
		}
		if ((m+n) % 2 == 1) {
		    return maxLeft;
		}
		if (i == m) {
		    minRight = B[j];
		}
		else if (j == n) {
		    minRight = A[i];
		}
		else {
		    minRight = Math.min(A[i], B[j]);
		}

		return result = (maxLeft + minRight) / 2.0;

	    }
	}
	return 0.00;
    }

    public double getMedian(int[] A) {
	int m = A.length;
	double median = ((A[(m + 1) / 2 - 1]) + (A[(m + 2) / 2 - 1])) / 2.0;
	return median;
    }

    public static void main(String[] args) {
	int[] arrA = {1};
	int[] arrB = {1};
	int[] arrC = {1, 2};
	int[] arrD = {3, 4};
	Solution s = new Solution();
	double ret = s.findMedianSortedArrays(arrA, arrB);
	double ret2 = s.findMedianSortedArrays(arrC, arrD);
	System.out.println(ret);
	System.out.println(ret2);
    }
}

