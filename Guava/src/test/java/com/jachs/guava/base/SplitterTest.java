package com.jachs.guava.base;


import java.util.Iterator;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/***
 * 分词器
 * @author zhanchaohan
 *
 */
public class SplitterTest {
	@Test
	public void test1() {
		Iterator<String>sList=Splitter.on(',')
			        .trimResults()//移除结果字符串的前导空白和尾部空白
			        .omitEmptyStrings()//从结果中自动忽略空字符串
			        .split("foo,myFoobar,,   qux").iterator();
		
		while(sList.hasNext()) {
			System.out.println(sList.next());
		}
	}
	@Test
	public void test2() {
		Iterator<String>sList=Splitter.on(',')
			        .trimResults()//移除结果字符串的前导空白和尾部空白
			        .omitEmptyStrings()//从结果中自动忽略空字符串
			        .trimResults(CharMatcher.anyOf("f") )
			        .split("foo,myFoobar,,   qux").iterator();//给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
		
		while(sList.hasNext()) {
			System.out.println(sList.next());
		}
	}
	@Test
	public void test3() {
		Iterator<String>sList=Splitter.on(',')
				.limit(3)//限制拆分出的字符串数量
			    .split("foo,myFoobar,great,   qux,kjc,iuy").iterator();//给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
		
		while(sList.hasNext()) {
			System.out.println(sList.next());
		}
	}
}
