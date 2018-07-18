package sudden;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {

	Fib fib;

	@Before
	public void initFib() {
		fib = new Fib();
	}

	@Test
	public void testGetFibNumWhenOrderIs_0() {
		assertEquals(1, fib.getFibNum(0));
	}

	@Test
	public void testGetFibNumWhenOrderIs_1() {
		assertEquals(1, fib.getFibNum(1));
	}

	@Test
	public void testGetFibNumWhenOrderIs_2() {
		assertEquals(2, fib.getFibNum(2));
	}

	@Test
	public void testGetFibNumWhenOrderIs_3() {
		assertEquals(3, fib.getFibNum(3));
	}

	@Test
	public void testGetFibNumWhenOrderIs_4() {
		assertEquals(5, fib.getFibNum(4));
	}

	@Test
	public void testGetFibNumWhenOrderIs_5() {
		assertEquals(8, fib.getFibNum(5));
	}

	@Test
	public void testGetFibNumWhenOrderIs_6() {
		assertEquals(13, fib.getFibNum(6));
	}

	@Test
	public void testGetFibNumWhenOrderIs_7() {
		assertEquals(21, fib.getFibNum(7));
	}

	@Test
	public void testGetFibNumWhenOrderIs_8() {
		assertEquals(34, fib.getFibNum(8));
	}

	@Test
	public void testGetFibNumWhenOrderIs_9() {
		assertEquals(55, fib.getFibNum(9));
	}

	@Test
	public void testGetFibNumWhenOrderIs_10() {
		assertEquals(89, fib.getFibNum(10));
	}

	@Test
	public void testGetFibNumWhenOrderIs_11() {
		assertEquals(144, fib.getFibNum(11));
	}

	@Test
	public void testGetFibNumWhenOrderIs_44() {
		assertEquals(1134903170, fib.getFibNum(44));
	}

	@Test
	public void testGetFibNumWhenOrderIs_45() {
		assertEquals(1836311903, fib.getFibNum(45));
	}

	// if Fibonacci number is out of integer range then -1
	@Test
	public void testGetFibNumWhenOrderIs_46() {
		assertEquals(-1, fib.getFibNum(46));
	}

	// if Fibonacci number is out of integer range then -1
	@Test
	public void testGetFibNumWhenOrderIs_999() {
		assertEquals(-1, fib.getFibNum(999));
	}

	@Test
	public void testGetCacheSizeWhenOrderIs45() {
		assertEquals(46, fib.getCacheSize(45));
	}

	@Test
	public void testGetCacheSizeWhenOrderIs46() {
		assertEquals(47, fib.getCacheSize(46));
	}

	@Test
	public void testGetCacheSizeWhenOrderIs47() {
		assertEquals(47, fib.getCacheSize(47));
	}

	@Test
	public void testGetCacheSizeWhenOrderIs9999() {
		assertEquals(47, fib.getCacheSize(9999));
	}

}
