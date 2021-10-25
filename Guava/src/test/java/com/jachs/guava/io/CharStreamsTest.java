package com.jachs.guava.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.junit.Test;

import com.google.common.io.CharStreams;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CharStreamsTest {

	@Test
	public void test1() throws IOException {
		StringBuffer sb=new StringBuffer();
		Writer wr=CharStreams.asWriter(sb);
		wr.write('A');
		wr.write("B");
		System.out.println(sb.toString());
	}
	@Test
	public void test2() throws IOException{
		StringBuffer sb=new StringBuffer();
		CharStreams.copy(new FileReader("e:\\21.log"), sb);
		
		System.out.println(sb.toString());
	}
	@Test
	public void test3() throws IOException{
		long longSize=CharStreams.exhaust(new FileReader("e:\\21.log"));
		
		System.out.println(longSize);
	}
	@Test
	public void test5() throws IOException{
		List<String>sList=CharStreams.readLines(new FileReader("e:\\21.log"));
		
		for (String str : sList) {
			System.out.println(str);
		}
	}
	@Test
	public void test6() {
		
	}
}
