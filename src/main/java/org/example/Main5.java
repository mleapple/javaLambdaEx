package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * fileName:Main5
 * 작성날짜:2023-07-13
 * desc :
 **/
class Person{
    private String name;
    private int age;
    public Person(String name ,int age){
        this.name = name;
        this.age = age;
    }
}
public class Main5 {


 /*   public static List<Person> getList(){
        return x-> new
    }*/

    //  public static void main(String[] args) {
    public static void main (String [] args){
        List<Person> list = new ArrayList<>();
        list.add(new Person("A",12));
        list.add(new Person("b",13));
        list.add(new Person("c",14));
        list.add(new Person("d",15));
        list.add(new Person("e",16));

    }
}
