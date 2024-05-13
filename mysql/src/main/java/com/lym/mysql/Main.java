package com.lym.mysql;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] temp ={1,2,3,4,5,6,7,8};
        List<Integer> all = Arrays.asList(temp);
        Collections.shuffle(all);

        System.out.println(Arrays.toString(all.toArray()));
        for (int i=0;i<8;i++){
            System.out.print(all.get(i++) + ",");
            System.out.println(all.get(i));
        }

    }
}