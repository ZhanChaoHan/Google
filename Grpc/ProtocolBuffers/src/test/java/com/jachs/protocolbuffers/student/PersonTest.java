package com.jachs.protocolbuffers.student;


import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.jachs.protocolbuffers.person.PersonProto;
import com.jachs.protocolbuffers.person.PersonProto.Person;
import com.jachs.protocolbuffers.person.PersonProto.Person.PhoneNumber;

/***
 * 
 * @author zhanchaohan</br>
 *         protoc --java_out=src/main/java src/main/resources/person.proto
 */
public class PersonTest {
	@Test
	public void test1() throws InvalidProtocolBufferException {
		Person person = PersonProto.Person.newBuilder().setId(0).setEmail("cceq.@lck.com").setName("jack")
				.setPhone(1, PhoneNumber.newBuilder().setNumber("15247854").build()).build();

		System.out.println(person.getName());

		// 转换字节码
		PersonProto.Person.parseFrom(person.toByteArray());

	}
	
}
