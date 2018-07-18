package sudden;

import java.util.ArrayList;
import java.util.List;

/**
 * Fibonacci Number
 *
 * @Author : YoungHwa Lee
 *
 */
public class Fibonacci {

    public static void main(String[] args) {

        Fib instance = new Fib();
        System.out.println(instance.getLogWhen(0));
        System.out.println(instance.getLogWhen(1));
        System.out.println(instance.getLogWhen(2));
        System.out.println(instance.getLogWhen(3));
        System.out.println(instance.getLogWhen(4));
        System.out.println(instance.getLogWhen(5));
        System.out.println(instance.getLogWhen(6));
        System.out.println(instance.getLogWhen(7));
        System.out.println(instance.getLogWhen(8));
        System.out.println(instance.getLogWhen(9));
        System.out.println(instance.getLogWhen(10));
        System.out.println(instance.getLogWhen(44));
        System.out.println(instance.getLogWhen(45));
        System.out.println(instance.getLogWhen(46));
        System.out.println(instance.getLogWhen(47));
        System.out.println(instance.getLogWhen(999));
        System.out.println(instance.getLogWhen(1010));

    }
}

/**
 * Fibonacci using cache
 *
 * <p>
 * I remember that the return type of fib() method of sample Fib class which i saw at interview is int.
 * So I needed to control the return value considering whether it is out of integer range or not.
 * When setting valid cache values (in range of integer) are completed, then no more caching.(limit cache for saving resource)
 *
 * @Author : YoungHwa Lee
 *
 */
class Fib {

	// value to return when Fibonacci number is out of integer range
	private static final int _RETURN_VALUE_WHEN_OUT_OF_INT = -1;
	// when setting valid cache values(in range of integer) are completed, then true for no more caching
	private boolean isFullyCached;
    // Cache for save previous results
    private final List<Integer> cache;

    Fib() {
    	this.isFullyCached = false;
        this.cache = new ArrayList<Integer>();
    }

    /**
     * method to return cached Fibonacci number for specific order
     *
     * @param order
     *            specific order
     * @return Fibonacci number(if number is over Integer range then -1)
     */
    public int getFibNum(int order) {

        // no cached values to refer
        if (cache.size() < order) {
            // recursion for caching
            getFibNum(order - 1);

            // setting valid cache values are completed, retrun -1
        	if(isFullyCached) {
        		return _RETURN_VALUE_WHEN_OUT_OF_INT;
        	}
            getFibNum(order);

        } else {
            // when 0, 1 then set 1
            if (order <= 1) {

                cache.add(1);

            } else {

                long temp = Long.sum(cache.get(order - 2), cache.get(order - 1));
                // advanced : if Fibonacci number is out of integer range then -1
                if (cache.get(order - 2) < 0 || cache.get(order - 1) < 0 || temp > Integer.MAX_VALUE) {
                	isFullyCached = true;
                    cache.add(_RETURN_VALUE_WHEN_OUT_OF_INT);

                } else {

                    cache.add((int) temp);

                }
            }
        }

        return cache.get(order);
    }

    /**
     * print log with returned Fibonacci number when specific order given
     *
     * @param order Fibonacci order
     * @return log string
     */
    public String getLogWhen(int order) {
        return String.format("Fibonacci #%d = %d", order, getFibNum(order));
    }

	/**
	 * method to return cache count
	 *
	 * @return cache count
	 */
	public Object getCacheSize() {

		return cache.size();
	}
}
