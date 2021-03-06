package com.jachs.guava.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/***
 * 
 * @author zhanchaohan
 *
 */
public class AutoLoad {
	private static Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).build();

	public static void main(String[] args) throws InterruptedException {

		new Thread(new Runnable() {
			public void run() {
				System.out.println("thread1");
				try {
					String value = cache.get("key", new Callable<String>() {
						public String call() throws Exception {
							System.out.println("load1"); // 加载数据线程执行标志
							Thread.sleep(1000); // 模拟加载时间
							return "auto load by Callable";
						}
					});
					System.out.println("thread1 " + value);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				System.out.println("thread2");
				try {
					String value = cache.get("key", new Callable<String>() {
						public String call() throws Exception {
							System.out.println("load2"); // 加载数据线程执行标志
							Thread.sleep(1000); // 模拟加载时间
							return "auto load by Callable";
						}
					});
					System.out.println("thread2 " + value);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
