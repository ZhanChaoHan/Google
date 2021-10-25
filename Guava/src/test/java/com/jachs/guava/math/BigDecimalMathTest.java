package com.jachs.guava.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.google.common.math.BigDecimalMath;

/***
 * 
 * @author zhanchaohan
 *
 */
public class BigDecimalMathTest {

	@Test
	public void test1() {
		double doub = BigDecimalMath.roundToDouble(new BigDecimal(12.58), RoundingMode.UP);
		System.out.println(doub);
	}
}
