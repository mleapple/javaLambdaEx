package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * fileName:Stream001
 * 작성날짜:2023-07-14
 * desc :
 **/
public class Stream001 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> result = new ArrayList<>();
        List<Integer> result2 =  list.stream()
                .filter(x->x>1 && x <11)
                .filter(x->x%2==0)
                .map(x->x+1000)
                .collect(Collectors.toList());
        System.out.println("result2 = " + result2);


        List<Integer> result3 =  list.stream()
                .filter(x->x>1 && x <11)
                .filter(x->x%2==0)
                .map(x->x+1000)
                .filter(x->x%3==0)
                .collect(Collectors.toList());
        System.out.println(1008%3+" result3 = " + result3);


        System.out.println(" list = >>>>>" + list);
        Optional<Integer> optionalInteger=  list.stream()
                .filter(x->x>2 && x <10)
                .filter(x->x%2==0)
                .map(x->x+1)
                .filter(x->x%3==0)
                .findFirst();
        System.out.println(" optionalInteger = >>>>>" + optionalInteger.orElse(0));
    }
}
