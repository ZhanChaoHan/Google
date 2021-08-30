package com.jachs.protocolbuffers.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;

/***
 * 
 * @author zhanchaohan</br>
 *         protoc --java_out=src/main/java src/main/resources/student.proto
 */
public class StudentTest {

	@Test
	public void test1() throws InvalidProtocolBufferException {
		Student student = Student.newBuilder().setId(0).setName("zcs").setEmail("568947@kcl.com").build();

		System.out.println(student.getName());

		byte[] studentList = student.toByteArray();
		Student student2 = Student.parseFrom(studentList);

		System.out.println(student2.getName());
	}
	//a:23字节。b:138字节
	@Test
	public void test2() throws FileNotFoundException, IOException {
		Student sa = Student.newBuilder()
				.setId(0).setName("zcs").setEmail("568947@kcl.com").build();
		
		com.jachs.protocolbuffers.student.se.Student sb=
				new com.jachs.protocolbuffers.student.se.Student(0, "zcs", "568947@kcl.com");
		
		ObjectOutput osB=new ObjectOutputStream(new FileOutputStream("e:\\b"));
		
		osB.writeObject(sb);
		
		osB.close();
		sa.writeTo(new FileOutputStream("e:\\a"));
	}
	@Test
	public void test3() throws Exception {
		ObjectInput oiB=new ObjectInputStream(new FileInputStream("e:\\b"));
		
		Student sa =Student.parseFrom(new FileInputStream("e:\\a"));
		
		com.jachs.protocolbuffers.student.se.Student sb=(com.jachs.protocolbuffers.student.se.Student) oiB.readObject();
		
		System.out.println(sa.getEmail());
		System.out.println(sb.getEmail());
		
	}
}
