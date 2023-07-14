package org.example;

/**
 * fileName:Lambda001
 * 작성날짜:2023-07-14
 * desc :
 **/

interface Cal{
    int calulate(int a, int b);
}
interface Trace<T>{
    void folloe(T t);
}
interface Trace2{
    void folloe();
}
public class Lambda001 {

    public static int cal2(int x , int y ,Cal cal ){

        return cal.calulate(x ,y );
    }

    public static int calf(int x , int y ,Cal cal ){
        int sum =0;
        for (int i =0 ; i  < 3;i++){
            sum+=cal.calulate(x ,y );
        }
        return sum ;
    }

    public static void  main(String[]args){
        Cal aaa = new Cal(){
            @Override
            public int calulate(int a, int b) {
                return a +b;
            }
        };
        System.out.println("aaa = " +aaa.calulate(2,2));

        Cal aaac = (a,b)->a+b;
        System.out.println("aaac = " + aaac.calulate(1,2));

        Trace<Integer> cc= t->System.out.println(t+1);
        cc.folloe(1999);

        Trace<String> str= t->{ System.out.println(t+"!!!!!!!!");};
        str.folloe("안녕하세요");

        Trace2 str2 = ()->System.out.println("아앙!!!!!!!!");
        str2.folloe();

        cal2(10,10,(a,b)->a+b);

        System.out.println( calf(2, 5,(a,b)->a*b) );

    }



}
