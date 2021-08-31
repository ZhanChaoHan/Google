package com.jachs.guava.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

/***
 * 
 * @author zhanchaohan
 *
 */
public class FilesTest {
	/***
	 * 复制文件
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void copyTest() throws FileNotFoundException, IOException {
		Files.copy(new File("e:\\aaa.txt"), new FileOutputStream("f:\\c.txt"));
		Files.copy(new File("e:\\aaa.txt"), new File("f:\\cc.txt"));
	}

	/***
	 * 文本后追加内容
	 * 
	 * @throws IOException
	 */
	@Test
	public void testAppend() throws IOException {
		Files.append("追加内容", new File("f:\\cc.txt"), Charset.defaultCharset());
	}

	/***
	 * 可以同时获取is和os, 需要手动关闭流
	 */
	@Test
	public void testByteSink() {
		ByteSink bs = Files.asByteSink(new File("f:\\cc.txt"), FileWriteMode.APPEND);
	}
	@Test
	public void testByteSource() {
		ByteSource  bs=Files.asByteSource(new File("f:\\cc.txt"));
	}
	//------------------------------
	@Test
	public void testCharSink() {
		CharSink  cs=Files.asCharSink(null, null, null);
	}
	@Test
	public void testCharSource() {
		CharSource cs=Files.asCharSource(new File(""), Charset.defaultCharset());
	}
	//----------------------------------
	@Test
	public void testcreateParentDirs() throws IOException {
		//创建父级文件夹如果不存在
		Files.createParentDirs(new File("f:\\aaa\\aa\\a"));
	}
	@Test
	public void testFileExtension() {
		//取后缀
		String nc=Files.getFileExtension("jchu.ewq.dqfw.v.txt");
		
		System.out.println(nc);
	}
	@Test
	public void testNameWithoutExtension() {
		//取名称
		String nc=Files.getNameWithoutExtension("jchu.ewq.dqfw.v.txt");
		
		System.out.println(nc);
	}
	@Test
	public void testMap() throws IOException {
		MappedByteBuffer mbb=Files.map(new File(""));
	}
	@Test
	public void testMove() throws IOException {
		//移动文件
		Files.move(new File("f:\\a.txt"), new File("e:\\bc.txt"));
	}
}
