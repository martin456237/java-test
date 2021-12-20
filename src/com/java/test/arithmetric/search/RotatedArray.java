package com.java.test.arithmetric.search;

/**
 * 旋转有序数组，二分查找 [5,4,3,0,1,2]
 */
public class RotatedArray {
  public static void main(String[] args) {
	int[] numbers = {9,34,56,57,1,5,7,8};
	int targetIndex = new RotatedArray().getTargetIndex(numbers, 1);
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
	  if (numbers[mid] > numbers[start]) {
		if (numbers[mid] >= target && target >= numbers[start]) {
		  end = mid;
		} else {
		  start = mid;
		}
	  } else {
		if (numbers[mid] <= target && numbers[end] >= target) {
		  start = mid;
		} else {
		  end = mid;
		}
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
