package com.jachs.helloworld;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/***
 * 
 * @author zhanchaohan
 *
 */
public class HelloWorldClient {

	private final ManagedChannel channel;
	private final GreeterGrpc.GreeterBlockingStub blockingStub;

	public HelloWorldClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		blockingStub = GreeterGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void greet(String name) {
		HelloRequest request = HelloRequest.newBuilder().setName(name).build();
		HelloReply response;
		try {
			response = blockingStub.sayHello(request);
		} catch (StatusRuntimeException e) {
			System.err.print("RPC failed:" + e.getStatus());
			return;
		}
		System.out.println("Greeting: " + response.getMessage());
	}

	public static void main(String[] args) throws InterruptedException {
		HelloWorldClient client = new HelloWorldClient("127.0.0.1", 50051);
		try {
			String user = "world";
			if (args.length > 0) {
				user = args[0];
			}
			client.greet(user);
		} finally {
			client.shutdown();
		}
	}
}