package org.example;


import org.example.fn.MyFunction;

import java.util.*;

/**
 * fileName:${NAME}
 * 작성날짜:2023-07-13
 * desc :
 **/
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
      // 함수형 언어
      //  System.out.println(" = " );
      // 반환 값이 있는경우 return 생략 가능
      // 추론 생략 가능하면 타입 생략가능

      //  (a,b)-> a>b ?a:b;
      //  ( name, i )-> System.out.println( name+"="+i)
      //  x -> x*x
      //  ()-> (int)Math.random()*6
      // 익명객체다
      //  (a,b)-> a>b ?a:b;
      /*   Object ob = new Object(){
            public int max(int a , int b){
                 return a >b ?a:b;
             }
         };*/
       // System.out.println("ob = " + ob.max(1,2));
        // 함수형 인터페이스

        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) { // 구현체
                return a >b ? a:b;
            }
        };

        System.out.println("f={}"+f.max(10,3));
        MyFunction f2 = (a,b)->a >b ? a:b;
        System.out.println("f={}"+f2.max(2,3));
        // 함수형 인터페이스

        List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("1list = " + list);

        List<String> list2 = Arrays.asList("abc","aa","bbb","ddd","aaa");

        Collections.sort(list2 ,(s1,s2)->s2.compareTo(s1));

        System.out.println("2list = " + list2);


        MyFunction f3 = (a,b)->a >b ? a:b; // 인터페스 구현
        aMethod(f3); // 구현 인자 받어서 호출

        aMethod((a,b)->a >b ? a:b);


        System.out.println( getaMethod((a,b)->a >b ? a:b).max(10,50));
    }

    public static void aMethod(MyFunction f){
        System.out.println("aMethod f = " +  f.max(10 , 12));
    }

    public static MyFunction getaMethod(MyFunction f){
        return f;
    }
}