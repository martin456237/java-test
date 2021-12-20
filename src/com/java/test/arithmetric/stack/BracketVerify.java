package com.java.test.arithmetric.stack;

import org.junit.Test;

import java.util.Stack;

public class BracketVerify {
  @Test
  public void bracketVerifyTest() {
	String s = "sl[(){()}]";
	System.out.println(bracketVerify(s));
  }
  /**
   * 括号规则验证
   *
   * @param s
   * @return
   */
  public boolean bracketVerify(String s) {
	if (s == null || s.length() == 0){
	  return false;
	}
	Stack<Character> stack = new Stack<>();
	char[] chars = s.toCharArray();
	for (char c : chars) {
	  if (c == '(' || c == '[' || c == '{') {
		stack.push(c);
	  }
	  if (c == ')' && stack.pop() != '(') {
		return false;
	  }
	  if (c == ']' && stack.pop() != '[') {
		return false;
	  }
	  if (c == '}' && stack.pop() != '{') {
		return false;
	  }
	}
	// 如果stack 不是空的说明缺少右边的括号
	return stack.isEmpty();
  }
}
