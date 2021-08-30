package com.jachs.guava.base;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.google.common.base.Charsets;

/***
 * 设置字符串编码
 * @author zhanchaohan
 *
 */
public class CharsetsTest {
	@Test
	public void test1() {
		System.out.println(Charsets.ISO_8859_1);
		System.out.println(Charsets.US_ASCII);
		System.out.println(Charsets.UTF_16);
		System.out.println(Charsets.UTF_16BE);
		System.out.println(Charsets.UTF_16LE);
		System.out.println(Charsets.UTF_8);
	}
	@Test
	public void test2() throws UnsupportedEncodingException {
		String str="天气好，好天气";
		
		System.out.println(new String(str.getBytes(),Charsets.ISO_8859_1));
		System.out.println(new String(str.getBytes(),Charsets.UTF_8));
	}
}
