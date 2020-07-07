package com.group.apartment.apartment.jaava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test1 {

    public static void main(String args[]){
        List<String> l = new ArrayList<>();
        l.add("Goat");
        l.add("rat");
        l.add("bat");
        l.add("cow");
       Optional<String> o= l.stream().filter(s -> s.length() == 3).findAny();
      if(o.isPresent())
          System.out.println("the 00 ==>>" +o.get());
    }
}
