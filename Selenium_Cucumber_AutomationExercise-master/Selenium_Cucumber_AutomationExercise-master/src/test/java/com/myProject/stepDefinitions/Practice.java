package com.myProject.stepDefinitions;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        String data = " hello world test even words";
        String[] words = data.split(" ");
        Arrays.stream(words).filter(w -> w.length() % 2 == 0).forEach(System.out::println);
        //reversing a string
        String s = "test reverse";
        String rev ="";
        for(int i = s.length()-1;i>=0;i--)
        {
            rev+=s.charAt(i);
        }
        System.out.println(rev);
        char[] ch1 ={'a','b','c','t'};
        char[] ch2 ={'c','t','a','b'};
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        System.out.println(Arrays.equals(ch1,ch2));
        String a = "hello";
        String b = "world";
        a = a + b;
        b = a.substring(0,a.length()-b.length());
        a = a.substring(b.length());
        System.out.println(a);
        System.out.println(b);
    }
}
