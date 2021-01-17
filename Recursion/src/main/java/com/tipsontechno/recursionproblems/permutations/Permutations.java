package com.tipsontechno.recursionproblems.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //o(n^2*n!) time complexity
    //o(n*n!) space complexity

    public static List<List<Integer>> getPermutationsV1(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutationsV1(array, new ArrayList<Integer>(),permutations);
        return permutations;

    }


    public static void getPermutationsV1(List<Integer> array,
                                       List<Integer> currentPermutations,
                                       List<List<Integer>> permulations ){

        if(array.size() == 0 && currentPermutations.size() > 0){
            permulations.add(currentPermutations);
        }
        else {
            for(int i=0; i < array.size(); i++){
                List<Integer> newArray  = new ArrayList<Integer>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutations);
                newPermutation.add(array.get(i));
                getPermutationsV1(newArray,newPermutation,permulations);
            }
        }

    }

    public static List<List<Integer>> getPermutationsV2(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutationsV2(0, array,permutations);
        return permutations;

    }


    public static void getPermutationsV2(int i, List<Integer> array,List<List<Integer>> permuations){
        if( i == array.size() - 1){
            permuations.add(new ArrayList<Integer>(array));
        }else {
            for(int j=i; j < array.size(); j++){
                swap(array,i,j);
                getPermutationsV2(i+1,array,permuations);
                swap(array,i,j);
            }
        }

    }

    public static void swap(List<Integer> array, int i, int j){
        Integer tmp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,tmp);
    }

}
