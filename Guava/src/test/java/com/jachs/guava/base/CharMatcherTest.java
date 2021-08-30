package com.jachs.guava.base;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CharMatcherTest {
	@Test
	public void test1() {
		System.out.println(CharMatcher.any().isNot('c'));
	}
}
