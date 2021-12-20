package com.java.test.arithmetric.stack;

import java.util.Stack;

/**
 * 作为stack 的伴生栈，保存stack 的最小值
 */
public class MiniStacke extends Stack<Integer> {
  /**
   * 被代理栈
   */
  private Stack<Integer> host;

  public MiniStacke(Stack<Integer> host) {
	super();
	this.host = host;
  }
  @Override
  public Integer push(Integer item) {
	if (host == null) {
	  host = new Stack<>();
	}
	if (host.isEmpty()) {
	  host.push(item);
	} else {
	  if (this.isEmpty()) {
		host.push(item);
	  } else {
		if (item < this.peek()) {
		  this.push(item);
		} else {
		  this.push(this.peek());
		}
	  }
	}
	return item;
  }

  @Override
  public synchronized Integer pop() {
	this.pop();
	return host.pop();
  }

  public Integer getMin() {
	return this.peek();
  }
}
