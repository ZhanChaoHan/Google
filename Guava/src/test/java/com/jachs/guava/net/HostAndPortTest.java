package com.jachs.guava.net;

import org.junit.Test;

import com.google.common.net.HostAndPort;

/***
 * 
 * @author zhanchaohan
 *
 */
public class HostAndPortTest {
	HostAndPort host=HostAndPort.fromHost("127.0.0.1");
	HostAndPort port=HostAndPort.fromParts("127.0.0.1", 8080);
	HostAndPort hostStr=HostAndPort.fromString("127.0.0.1:8080");
	
	@Test
	public void test1() {
		System.out.println(port.getHost());
		System.out.println(port.getPort());
		
		System.out.println(hostStr.getHost());
		System.out.println(hostStr.getPort());
		
		System.out.println(host.getHost());
		System.out.println(host.getPort());
	}
	@Test
	public void test2() {
		System.out.println(host.requireBracketsForIPv6());
	}
}
