package com.jachs.guava.base;

import org.junit.Test;

import com.google.common.base.CaseFormat;

/***
 * 大小写格式
 * 
 * @author zhanchaohan
 *
 */
public class CaseFormatTest {
	@Test
	public void test1() {
		String st1 = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");

		System.out.println(st1);
	}
	@Test
	public void test2() {
		String st1 = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_CAMEL, "IM_HAPPY");
		String st2 = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "IM_HAPPY");
		
		System.out.println(st1);
		System.out.println(st2);
	}
	@Test
	public void test3() {
		String st1 = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "IM_HAPPY");
		String st2 = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "IM_HAPPY");
		
		System.out.println(st1);
		System.out.println(st2);
	}
}
