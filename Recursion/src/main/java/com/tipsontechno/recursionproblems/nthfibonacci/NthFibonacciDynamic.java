package com.tipsontechno.recursionproblems.nthfibonacci;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacciDynamic {

    // o(n) time | o(n) space

    public static int getNthFib(int n){

        Map<Integer,Integer> memorize = new HashMap<Integer,Integer>();
        memorize.put(1,0);
        memorize.put(2,1);

        return getNthFib(n,memorize);
    }

    public static int getNthFib(int n,Map<Integer,Integer> memorize){

        if(memorize.containsKey(n)){
            return memorize.get(n);
        }
        else {
            memorize.put(n,getNthFib(n-1,memorize)+getNthFib(n-2,memorize));
            return memorize.get(n);
        }
    }



}
