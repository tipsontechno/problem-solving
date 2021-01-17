package com.tipsontechno.recursionproblems;

import com.tipsontechno.recursionproblems.nthfibonacci.NthFibonacci;
import com.tipsontechno.recursionproblems.nthfibonacci.NthFibonacciDynamic;
import com.tipsontechno.recursionproblems.nthfibonacci.NthFibonacciIterative;
import com.tipsontechno.recursionproblems.permutations.Permutations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


      if(checkArgs(args) == 0){
          Problems option = Problems.valueOf(args[0]);
          System.out.println("Current options is "+option);
        switch(option){
            case NTH_FIBONACCI:{
                int result=NthFibonacci.getNthFib(6);
                System.out.println("Result for NthFibonacci is "+result);
                result= NthFibonacciDynamic.getNthFib(6);
                System.out.println("Result for NthFibonacciDynamic is "+result);
                result= NthFibonacciIterative.getNthFib(6);
                System.out.println("Result for NthFibonacciIterative is "+result);
            }
            case PERMUTATIONS: {
                List<Integer> input = new ArrayList<>();
                input.add(1);
                input.add(2);
                input.add(3);
                System.out.println("Result from version 1");
                List<List<Integer>> permutations = Permutations.getPermutationsV1(input);
                for(List<Integer> l:permutations){
                    for(Integer i:l){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                }
                System.out.println("Result from version 2");
                permutations = Permutations.getPermutationsV2(input);
                for(List<Integer> l:permutations){
                    for(Integer i:l){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                }
            }
        }
      }
     //   SpringApplication.run(RecursionProblemsApplication.class, args);
    }

    private static int checkArgs(String[] args){

        if(args.length != 1){
            System.out.println("Usage: java -jar recursive-problems <problems>");
            return -1;
        }
        try {
            Problems option = Problems.valueOf(args[0]);
            return  0;
        }catch(Exception ex){
            System.out.println("Usage: java -jar recursive-problems <problems>");
            return -1;
        }


    }

}
