package org.example;

import org.example.fn.MyFunction;

import java.util.function.UnaryOperator;

/**
 * fileName:Main2
 * 작성날짜:2023-07-13
 * desc :
 **/


@FunctionalInterface
interface MyFunction2{
    void run();
}
public class Main2 {

    static void execute(MyFunction2 f){
        f.run();
    }
    static MyFunction2 getMyFunction(){
        MyFunction2 f1 = ()-> System.out.println(" f3.run()");
        return f1;
    }

    public static void main(String[] args) {
        //1
        MyFunction2 f1 = ()-> System.out.println(" f1.run()");

        f1.run();

        MyFunction2 f2 = new MyFunction2() {
            @Override
            public void run() {
                System.out.println(" f2.run()");
            }
        };
        f2.run();

        MyFunction2 f3= getMyFunction();

        f3.run();

        execute(()-> System.out.println(" f4.run()"));

        execute(f1);

        // Runnable
        // Supplier 매개변수 없다 반환값만
        // Consumer<T> 매개변수만 있고 반환값은 없다
        // Function 일반적인 함수  결과 값 반환
        // Predicate<T> 리턴 boolean

        // 매개변수 2개
        // BiConsumer<T,U> 두개 매개변수만 있고 반환값은 없음
        // BiPrddicate<T,U> 조건식 표현 매개변수 둘 , 반환값은 boolean
        // BiFunction<T,U> 결과값 반화

        // 매개변수 타입과 반환타입이 일치하는 함수형
        // UnaryOperator<T> 매개변수와 결과 타입이 같다
        // BinaryOperator<T>
    }
}
