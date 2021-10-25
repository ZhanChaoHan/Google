package com.jachs.guava.xml;

import org.junit.Test;

import com.google.common.escape.Escaper;
import com.google.common.xml.XmlEscapers;

/***
 * 
 * @author zhanchaohan
 *
 */
public class XmlEscapersTest {
	Escaper aEscaper=XmlEscapers.xmlAttributeEscaper();
	Escaper cEscaper=XmlEscapers.xmlContentEscaper();
	
	@Test
	public void test1() {
		System.out.println(aEscaper.escape("foo \"bar\""));
		System.out.println(cEscaper.escape("foo \"bar\""));
	}
	
}
