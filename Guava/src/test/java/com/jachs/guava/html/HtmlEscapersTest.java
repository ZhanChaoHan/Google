package com.jachs.guava.html;

import org.junit.Test;

import com.google.common.html.HtmlEscapers;

/***
 * 转换标签为转义符
 * @author zhanchaohan
 *
 */
public class HtmlEscapersTest {
	@Test
	public void test1() {
		String html=HtmlEscapers.htmlEscaper().escape("<p>aacx</p>");
		System.out.println(html);
	}
	@Test
	public void test2() {
		String html=HtmlEscapers.htmlEscaper().asFunction().apply("<p>aacx</p>");
		System.out.println(html);
	}
}
