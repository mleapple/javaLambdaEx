package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * fileName:Generic001
 * 작성날짜:2023-07-14
 * desc :
 **/
class NonGenericType{
    private Object value;
    public NonGenericType(Object value){
        this.value = value;
    }
    public Object getValue(){
        return value;
    }
}
class GenericType<T>{
    private T t;
    public GenericType(T t){this.t = t;}

    public T getValue(){
        return this.t;
    }
}
class MultiType<K,V>{
    private K k;
    private V v;

    public MultiType(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
class A{ }
class B extends A{}
class C extends B{}

public class Generic001 {
    public static void test001(){
        NonGenericType nonGenericType = new NonGenericType("A");
        String value= (String )nonGenericType.getValue();
        NonGenericType nonGenericType1 = new NonGenericType(1);
        int value2= (int)nonGenericType1.getValue();

    }

    public static void test002(){
        GenericType<String> genericType = new GenericType<>("AAA");
        String value = genericType.getValue();
        GenericType<Integer> genericType1 = new GenericType<>(1);
        int value2 = genericType1.getValue();
    }

    public static void test003(){
       MultiType<Integer,String> multiType = new MultiType<>(1,"kor");
       int n = multiType.getK();
       String s = multiType.getV();
    }

    public static <K,V,R>List getA(MultiType<K,V> multiType,R r){
        List<R> list = new ArrayList<>();
        list.add(r);
        return list;
    }

    public static <K,V,R>List getB(MultiType<K,V>  multiType,R r){
        List<MultiType<K,V> > list = new ArrayList<>();
        list.add(multiType);
        return list;
    }

    public static void getC(GenericType<?> genericType){

    }

    public static void getD(GenericType<? extends B> genericType){

    }
    public static void getE(GenericType<? super B> genericType){

    }

    public static void main(String[] args) {
      List<String> ls  =   getA(new MultiType<Integer , String>(1,"green") , "문자열" );
        System.out.println("ls = " + ls);

        List<MultiType<Integer,String>> ls2  =   getB(new MultiType<Integer , String>(2,"green") , "문자열" );
        System.out.println("ls2="+ls2);
        System.out.println(ls2.get(0).getK());
        System.out.println(ls2.get(0).getV());

        getC(new GenericType<Integer>(11));

        GenericType<A> a = new GenericType<>(new A());
        GenericType<B> b = new GenericType<>(new B());
        GenericType<C> c = new GenericType<>(new C());

        getC(a);
        getC(b);
        getC(c);

        getD(b);
        getD(c);

        getE(a);
        getE(b);

        System.out.println("a = " +a.getValue());
    }
}
