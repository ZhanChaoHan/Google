package com.jachs.guava.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.google.common.io.ByteStreams;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ByteStreamsTest {
	//文件复制
	@Test
	public void test1() throws FileNotFoundException, IOException {
		ByteStreams.copy(new FileInputStream("f:\\arthas-boot.jar"), new FileOutputStream("e:\\arthas-boot.jar"));
	}
	//读取一边文件流不会关闭连接
	@Test
	public void test2() throws Exception{
		Long longSize=ByteStreams.exhaust(new FileInputStream("f:\\\\arthas-boot.jar"));
		
		System.out.println(longSize);
	}
	//限制最大读取字节
	@Test
	public void test3() throws IOException {
		InputStream is=ByteStreams.limit(new FileInputStream("f:\\arthas-boot.jar"), 500);
		
		System.out.println(ByteStreams.exhaust(is));
	}
	@Test
	public void test5() {
		
	}
}
