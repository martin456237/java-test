package com.java.test.arithmetric.search;

/**
 * 切木头
 */
public class WoodCut {
  public int woodCut(int[] L, int k) {
	if (null == L || L.length == 0) {
	  return 0;
	}
	int start = 1;
	int end = getMax(L);
	while (start + 1 < end) {
	  int mid = start + (end - start) / 2;
	  int pieces = getPieces(L, mid);
	  if (pieces >= k) {
		start = mid;
	  } else {
		end = mid;
	  }
	}

	if (getPieces(L, start) >= k) {
	  return start;
	}
	if (getPieces(L, end) >= k) {
	  return  end;
	}
	return 0;
  }

  private int getMax(int[] l) {
	int max = 0;
	for(int i = 0; i < l.length; i++) {
	  if (l[i] > max) {
		max = l[i];
	  }
	}
	return max;
  }
  private int getPieces(int[] l, int maxLength) {
	int pieces = 0;
	for(int mood: l) {
	  pieces += mood / maxLength;
	}
	return pieces;
  }
}
