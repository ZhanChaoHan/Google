package com.jachs.guava.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/***
 * 
 * @author zhanchaohan
 *
 */
public class StudyGuavaCache {

	/***
	 * 构建缓存对象
	 */
	@Test
	public void test1() {
		Cache<String, String> cache = CacheBuilder.newBuilder().build();
		cache.put("word", "Hello Guava Cache");
		cache.put("key", "Hello My Key");
		System.out.println(cache.getIfPresent("word"));
		System.out.println(cache.getIfPresent("key"));
	}

	/***
	 * 设置最大存储<br>
	 * Guava Cache可以在构建缓存对象时指定缓存所能够存储的最大记录数量。当Cache中的记录数量达到最大值后再调用put方法向其中添加对象，<br>
	 * Guava会先从当前缓存的对象记录中选择一条删除掉，腾出空间后再将新的对象存储到Cache中。
	 */
	@Test
	public void test2() {
		Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(2).build();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");
		System.out.println("第一个值：" + cache.getIfPresent("key1"));
		System.out.println("第二个值：" + cache.getIfPresent("key2"));
		System.out.println("第三个值：" + cache.getIfPresent("key3"));
	}

	/***
	 * 设置过期时间<br>
	 * 在构建Cache对象时，可以通过CacheBuilder类的expireAfterAccess和expireAfterWrite两个方法为缓存中的对象指定过期时间，<br>
	 * 过期的对象将会被缓存自动删除。其中，expireAfterWrite方法指定对象被写入到缓存后多久过期，expireAfterAccess指定对象多久没有被访问后过期。
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test3() throws InterruptedException {
		Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(2).expireAfterWrite(3, TimeUnit.SECONDS)
				.build();
		cache.put("key1", "value1");
		int time = 1;
		while (true) {
			System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
			Thread.sleep(1000);
		}
	}

	/***
	 * 弱引用<br>
	 * 可以通过weakKeys和weakValues方法指定Cache只保存对缓存记录key和value的弱引用。<br>
	 * 这样当没有其他强引用指向key和value时，key和value对象就会被垃圾回收器回收。
	 */
	@Test
	public void test5() {
		Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(2).weakValues().build();
		Object value = new Object();
		cache.put("key1", value);

		value = new Object();// 原对象不再有强引用
		System.gc();
		System.out.println(cache.getIfPresent("key1"));
	}

	/***
	 * 显示清除<br>
	 * 可以调用Cache的invalidateAll或invalidate方法显示删除Cache中的记录。invalidate方法一次只能删除Cache中一个记录，<br>
	 * 接收的参数是要删除记录的key。invalidateAll方法可以批量删除Cache中的记录，当没有传任何参数时，<br>
	 * invalidateAll方法将清除Cache中的全部记录。invalidateAll也可以接收一个Iterable类型的参数，参数中包含要删除记录的所有key值。下面代码对此做了示例。
	 */
	@Test
	public void test6() {
		Cache<String, String> cache = CacheBuilder.newBuilder().build();
		Object value = new Object();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");

		List<String> list = new ArrayList<String>();
		list.add("key1");
		list.add("key2");

		cache.invalidateAll(list);// 批量清除list中全部key对应的记录
		System.out.println(cache.getIfPresent("key1"));
		System.out.println(cache.getIfPresent("key2"));
		System.out.println(cache.getIfPresent("key3"));
	}

	/***
	 * 移除监听器<br>
	 * 可以为Cache对象添加一个移除监听器，这样当有记录被删除时可以感知到这个事件。
	 */
	@Test
	public void test7() {
		RemovalListener<String, String> listener = new RemovalListener<String, String>() {
			public void onRemoval(RemovalNotification<String, String> notification) {
				System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
			}
		};
		Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).removalListener(listener).build();
		Object value = new Object();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");
		cache.put("key4", "value3");
		cache.put("key5", "value3");
		cache.put("key6", "value3");
		cache.put("key7", "value3");
		cache.put("key8", "value3");
	}

	/***
	 * 统计信息<br>
	 * 可以对Cache的命中率、加载数据时间等信息进行统计。在构建Cache对象时，可以通过CacheBuilder的recordStats方法开启统计信息的开关。<br>
	 * 开关开启后Cache会自动对缓存的各种操作进行统计，调用Cache的stats方法可以查看统计后的信息。<br>
	 */
	@Test
	public void test8() {
		Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).recordStats() // 开启统计信息开关
				.build();
		cache.put("key1", "value1");
		cache.put("key2", "value2");
		cache.put("key3", "value3");
		cache.put("key4", "value4");

		cache.getIfPresent("key1");
		cache.getIfPresent("key2");
		cache.getIfPresent("key3");
		cache.getIfPresent("key4");
		cache.getIfPresent("key5");
		cache.getIfPresent("key6");

		System.out.println(cache.stats()); // 获取统计信息
	}

	/***
	 * LoadingCache<br>
	 * LoadingCache是Cache的子接口，相比较于Cache，当从LoadingCache中读取一个指定key的记录时，如果该记录不存在，<br>
	 * 则LoadingCache可以自动执行加载数据到缓存的操作。LoadingCache接口的定义如下：<br>
	 * @throws ExecutionException 
	 */
	@Test
	public void test9() throws ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String> () {
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");	
                return key + "'s value";
            }
        };
	
        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);//在构建时指定自动加载器
	
        loadingCache.get("key1");
        loadingCache.get("key2");
        loadingCache.get("key3");
	}
}
