
import java.util.ArrayList;
import java.util.List;

/**
 * Fibonacci with cache Class
 *
 * @Author : YoungHwa Lee
 *
 */
public class Fibonacci {

    static class Fib {

        // Cache for save previous results
        List<Integer> cache;

        Fib() {
            this.cache = new ArrayList<Integer>();
        }

        /**
         * method to return cached Fibonacci number
         *
         * @param order
         *            Fibonacci order
         * @return Fibonacci number(if number is over Integer range then -1)
         */
        public int getFibNum(int order) {

            // no cached values which has to refer
            if (cache.size() < order) {
                // recursion to caching
                getFibNum(order - 1);
                getFibNum(order);

            } else {
                // when 0, 1 then set 1
                if (order <= 1) {

                    cache.add(1);

                } else {

                    long temp = Long.sum(cache.get(order - 2), cache.get(order - 1));
                    // advanced : when result over Integer Max value then set -1
                    if (cache.get(order - 2) < 0 || cache.get(order - 1) < 0 || temp > Integer.MAX_VALUE) {

                        cache.add(-1);

                    } else {

                        cache.add((int) temp);

                    }
                }
            }

            return cache.get(order);
        }

        public String fib(int order) {
            return String.format("Fibonacci #%d = %d", order, getFibNum(order));
        }
    }

    public static void main(String[] args) {

        Fib instance = new Fib();
        System.out.println(instance.fib(0));
        System.out.println(instance.fib(1));
        System.out.println(instance.fib(2));
        System.out.println(instance.fib(3));
        System.out.println(instance.fib(4));
        System.out.println(instance.fib(5));
        System.out.println(instance.fib(6));
        System.out.println(instance.fib(7));
        System.out.println(instance.fib(8));
        System.out.println(instance.fib(9));
        System.out.println(instance.fib(10));
        System.out.println(instance.fib(45));
        System.out.println(instance.fib(46));
        System.out.println(instance.fib(47));
        System.out.println(instance.fib(999));

    }
}
