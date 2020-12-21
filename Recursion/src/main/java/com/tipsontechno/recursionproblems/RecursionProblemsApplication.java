package com.tipsontechno.recursionproblems;

import com.tipsontechno.recursionproblems.nthfibonacci.NthFibonacci;
import com.tipsontechno.recursionproblems.nthfibonacci.NthFibonacciDynamic;
import com.tipsontechno.recursionproblems.nthfibonacci.NthFibonacciIterative;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RecursionProblemsApplication {

    enum Problems {
        NTH_FIBONACCI,
        PRODUCT_SUM,
        PERMUTATIONS
    }

    public static void main(String[] args) {

      Problems option=Problems.valueOf("NTH_FIBONACCI");
      if(checkArgs(args,option) == 0){
        switch(option){
            case NTH_FIBONACCI:{
                int result=NthFibonacci.getNthFib(6);
                System.out.println("Result for NthFibonacci is "+result);
                result= NthFibonacciDynamic.getNthFib(6);
                System.out.println("Result for NthFibonacciDynamic is "+result);
                result= NthFibonacciIterative.getNthFib(6);
                System.out.println("Result for NthFibonacciIterative is "+result);
            }
        }
      }
     //   SpringApplication.run(RecursionProblemsApplication.class, args);
    }

    private static int checkArgs(String[] args, Problems option){

        if(args.length != 1){
            System.out.println("Usage: java -jar recursive-problems <problems>");
            return -1;
        }
        for(Problems op: option.values()){
            if(op.name().compareToIgnoreCase(args[0]) == 0){
                option=op;
                return 0;
            }
        }
        return -1;

    }

}
