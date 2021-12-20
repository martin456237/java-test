package com.java.test.arithmetric.search;

/**
 * 二分法查找模板
 */
public class TwoSplitTemplate {
  public static void main(String[] args) {
	int[] numbers = {1,4,5,8,9,34,56,57};
	int targetIndex = new TwoSplitTemplate().getTargetIndex(numbers, 1);
	System.out.println(targetIndex);
  }
  public int getTargetIndex(int[] numbers, int target) {
	if (null == numbers || numbers.length == 0) {
	  return -1;
	} else if (numbers[0] == target) {
	  return 0;
	} else if (numbers[numbers.length - 1] == target) {
	  return numbers.length - 1;
	}

	int start = 0;
	int end = numbers.length - 1;
	while (start + 1 < end) {
	  int mid = start + (end - start) / 2;
	  if (numbers[mid] == target) {
		return mid;
	  }
	  if (numbers[mid] < target) {
		start = mid;
	  } else {
		end = mid;
	  }
	}
	if (numbers[start] == target) {
	  return start;
	}
	if (numbers[end] == target) {
	  return end;
	}
	return -1;
  }
}
