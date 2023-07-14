package org.example;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * fileName:Lambda001
 * 작성날짜:2023-07-14
 * desc :
 **/


public class Lambda002 {


    public static void  main(String[]args){
     /*   Function<Integer,Integer> function  = (a) ->  a + 10 ;
        System.out.println(function.apply(10));

        System.out.println( getA(10,a->a-5));
        System.out.println( getA(3,a->a*a));*/

        Map<String,Object> info = new HashMap<>();
        info.put("1", "사과");
        Consumer<Map<String,Object>>  csr =(Map<String,Object> x)-> {
            x.put("2","바나나");
            Iterator<String> it =  x.keySet().iterator();;
            while (it.hasNext()){
                String  key = it.next();
                System.out.println(key+" = " + (String) x.get(key));
               // System.out.println("x = " + it.next());
            }
        };
        csr.accept(info);

        getB(info ,x->{
            x.put("3","키위");
            Iterator<String> it =  x.keySet().iterator();;
            while (it.hasNext()){
                String  key = it.next();
                System.out.println(key+" = " + (String) x.get(key));
                // System.out.println("x = " + it.next());
            }
        } );

        System.out.println(" =========================================================== " );

        Predicate<List<Integer>> tx = x->{
           return x.stream().filter(o->o <10).collect(Collectors.toList()).size() > 0;
        };
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(11);

        System.out.println("tx.test(list) = " + tx.test(list));

        List<String> list2= new ArrayList<>();
        list2.add("사과");
        list2.add("바나나");
        list2.add("포도");
        list2.add("키위");

        if(getC(list2 ,x->{
            return x.stream().filter(o->o.equals("사과ㅁ")).collect(Collectors.toList()).size() > 0;
        }))
            System.out.println(" = 존재 합니다" );

        String findStr="키위";
        Predicate<List<String>>  consumer = x->{
            return x.stream().filter(o->o.equals(findStr)).collect(Collectors.toList()).size() > 0;
            //return x.stream().filter(o->o.equals(findStr)).collect(Collectors.toList()).size() > 0;
        };
        if(consumer.test(list2))  System.out.println(findStr +" =>>> 존재 합니다" );


        Predicate<Integer> c2 =x->x >10 ;

        for(Integer integer : list){
            if(c2.test(integer)){
                System.out.println(" 10 보다 큰수가 존재 합니다 "+integer);
            }
        }


        if(getPred(list,x->x >11 )) {
            System.out.println(" = 값이 존재 합니다");
        }else{
            System.out.println(" = 값이 존재 하지 않습니다");
        }
        int cnkint = 2;
        if(list.stream().filter(x->x >cnkint).findFirst().isPresent()) {
            System.out.println(cnkint+" = 값이 존재 합니다 값은 >>>"+list.stream().filter(x->x >cnkint).collect(Collectors.toList()));

        }else{
            System.out.println(cnkint+" = 값이 존재 하지 않습니다");
        }
        
        List<Integer> re1=    list.stream().filter(x->x>5).collect(Collectors.toList());
        System.out.println("re1 = " + re1);
        Long start = System.currentTimeMillis();
        System.out.println("start = " + (start/1000));
        getE(0 , heavyValue());
        getE(1 , heavyValue());
        getE(1 , heavyValue());
        Long end = System.currentTimeMillis();
        System.out.println("end = " + ((end-start)/1000));


         start = System.currentTimeMillis();
        System.out.println("start = " + (start/1000));
        getE1(0 , ()->heavyValue());
        getE1(1 , ()->heavyValue());
        getE1(1 , ()-> heavyValue());
         end = System.currentTimeMillis();
        System.out.println("end = " + ((end-start)/1000));


    }

    public static Integer getA(int a , Function<Integer,Integer> function){
        return function.apply(a);
    }

    public static void getB(Map<String,Object> map , Consumer<Map<String,Object>>  consumer){
        consumer.accept(map);
    }

    public static boolean getC(List<String> list, Predicate<List<String>>  consumer){
       return consumer.test(list);
    }

    private static void getE(int num , String value){
        if(num ==0){
            System.out.println("value= " + value);
        }else{
            System.out.println(" N= " );
        }
    }
    private static void getE1(int num , Supplier<String> supplier){
        if(num ==0){
            System.out.println("value= " + supplier.get());
        }else{
            System.out.println(" N= " );
        }
    }
    private static String heavyValue(){
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  "heavy";
    }
    public static boolean getPred(List<Integer> list, Predicate<Integer>  predicate){

        Optional<Integer> optionalInteger =  list.stream().filter(x->predicate.test(x)).findFirst();

        return optionalInteger.isPresent();
    }

}
