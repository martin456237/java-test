package com.java.test.arithmetric.stack;


import org.junit.Test;

import java.util.Stack;

/**
 * 任意区间最大值计算： max = Math.max(max,任意区间的最小值 * 区间和)
 */
public class MaxRange {
  @Test
  public void getMaxTest() {
	System.out.println(getMaxRange(new int[] {5,2,3,4,1}));
  }

  private int getMaxRange(int[] numbers) {
	int max = 0;
	if (numbers == null || numbers.length == 0) {
	  return 0;
	}

	Stack<Integer> stack = new Stack<>();
	// 求前缀和数组
	int[] sums = new int[numbers.length + 1];
	for (int i = 1; i <= numbers.length; i++) {
	  sums[i] = sums[i - 1] + numbers[i - 1];
	}

	for(int i = 0; i < numbers.length; i++) {
	  //  保证stack 中最底层存贮的永远是区间最小值
	  while(!stack.isEmpty() && numbers[i] < numbers[stack.peek()]) {
		Integer index = stack.pop();
		int left = i;
		int right = i;
		if (stack.isEmpty()) {
		  left = 0;
		} else {
		  left = index;
		}
		max = Math.max(max, numbers[index] * (sums[right] - sums[left]));
	  }
	  stack.push(i);
	}

	while (!stack.isEmpty()) {
	  int index  = stack.pop();
	  int left = numbers.length;
	  int right = numbers.length;
	  if (stack.isEmpty()) {
		left = 0;
	  } else {
		left = index;
	  }
	  max = Math.max(max, numbers[index] * (sums[right] - sums[left]));
	}
	return  max;
  }
}
