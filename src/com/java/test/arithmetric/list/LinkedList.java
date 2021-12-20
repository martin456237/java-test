package com.java.test.arithmetric.list;

public class LinkedList<T> {
  protected long count;
  protected ListNode<T> head;
  protected ListNode<T> end;
  public LinkedList() {
  }


  /**
   * 深度拷贝
   *
   * @return
   */
  public LinkedList<T> depCopy() {
	if (head == null) {
	  return null;
	}
	LinkedList<T> copyList = new LinkedList<>();
	ListNode<T> node = head;
	while (node != null) {
	  copyList.offer(node.data);
	  node = node.next;
	}
	return copyList;
  }
  /**
   * 在链表末尾添加元素
   * @param item
   * @return
   */
  public boolean offer(T item) {
	if (head == null) {
	  head = new ListNode<T>(item);
	  end = head;
	} else {
	  ListNode<T> node = new ListNode<T>(item);
	  end.next = node;
	  end = node;

	}
	count ++;
	return true;
  }


  /**
   * 在队列的头部添加元素
   *
   * @param t
   */
  public void push(T t) {
	if (head == null) {
	  head = new ListNode<>(t);
	  end = head;
	} else {
	  ListNode curr = new ListNode(t);
	  curr.next = head;
	  head = curr;
	}
	count ++;
  }

  /**
   * 删除某个元素
   *
   * @param index
   */
  public LinkedList<T> delete(long index) {
	if (head != null) {
	  if (index == 0) { // index == 0,说明删除头部元素
		ListNode<T> curr = head;
		head = curr.next;
		curr.next = null;
	  } else {
		// 找到index 之前的元素
		ListNode<T> pre = getForNode(index - 1);
		// 要删除的元素
		ListNode<T> curr = pre.next;
		//  要删除元素之后的元素
		ListNode<T> next = curr.next;
		pre.next = next;
		curr.next = null;
	  }
	  count --;
	}

	return this;
  }
  /**
   * 在链表的给定位置插入一个元素
   * @param index
   * @param t
   */
  public void add(long index, T t) {
	if (index < 0) {
	  throw new IllegalArgumentException("index is illegal");
	}
	if (head == null || index >= count) {
	  offer(t);
	} else if (index == 0) {
	  push(t);
	} else {
	  //  找到index之前的元素
	  ListNode<T> pre = getForNode(index - 1);
	  // 找到index 之后的元素
	  ListNode<T> next = pre.next;
	  ListNode<T> curr = new ListNode<>(t);
	  pre.next = curr;
	  curr.next = next;
	  count ++;
	}
  }

  public long size() {
	return count;
  }


  /**
   * 查询指定索引位置的元素
   *
   * @param index
   * @return
   */
  protected ListNode<T> getForNode(long index) {
	if (index < 0) {
	  throw new IllegalArgumentException("index is illegal");
	} else if(head == null) {
	  return null;
	}
	else if (index > count -1) {
	  throw new IllegalArgumentException("outside");
	} else {
	  long i = 0;
	  ListNode<T> curr = head;
	  ListNode<T> next = curr.next;
	  while (i < index  && next != null) {
		i++;
		curr = next;
		next = next.next;

	  }
	  return curr;
	}
  }

  /**
   * 查询指定索引位置的元素
   *
   * @param index
   * @return
   */
  public T get(long index) {

	ListNode<T> curr = getForNode(index);
	if (curr == null) {
	  return null;
	}
	return curr.data;

  }


  /**
   * 翻转列表
   *
   * @return
   */
  public LinkedList<T> reverse() {
	if (head == null) {
	  return this;
	}
	if (head == end) {
	  return this;
	}
	end = head;
	ListNode<T> curr = head;
	ListNode<T> next = curr.next;
	curr.next = null;
	while (next != null) {
	  ListNode<T> tmp = next.next;
	  next.next = curr;
	  curr = next;
	  next = tmp;
	}
	//  调换head 和 end
	head = curr;
	return this;
  }

  /**
   * 翻转列表
   *
   * @return
   */
  public LinkedList<T> reverse(long startIndex, long endIndex) {
	if (head == null) {
	  return this;
	}
	if (head == end) {
	  return this;
	}

	if (startIndex >= endIndex) {
	  return this;
	}

	if (startIndex < 0 || endIndex < 0) {
	  throw new IllegalArgumentException("index is illegal");
	}

	if (startIndex > count - 1 || endIndex > count - 1) {
	  throw new IllegalArgumentException("outside");
	}

	// 找到startIndex 位置的前一个元素
	ListNode<T> pre = null;
	if (startIndex > 0) { // 不是从头开始翻转
	  pre = getForNode(startIndex - 1);
	}

	// 找到startIndex 位置的元素
	ListNode<T> curr = null;
	if (pre != null) { // 不是从头开始的翻转
	  curr = pre.next;
	} else {
	  curr = getForNode(startIndex);
	}
	if (endIndex == count -1) {
	  end = curr;
	}
	ListNode<T> next = curr.next;
	curr.next = null;
	long s = startIndex;
	while (s < endIndex && next != null) {
	  ListNode<T> tmp = next.next;
	  next.next = curr;
	  curr = next;
	  next = tmp;
	  s++;
	}

	if (pre != null) { // 不是从头开始的翻转
	  pre.next.next = next;
	  pre.next = curr;
	} else { //  从头开始的翻转
	  head.next = next;
	  head = curr;
	}
	return this;
  }

  @Override
  public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("[");
	if (head != null) {
	  stringBuilder.append(head.data.toString());


	  ListNode next = head.next;
	  while (next != null) {
		stringBuilder.append(",");
		stringBuilder.append(next.data.toString());
		next = next.next;
	  }
	  stringBuilder.append("]");
	  return stringBuilder.toString();
	}
	return "[]";
  }

  private static class ListNode<T> {
	protected T data;
	protected ListNode<T> next;
	public ListNode(T item) {
	  this.data = item;
	}
  }

  private void offer(ListNode<T> node) {
	if (head == null) {
	  head = node;
	  end = head;
	} else {
	  end.next = node;
	  end = node;

	}
	count ++;
  }

  /**
   * 整数列表相加
   *
   * @param l1
   * @param l2
   * @return
   */
  public  static  LinkedList<Integer> add(LinkedList<Integer> l1, LinkedList<Integer> l2) {
	if (l1 == null) {
	  return l1;
	}
	if (l1 == null) {
	  return l2;
	}
	LinkedList<Integer> rs = new LinkedList<>();
	LinkedList.ListNode<Integer> node1 = l1.getForNode(0);
	LinkedList.ListNode<Integer> node2 = l2.getForNode(0);
	// 进位
	int carry = 0;
	while (node1 != null && node2 != null) {
	  Integer data1 = node1.data;
	  Integer data2 = node2.data;
	  int number = data1 + data2 + carry;
	  carry = number / 10;
	  LinkedList.ListNode<Integer> newNode = new LinkedList.ListNode(number % 10);
	  rs.offer(newNode);
	  node1 = node1.next;
	  node2 = node2.next;
	}

	while (node1 != null) {
	  Integer data1 = node1.data;
	  int number = data1 + carry;
	  carry = number / 10;
	  LinkedList.ListNode<Integer> newNode = new LinkedList.ListNode(number % 10);
	  rs.offer(newNode);
	  node1 = node1.next;
	}

	while (node2 != null) {
	  Integer data2 = node2.data;
	  int number = data2 + carry;
	  carry = number / 10;
	  LinkedList.ListNode<Integer> newNode = new LinkedList.ListNode(number % 10);
	  rs.offer(newNode);
	  node2 = node2.next;
	}

	if (carry != 0) {
	  LinkedList.ListNode<Integer> newNode = new LinkedList.ListNode(carry);
	  rs.offer(newNode);
	}
	return rs;
  }
}

