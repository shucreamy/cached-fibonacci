package sudden;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(instance.getLogWhen(999));

    }
}
class Fib {

    // Cache for save previous results
    private List<Integer> cache;

    Fib() {
        this.cache = new ArrayList<Integer>();
    }

    public int getFibNum(int order) {

        // no cached values to refer
        if (cache.size() < order) {
            // recursion for caching
            getFibNum(order - 1);
            getFibNum(order);

        } else {
            // when 0, 1 then set 1
            if (order <= 1) {

                cache.add(1);

            } else {

                long temp = Long.sum(cache.get(order - 2), cache.get(order - 1));
                // advanced : if Fibonacci number is out of integer range then -1
                if (cache.get(order - 2) < 0 || cache.get(order - 1) < 0 || temp > Integer.MAX_VALUE) {

                    cache.add(-1);

                } else {

                    cache.add((int) temp);

                }
            }
        }

        return cache.get(order);
    }

    public String getLogWhen(int order) {
        return String.format("Fibonacci #%d = %d", order, getFibNum(order));
    }
}
