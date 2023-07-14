package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * fileName:Main4
 * 작성날짜:2023-07-13
 * desc :
 **/
public class Main4 {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i<100;
        Predicate<Integer> notP = p.negate();

        //System.out.println(notP.test(111));


        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0 ; i < 10 ;i++){
            list.add(i);
        }
        list.forEach(i->System.out.print(i+","));
        System.out.println();

       Predicate<Integer> pred = x->x%2==0||x%3==0;
       // list.removeIf(i->pred.test(i));
        list.removeIf(x->x%2==0||x%3==0);
        System.out.println("===>" +list);
        
        list.replaceAll(i->i*10);
        System.out.println("list = " + list);

        UnaryOperator<Integer> a = i->i*3;
        list.replaceAll(a);
        System.out.println("list = " + list);

        list.replaceAll(i->a.apply(i));

        System.out.println("list apply = " + list);

        list.replaceAll(a::apply);

        System.out.println("a::apply = " + list);


        Map<String , String> map= new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");

        map.forEach((k,v)-> System.out.println("k= " + k +" v="+v));

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            System.out.println("==>it.hasNext() = " + it.next());
        }
       // map.forEach((k,v)-> System.out.println("k= " + k +" v="+v));
/*
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println("it.hasNext() = " + it.next());
        }*/
        list.forEach(i->{if(i<300)System.out.print(i+",");});
        System.out.println();

    }
}
