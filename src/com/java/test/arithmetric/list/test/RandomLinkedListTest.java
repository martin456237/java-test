package com.java.test.arithmetric.list.test;

import com.java.test.arithmetric.list.LinkedListWithRandom;
import org.junit.Test;

public class RandomLinkedListTest {
  @Test
  public void randomTest() {
	LinkedListWithRandom<String> list = new LinkedListWithRandom<>();
	list.offer("1");
	list.offer("2");
	list.offer("3");
	list.offer("4");
	list.offer("5");
	list.random(0, 2);
	list.random(3, 1);
	System.out.println(list);
	System.out.println(list);
  }

  @Test
  public void depCopyTest() {
	LinkedListWithRandom<String> list = new LinkedListWithRandom<>();
	list.offer("1");
	list.offer("2");
	list.offer("3");
	list.offer("4");
	list.offer("5");
	list.random(0, 2);
	list.random(3, 1);
	System.out.println(list);
	LinkedListWithRandom<String> co = list.depCopy();
	System.out.println(co);
  }

  @Test
  public void depCopyNoMapTest() {
	LinkedListWithRandom<String> list = new LinkedListWithRandom<>();
	list.offer("1");
	list.offer("2");
	list.offer("3");
	list.offer("4");
	list.offer("5");
	list.random(0, 2);
	list.random(3, 1);
	System.out.println(list);
	LinkedListWithRandom<String> co = list.depCopyNoMap();
	System.out.println(co);
  }
}
