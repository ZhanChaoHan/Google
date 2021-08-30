package com.jachs.guava.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;

/***
 * 
 * @author zhanchaohan
 *
 */
public class JoinerTest {

	@Test
	public void test1() {
		Joiner joiner = Joiner.on("; ").skipNulls();
		
		System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
	}
	@Test
	public void test2() {
		Joiner joiner=Joiner.on(",").skipNulls();
		List<String>sList=new ArrayList<String>();
		sList.add("Harry");
		sList.add(null);
		sList.add("Ron");
		sList.add("Hermione");
		
		System.out.println(joiner.join(sList));
	}
}
