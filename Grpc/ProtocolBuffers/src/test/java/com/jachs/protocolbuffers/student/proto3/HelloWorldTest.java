package com.jachs.protocolbuffers.student.proto3;

import java.util.List;

import org.junit.Test;

import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.jachs.protocolbuffers.proto3.helloworld.HelloReply;
import com.jachs.protocolbuffers.proto3.helloworld.HelloRequest;
import com.jachs.protocolbuffers.proto3.helloworld.HelloWorldProto;

/***
 * 
 * @author zhanchaohan</br>
 *protoc --java_out=src/main/java src/main/resources/proto3/helloworld.proto
 */
public class HelloWorldTest {

	@Test
	public void TestHelloReply() {
		HelloReply hr=HelloReply.newBuilder().setMessage("say hello").build();
		
		HelloRequest hsr=HelloRequest.newBuilder().setName("request nothing").build();
		
		FileDescriptor df=HelloWorldProto.getDescriptor();
		
		List<ServiceDescriptor>sdList=df.getServices();
		
		for (ServiceDescriptor serviceDescriptor : sdList) {
			System.out.println(serviceDescriptor.getName());
		}
	}
}
