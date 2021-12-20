package com.java.test.arithmetric.list;

import java.util.HashMap;
import java.util.Map;

public class LinkedListWithRandom<T>  {
  protected long count;
  protected RandomNode<T> head;
  protected RandomNode<T> end;


  public LinkedListWithRandom<T> depCopyNoMap() {
	if (head == null) {
	  return null;
	}
	LinkedListWithRandom<T> copyList = new LinkedListWithRandom<>();
	RandomNode<T> node = head;
	// 将新的node 插入到 源node 之间
	while (node != null) {
	  RandomNode<T> copyNode = new RandomNode<>(node.data);
	  copyNode.next = node.next;
	  node.next = copyNode;
	  node = copyNode.next;
	}
	// copy randome
	node = head;
	while (node != null && node.next != null) {
	  if (node.random != null) {
		RandomNode<T> random = node.random;
		node.next.random = random.next;
	  }
	  node = node.next.next;
	}

	// split
	node = head;
	RandomNode<T> move = node.next;
	while (node != null && node.next != null && move != null) {
	  node.next = node.next.next;
	  node = node.next;
	  move.next = null;
	  copyList.offer(move);
	 // move.next = node.next.next;
	  if (node != null) {
		  move = node.next;
	  }
	}
	return copyList;
  }

  public LinkedListWithRandom<T> depCopy() {
	if (head == null) {
	  return null;
	}
	LinkedListWithRandom<T> copyList = new LinkedListWithRandom<>();
	RandomNode<T> node = head;
	Map<RandomNode, RandomNode> map = new HashMap<>();
	while (node != null) {
	  if (!map.containsKey(node)) {
		RandomNode<T> copyNode = new RandomNode<>(node.data);
		map.put(node, copyNode);
	  }
	  if (node.random != null) {
		RandomNode<T> random = node.random;
		if (!map.containsKey(random)) {
		  RandomNode<T> copyRandom = new RandomNode<>(random.data);
		  map.put(random, copyRandom);
		}
		map.get(node).random = map.get(random);
	  }
	  copyList.offer(map.get(node));
	  node = node.next;
	}
	return copyList;
  }


  private void offer(RandomNode<T> node) {
	if (head == null) {
	  head = node;
	  end = head;
	} else {
	  end.next = node;
	  end = node;

	}
	count ++;
  }

  public boolean offer(T item) {
	if (head == null) {
	  head = new RandomNode<>(item);
	  end = head;
	} else {
	  RandomNode<T> node = new RandomNode<T>(item);
	  end.next = node;
	  end = node;

	}
	count ++;
	return true;
  }

  /**
   * 创建任意指针
   *
   * @param source 指针源
   * @param target 指针目标
   */
  public void random(long source, long target) {
	if (source < 0 || target < 0) {
	  throw new IllegalArgumentException("source and target is illegal");
	}
	if (source > count - 1 || target > count - 1) {
	  throw new IllegalArgumentException("outside");
	}

	if (source == target) {
	  return;
	}

	if (head == null) {
	  return;
	}

	//  找到源节点
	RandomNode sourceNode =  getForNode(source);
	// 找到目标节点
	RandomNode targetNode = getForNode(target);

	sourceNode.random = targetNode;
  }

  /**
   * 查询指定索引位置的元素
   *
   * @param index
   * @return
   */
  public RandomNode<T> getForNode(long index) {
	if (index < 0) {
	  throw new IllegalArgumentException("index is illegal");
	} else if(head == null) {
	  return null;
	}
	else if (index > count -1) {
	  throw new IllegalArgumentException("outside");
	} else {
	  long i = 0;
	  RandomNode<T> curr = head;
	  RandomNode<T> next = curr.next;
	  while (i < index  && next != null) {
		i++;
		curr = next;
		next = next.next;

	  }
	  return curr;
	}
  }
  @Override
  public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("[");
	if (head != null) {
	  stringBuilder.append(head.data.toString());


	  RandomNode<T> next = head.next;
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

  private class RandomNode<T> {
	private T data;
	private RandomNode<T> next;
	private RandomNode<T> random;
	private RandomNode(T t) {
	  this.data = t;
	}
  }
}
