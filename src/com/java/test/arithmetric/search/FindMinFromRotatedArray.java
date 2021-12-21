package com.java.test.arithmetric.search;

/**
 * 从旋转有序数组中找到最小值， [4,5,6,0,1,2] ==>  0
 */
public class FindMinFromRotatedArray {
  public static void main(String[] args) {
	int[] numbers = {9,34,56,57,1,5,7,8};
	int min = new FindMinFromRotatedArray().getMin(numbers);
	System.out.println(min);
  }
  public int getMin(int[] numbers) {
	int start = 0;
	int end = numbers.length - 1;
	int mid;
	while (start + 1 < end) {
	  mid = start + (end - start) / 2;
	  if (numbers[mid] >= numbers[start]) {
			if (numbers[mid] >= numbers[end]) {
			  start = mid;
			} else {
			  end = mid;
			}
	  } else {
		end = mid;
	  }
	}
	return Math.min(numbers[start], numbers[end]);
  }
}
