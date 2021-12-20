package com.java.test.arithmetric.list.test;


import com.java.test.arithmetric.list.LinkedList;
import org.junit.Test;

public class LinkedListTest {
  @Test
  public void offTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.offer("1");
    linkedList.offer("2");
    linkedList.offer("3");
    linkedList.offer("4");
    linkedList.offer("5");
    System.out.println(linkedList);
  }

  @Test
  public void sizeTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.offer("1");
    linkedList.offer("2");
    linkedList.offer("3");
    linkedList.offer("4");
    linkedList.offer("5");
    System.out.println(linkedList.size());
  }

  @Test
  public void addTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add(1,"1");
    linkedList.add( 1,"2");
    linkedList.add(1,"3");
    linkedList.add(1,"4");
    linkedList.add(1,"5");
    linkedList.add(0,"7");
    System.out.println("size:" + linkedList.size());
    System.out.println(linkedList);
  }

  @Test
  public void getTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add(1,"1");
    linkedList.add( 1,"2");
    linkedList.add(1,"3");
    linkedList.add(1,"4");
    linkedList.add(1,"5");
    linkedList.add(3,"7");
    System.out.println("size:" + linkedList.size());
    System.out.println(linkedList);
    System.out.println(linkedList.get(5));
  }

  @Test
  public void deleteTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add(1,"1");
    linkedList.add( 1,"2");
    linkedList.add(1,"3");
    linkedList.add(1,"4");
    linkedList.add(1,"5");
    linkedList.add(3,"7");
    System.out.println("size:" + linkedList.size());
    System.out.println(linkedList);
    System.out.println(linkedList.delete(7));
  }

  @Test
  public void reverseTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add(1,"1");
    linkedList.add( 1,"2");
    linkedList.add(1,"3");
    linkedList.add(1,"4");
    linkedList.add(1,"5");
    linkedList.add(3,"7");
    System.out.println("size:" + linkedList.size());
    System.out.println(linkedList);
    System.out.println(linkedList.reverse());
  }

  @Test
  public void reverseTestM() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add(1,"1");
    linkedList.add( 1,"2");
    linkedList.add(1,"3");
    linkedList.add(1,"4");
    linkedList.add(1,"5");
    linkedList.add(3,"7");
    System.out.println("size:" + linkedList.size());
    System.out.println(linkedList);
    System.out.println(linkedList.reverse(4,5));
  }


  @Test
  public void depCopyTest() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add(1,"1");
    linkedList.add( 1,"2");
    linkedList.add(1,"3");
    linkedList.add(1,"4");
    linkedList.add(1,"5");
    linkedList.add(3,"7");
    System.out.println("size:" + linkedList.size());
    System.out.println(linkedList);
    LinkedList<String> c = linkedList.depCopy();
    c.offer("88");
    System.out.println(linkedList);
    System.out.println(c);
  }

  @Test
  public void addListTest() {
    LinkedList<Integer> l1 = new LinkedList<>();
    l1.offer(3);
    l1.offer(3);
    l1.offer(5);

    LinkedList<Integer> l2 = new LinkedList<>();
    l2.offer(23);
    l2.offer(1);
    l2.offer(9);

    LinkedList<Integer> add = LinkedList.add(l1, l2);
    System.out.println(add);
  }
}
