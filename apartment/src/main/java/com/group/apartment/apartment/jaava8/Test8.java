package com.group.apartment.apartment.jaava8;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Test8 {

    public static void main(String args[]){
        List<String> l = new ArrayList<>();
        l.add("one");
        l.add("two");
        l.add("three");
        l.add("four");
        l.add("five");

      Optional<String> c = l.stream().reduce( (a , b) -> {
           System.out.println("The a ==>" +a);
           System.out.println("The b ==>" +b);
          String cc = a.concat(b);
       return cc;
       });
       System.out.println("The c is ===>"+c);
      int intS =  l.stream().mapToInt(String::length).sum();
      IntStream intStream = l.stream().mapToInt(String::length);
        Function f;
        IntPredicate intPredicate;
        LongPredicate longPredicate;
       // IntToDoubleFunction

        List<Trade> listTrade = new ArrayList<>();
        Trade t = new Trade();
        Trade t1 = new Trade();
        Trade t2= new Trade();
        Trade t3 = new Trade();
        Trade t4 = new Trade();
        t.setCity("iselin");
        t.setName("tucker");
        t.setCurrency("USD");
        listTrade.add(t);
        t1.setCity("vatican");
        t1.setName("rome");
        t1.setCurrency("EUR");
        listTrade.add(t1);

        t2.setCity("edision");
        t2.setName("nj");
        t2.setCurrency("USD");
        listTrade.add(t2);

        t3.setCity("london");
        t3.setName("lon");
        t3.setCurrency("EUR");
        listTrade.add(t3);

        t4.setCity("iselin");
        t4.setName("tucker");
        t4.setCurrency("USD");
        listTrade.add(t4);

      Map<String , List<Trade>> mapTrade =  listTrade.stream().collect(Collectors.groupingBy(Trade::getCurrency));

      mapTrade.entrySet().stream().forEach(
              s -> {System.out.println("The Key ==" + s.getKey());
                    System.out.println("The Value ==" +s.getValue());
              }
      );
        mapTrade.entrySet().stream().count();

        List<String> list = Arrays.asList(new String[]{"ara", "vind", "ra", "go"});
        //list.stream().flatMap(s -> s.concat(s));

    }




}
