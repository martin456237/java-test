package com.java.test.arithmetric.list;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
  private class CacheNode<K, V> {
	private CacheNode(K k, V v) {
	  this.key = k;
	  this.value = v;
	}
	private K key;
	private V value;
	private CacheNode<K, V> next;
	private CacheNode<K, V> pre;
  }

  private int capacity;

  private Map<K, CacheNode<K,V>> cache = new HashMap<>();

  private CacheNode<K, V> head;
  private CacheNode<K, V> tail;
  public LRU(int capacity) {
	this.capacity = capacity;
	head = new CacheNode<>(null, null);
	tail = new CacheNode<>(null, null);
	head.next = tail;
	tail.pre = head;
  }
  private CacheNode<K, V> getNode(K k) {
	if (!this.cache.containsKey(k)) {
	  return null;
	}
	CacheNode<K, V> c = this.cache.get(k);
	if (c == null) {
	  return null;
	}
	// 从双向列表中脱离
	c.pre.next = c.next;
	c.next.pre = c.pre;
	c.pre = null;
	c.next = null;
	// 移动到末尾
	moveToTail(c);
	return c;
  }
  public V get(K k) {
	return getNode(k).value;
  }

  public void put(K k, V v) {
	CacheNode<K, V> cNode = getNode(k);
	//  缓存不存在
	if (cNode == null) {
	  cNode = new CacheNode<K,V>(k, v);
	  // 如果容量满了
	  if (cache.size() == capacity && cache.size() > 0) {
		// 删除列表头部的一个元素
		CacheNode<K, V> nd = head.next;
		CacheNode<K, V> next = head.next.next;
		if (next != null) {
		  nd.next = null;
		  nd.pre = null;
		  head.next = next;
		  next.pre = head;
		}
	  }
	  // 放入缓存
	  cache.put(k, cNode);
	  // 放到列表的尾部
	  moveToTail(cNode);
	} else {
	  cNode.value = v;
	}
  }

  private void moveToTail(CacheNode<K,V> c) {
	c.next = tail;
	tail.pre.next = c;
	c.pre = tail.pre;
	tail.pre = c;
  }

}
