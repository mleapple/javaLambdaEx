package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * fileName:Main3
 * 작성날짜:2023-07-13
 * desc :
 **/
public class Main3 {

    public static void main(String[] args) {
        Supplier<Integer> s=()->(int)(Math.random()*100)+1; // 난수
        Integer intValue =  s.get();
        System.out.println("intValue = " + intValue);

        Consumer<Integer> c=i->System.out.print(" i="+i);
        c.accept(10);

        Predicate<Integer> p = i->i%2==0;
        System.out.println("p = " + p.test(2));

        Function<Integer,Integer> f = i->i/10*10;
        System.out.println("f = " + f.apply(3));


        List<Integer> list = new ArrayList<>();
        makeRandom(s , list);
        System.out.println("list = " + list);

        printEventNum(p,c,list);
        System.out.println("========================= ") ;
        printEventNum(i->i%2==0, i->System.out.print(" i="+i) ,list);


        List<Integer> newList = doSomeThing(f,list);
        System.out.println("newList = " + newList);

        List<Integer> newList2 = doSomeThing(i->i/10*10,list);
        System.out.println("newList = " + newList2);

    }

    static <T> List<T> doSomeThing(Function<T,T> f,List<T> list){
        List<T> newList = new ArrayList<T>(list.size());
        for( T i : list){
            newList.add(f.apply(i));
        }
        return newList;
    }

    static <T> void printEventNum(Predicate<T> p , Consumer<T> c,List<T> list){
        System.out.print("[ " );
        for(T i : list){
            if(p.test(i)){
                c.accept(i);
            }
        }
        System.out.println(" ]" );
    }
    static void makeRandom(Supplier<Integer> s, List<Integer> list) {
        for(int i = 0 ; i < 10 ; i++){
            list.add(s.get());
        }
    }
}
