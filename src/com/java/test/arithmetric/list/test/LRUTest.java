package com.java.test.arithmetric.list.test;

import com.java.test.arithmetric.list.LRU;
import org.junit.Test;

public class LRUTest {
  @Test
  public void lruTest() {
	LRU<Integer, String> lru = new LRU<>(5);
	lru.put(1, "1");
	lru.put(2, "2");
	lru.put(3, "3");
	lru.put(2, "2a");
	lru.put(3, "3a");
	lru.put(4, "4");
	lru.put(1, "1a");
	String s = lru.get(3);
	System.out.println(s);
  }
}
