package com.jachs.guava.io;

import java.io.FileInputStream;

import org.junit.Test;

import com.google.common.io.CountingInputStream;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CountingInputStreamTest {
	
	@Test
	public void test1() throws Exception{
		CountingInputStream cis=new CountingInputStream(new FileInputStream("e:\\21.log"));
		
		byte[] bs=new byte[1];//一次读一个字节
		while(cis.read(bs, 0, bs.length)!=-1) {
			
		}
		//统计需要读多少次
		System.out.println(cis.getCount());
	}
	@Test
	public void test2() {
		System.out.println((byte)'A');
	}
}
