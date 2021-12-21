package com.java.test.arithmetric.search;

/**
 * 找到一个峰值元素
 */
public class FindPeakElement {
  public int findPeakElementIndex(int[] nums) {
	if (null == nums || nums.length == 0) {
	  return -1;
	}
	int start = 0;
	int end = nums.length - 1;
	int mid;
	while (start + 1 < end) {
	  mid = start + (end - start) / 2;
	  // 降序
	  if (nums[mid] < nums[mid -1]) {
		end = mid;
	  } else if (nums[mid] < nums[mid + 1]) {
		start = mid;
	  } else {
		return mid;
	  }
	}
	return nums[end] > nums[start] ? end : start;
  }
}
